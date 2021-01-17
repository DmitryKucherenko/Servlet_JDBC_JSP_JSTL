package controller;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletAbstract extends HttpServlet{
    UserDAO dao;


    @Override
    public void init() throws ServletException {
        this.dao = (UserDAO) getServletContext().getAttribute("DAO");
        super.init();
    }
}
