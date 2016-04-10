package com.devcolibri.servlet;

import models.animals.Pets;
import models.clients.IClient;
import models.country.City;
import models.country.Country;
import store.Storage;
import store.animalstore.AnimalStorage;
import store.animalstore.BreedStorage;
import store.clientstore.ClientStore;
import store.countrystore.CityStore;
import store.countrystore.CountryStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.04.16
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
public class UpdateClient  extends HttpServlet {

    private Storage countrystore = new CountryStorage();
    private Storage animalStorage = new AnimalStorage();
    private Storage breedstore = new BreedStorage();
    private Storage citystore = new CityStore();
    private Storage counry = new CountryStorage();
    private Storage clientstore = new ClientStore();
    private IClient client;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Country> country = (List<Country>) countrystore.getAllValues();
        List<Pets> pets = (List<Pets>) animalStorage.getAllValues();
        request.setAttribute("country", country);
        request.setAttribute("pets", pets);
        int id = Integer.parseInt(request.getParameter("id"));
        client = (IClient) clientstore.getById(id);
        request.setAttribute("client", client );
       // countrystore.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/EditClient.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));

        int c = Integer.parseInt(request.getParameter("id"));
        Country country = (Country) counry.getById(c);
        int cit = Integer.parseInt(request.getParameter("cit"));
        City city  = (City) citystore.getById(cit);

        int type = Integer.parseInt(request.getParameter("animal"));
        Pets pet = (Pets) animalStorage.getById(type);
        int bred  = Integer.parseInt(request.getParameter("bre"));
        Pets breed  = (Pets) breedstore.getById(bred);
        client.setName(name);
        client.setLastname(lastname);
        client.setEmail(email);
        client.setPhone(phone);
        client.setCountry(country.getCounty_name());
        client.setCity(city.getCity_name());
        client.setAnimal(pet.getName());
        client.setBreed(breed.getName());
        clientstore.edit(client);
        response.sendRedirect(String.format("%s%s", request.getContextPath(),"/clientview"));

    }

}
