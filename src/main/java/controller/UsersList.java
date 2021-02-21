package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class UsersList extends ServletAbstract {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = dao.getAll();
        request.getSession().getAttribute("USER");
        request.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
    }
}
