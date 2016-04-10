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
 * Date: 06.04.16
 * Time: 2:29
 * To change this template use File | Settings | File Templates.
 */
public class DeleteAllClient extends HttpServlet {

    Storage storage = new ClientStore();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.storage.deleteAll();
        response.sendRedirect(String.format("%s%s", request.getContextPath(),"/clientview"));
    }
}
