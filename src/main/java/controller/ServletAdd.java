package controller;

import model.DBDATA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/add")
public class ServletAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String age = request.getParameter("age");

        DBDATA dbdata = new DBDATA(getServletContext());
        dbdata.insertUser(last_name,first_name,age);

        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
