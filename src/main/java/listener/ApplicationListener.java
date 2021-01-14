package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        Properties applicationProperties =null;
        try(InputStream in = ApplicationListener.class.getClassLoader().getResourceAsStream("application.properties")){
            applicationProperties = new Properties();
            applicationProperties.load(in);
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
        String driver = applicationProperties.getProperty("db.driver");
        String url = applicationProperties.getProperty("db.url");
        String userName = applicationProperties.getProperty("db.username");
        String password = applicationProperties.getProperty("db.password");


        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, userName, password);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sce.getServletContext().setAttribute("CONNECTION",conn);

    }

}
