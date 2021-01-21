package jdbc;

import java.sql.*;

public class JDBCUtils {
    public static ResultSet select(Connection conn , String sql)throws SQLException{
       PreparedStatement ps = conn.prepareStatement(sql);
       return ps.executeQuery();
    }

    public static void executeSql(Connection conn , String sql)throws SQLException{
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
    }
}
