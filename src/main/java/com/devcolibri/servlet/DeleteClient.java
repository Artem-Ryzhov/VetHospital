package com.devcolibri.servlet;

import models.clients.IClient;
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
 * Date: 06.04.16
 * Time: 1:51
 * To change this template use File | Settings | File Templates.
 */
public class DeleteClient extends HttpServlet {

    private IClient client;
    private Storage clientstore = new ClientStore();

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clientstore.delete(id);
        resp.sendRedirect(String.format("%s%s", request.getContextPath(), "/clientview"));
    }
}
