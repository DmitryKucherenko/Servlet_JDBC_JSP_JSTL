package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    public static ResultSet select(Connection conn , String sql){
        ResultSet rs = null;
        Statement stmt = null;
       try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            stmt.close();
       }catch (SQLException throwables) {
           throwables.printStackTrace();
       }

       return rs;

    }

    public static void executeSql(Connection conn , String sql){
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
