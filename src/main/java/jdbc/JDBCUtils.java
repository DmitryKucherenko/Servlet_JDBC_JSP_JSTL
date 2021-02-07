package jdbc;

import java.sql.*;

public class JDBCUtils {
    public static ResultSet executeSql(Connection conn , String sql)throws SQLException{
       PreparedStatement ps = conn.prepareStatement(sql);
       return ps.executeQuery();
    }


}
