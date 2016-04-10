package com.devcolibri.servlet;

import store.Storage;
import store.clientstore.ClientStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 1:10
 * To change this template use File | Settings | File Templates.
 */
public class ClientView extends HttpServlet {

    private Storage clientstorage = new ClientStore();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("client",clientstorage.getAllValues());
        request.getRequestDispatcher("/views/ClientView.jsp").forward(request, response);
    }
}
