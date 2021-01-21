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
            ResultSet rs = JDBCUtils.select(connection, "SELECT * FROM users");

            if (rs != null)
                while (rs.next())
                    users.add(new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age"))));


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

    public void updateUser(String id, String last_name, String first_name, String age){
        try(Connection connection = dataSource.getConnection()) {
        String query = String.format("UPDATE users  set first_name='%s', last_name='%s', age=%s WHERE id=%s",first_name,last_name,age,id);
        JDBCUtils.executeSql(connection,query);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void insertUser( String last_name, String first_name, String age){
        try(Connection connection = dataSource.getConnection()) {
        String query = String.format("INSERT INTO users VALUES('%s','%s','%s')",first_name,last_name,age);
        JDBCUtils.executeSql(connection,query);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public User userById(String id){
        User user = null;
        try(Connection connection = dataSource.getConnection()) {
        ResultSet rs =  JDBCUtils.select(connection,"SELECT * FROM users WHERE id="+id);
            rs.next();
            user = new User(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
