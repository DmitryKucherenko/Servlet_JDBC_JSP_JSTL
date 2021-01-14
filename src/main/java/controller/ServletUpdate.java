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

@WebServlet("/update")
public class ServletUpdate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        String age = request.getParameter("age");

        DBDATA dbdata = new DBDATA(getServletContext());
        dbdata.updateUser(id, last_name, first_name, age);
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DBDATA dbdata = new DBDATA(getServletContext());
        User user = dbdata.userById(id);
        getServletContext().setAttribute("user",user);
        getServletContext().getRequestDispatcher("/WEB-INF/view/update.jsp").forward(request,response);
    }
}
