package com.devcolibri.servlet;

import models.animals.Pets;
import models.clients.Client;
import models.clients.IClient;
import models.country.City;
import models.country.Country;
import store.Storage;
import store.animalstore.AnimalStorage;
import store.animalstore.BreedStorage;
import store.clientstore.ClientStore;
import store.countrystore.CityStore;
import store.countrystore.CountryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 0:32
 * To change this template use File | Settings | File Templates.
 */
public class AddClient extends HttpServlet {
    private Storage animalstore = new AnimalStorage();
    private Storage breedstore = new BreedStorage();
    private Storage counry = new CountryStorage();
    private Storage citystore = new CityStore();
    private Storage clientstore = new ClientStore();
    private IClient client;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));

        int c = Integer.parseInt(request.getParameter("cou"));
        Country country = (Country) counry.getById(c);
        int cit = Integer.parseInt(request.getParameter("cit"));
        City city  = (City) citystore.getById(cit);

        int type = Integer.parseInt(request.getParameter("animal"));
        Pets pet = (Pets) animalstore.getById(type);
        int bred  = Integer.parseInt(request.getParameter("bre"));
        Pets breed  = (Pets) breedstore.getById(bred);
        client = new Client(name,lastname,phone,email,country.getCounty_name(),city.getCity_name(),pet.getName(),breed.getName());

        clientstore.add(client);
        response.sendRedirect(String.format("%s%s", request.getContextPath(),"/clientview"));
    }
}
