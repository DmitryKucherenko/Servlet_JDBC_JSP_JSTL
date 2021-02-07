package dao;

import model.User;
import jdbc.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    DataSource dataSource;

    public UserDAO(DataSource dataSource){
        this.dataSource=dataSource;
    }


    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            ResultSet rs = JDBCUtils.executeSql(connection, "SELECT  users.id, users.first_name, users.last_name, users.age, pass.login, pass.password FROM users INNER JOIN pass ON users.id=pass.id");

            if (rs != null)
                while (rs.next())
                    users.add(new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age")),rs.getString("login"),rs.getString("password")));


        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return users;
    }

    public void deleteUser(String id){
        try(Connection connection = dataSource.getConnection()) {
            JDBCUtils.executeSql(connection, "DELETE FROM users WHERE id=" + id);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void updateUser(String id, String last_name, String first_name, String age,String login, String password){
        try(Connection connection = dataSource.getConnection()) {
        String query = String.format("UPDATE users  set first_name='%s', last_name='%s', age=%s WHERE id=%s",first_name,last_name,age,id);
        String query2 = String.format("UPDATE pass  set login='%s', password='%s' WHERE id=%s",login,password,id);
        JDBCUtils.executeSql(connection,query);
        JDBCUtils.executeSql(connection,query2);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void insertUser( String last_name, String first_name, String age, String login, String password){
        try(Connection connection = dataSource.getConnection()) {
        String query = String.format("INSERT INTO users VALUES('%s','%s','%s') RETURNING id",first_name,last_name,age);
            ResultSet resultSet=JDBCUtils.executeSql(connection,query);
            resultSet.next();
        String id =resultSet.getString("id");
        String query2 = String.format("INSERT INTO pass(id,password,login) VALUES('%s','%s','%s')",id,password,login);
            JDBCUtils.executeSql(connection,query2);

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public User getById(String id){
        User user = null;
        try(Connection connection = dataSource.getConnection()) {
        ResultSet rs =  JDBCUtils.executeSql(connection,"SELECT users.id, users.first_name, users.last_name, users.age, pass.login, pass.password FROM users INNER JOIN pass ON users.id=pass.id WHERE users.id="+id);
            rs.next();
            user = new User(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age")),rs.getString("login"),rs.getString("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }


    public boolean checkUser(String login, String pass){
        if(login==null || pass == null)return false;
        for(User user:getAllUsers()){
           if(user.getLogin().equals(login)&&user.getPassword().equals(pass))
               return true;
        }
        return false;
    }


}
