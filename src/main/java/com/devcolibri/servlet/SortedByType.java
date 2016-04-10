package com.devcolibri.servlet;

import models.animals.Pets;
import models.clients.IClient;
import store.Storage;
import store.animalstore.AnimalStorage;
import store.clientstore.ClientStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 07.04.16
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class SortedByType extends HttpServlet {
    private Storage animalStorage = new AnimalStorage();
    private ClientStore clientstore = new ClientStore();
    private IClient client;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pets> pets = (List<Pets>) animalStorage.getAllValues();
        request.setAttribute("pets", pets);
        request.getRequestDispatcher("/views/SortByType.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("animal"));
        Pets pet = (Pets) animalStorage.getById(type);
        request.setAttribute("client", clientstore.getAllClientsWithSameType(pet.getName()));
        request.getRequestDispatcher("/views/Show.jsp").forward(request, response);
    }



}
