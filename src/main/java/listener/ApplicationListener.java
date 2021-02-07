package listener;

import dao.UserDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

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

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        UserDAO dao = new UserDAO(dataSource);
        sce.getServletContext().setAttribute("DAO",dao);




    }



}
