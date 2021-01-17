package dao;

import model.User;
import jdbc.JDBCUtils;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection connection;


    public UserDAO(Connection connection){
        this.connection =connection;
    }

    public UserDAO(ServletContext servletContext) {
        this.connection = (Connection)servletContext.getAttribute("CONNECTION");
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        ResultSet rs = JDBCUtils.select(connection,"SELECT * FROM users");
        try {
            if (rs!=null)
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age"))));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return users;
    }

    public void deleteUser(String id){
        JDBCUtils.executeSql(connection,"DELETE FROM users WHERE id="+id);
    }

    public void updateUser(String id, String last_name, String first_name, String age){
        String query = String.format("UPDATE users  set first_name='%s', last_name='%s', age=%s WHERE id=%s",first_name,last_name,age,id);
        JDBCUtils.executeSql(connection,query);
    }

    public void insertUser( String last_name, String first_name, String age){
        String query = String.format("INSERT INTO users VALUES('%s','%s','%s')",first_name,last_name,age);
        JDBCUtils.executeSql(connection,query);
    }

    public User userById(String id){
        ResultSet rs =  JDBCUtils.select(connection,"SELECT * FROM users WHERE id="+id);
        User user = null;
        try {
            rs.next();
            user = new User(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), Integer.parseInt(rs.getString("age")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
