package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class ServletUpdate extends ServletAbstract {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        String age = request.getParameter("age");


        dao.updateUser(id, last_name, first_name, age);
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user=  dao.userById(id);
        request.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/WEB-INF/view/update.jsp").forward(request,response);
    }
}
