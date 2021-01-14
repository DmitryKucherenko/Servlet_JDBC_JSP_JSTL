package model;

import entity.User;
import jdbc.JDBCUtils;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBDATA {
    Connection conn;
    List<User> users = new ArrayList<>();
    public DBDATA(ServletContext context){
        this.conn=(Connection)context.getAttribute("CONNECTION");

    }

    public List<User> getAllUsers(){
        ResultSet rs = JDBCUtils.select(conn,"SELECT * FROM users");
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
        JDBCUtils.executeSql(conn,"DELETE FROM users WHERE id="+id);
    }
    public void updateUser(String id, String last_name, String first_name, String age){
        String query = String.format("UPDATE users  set first_name='%s', last_name='%s', age=%s WHERE id=%s",first_name,last_name,age,id);
        JDBCUtils.executeSql(conn,query);
    }

    public void insertUser( String last_name, String first_name, String age){
        String query = String.format("INSERT INTO users VALUES('%s','%s','%s')",first_name,last_name,age);
        JDBCUtils.executeSql(conn,query);
    }

    public User userById(String id){
        ResultSet rs =  JDBCUtils.select(conn,"SELECT * FROM users WHERE id="+id);
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
