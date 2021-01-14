package controller;

import entity.User;
import model.DBDATA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/")
public class UsersList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBDATA dbData = new DBDATA(getServletContext());
        List<User> users = dbData.getAllUsers();
        request.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
    }
}
