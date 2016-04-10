package com.devcolibri.servlet;

import models.login.Login;
import store.login.LoginStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.04.16
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class LoginServ extends HttpServlet {
    private LoginStorage storage = new LoginStorage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login login  = storage.getLogin();
        request.setAttribute("name",login.getName());
        request.setAttribute("password",login.getPassword());
        request.getRequestDispatcher("/views/logo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean val = false;
        String user = request.getParameter("username");
        String password = request.getParameter("userpass");
        val = storage.val(user,password);
        if(val){
            RequestDispatcher rd=request.getRequestDispatcher("/views/menu.jsp");
            rd.forward(request,response);
        }
    }
}