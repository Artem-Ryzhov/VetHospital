package com.devcolibri.servlet;

import models.animals.Pets;
import models.country.Location;
import store.Storage;
import store.animalstore.AnimalStorage;
import store.countrystore.CountryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class AddCountry extends HttpServlet {
    private Storage countrystore = new CountryStorage();
    private Storage animalStorage = new AnimalStorage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Location> country = (List<Location>) countrystore.getAllValues();
        List<Pets> pets = (List<Pets>) animalStorage.getAllValues();
        request.setAttribute("country", country);
        request.setAttribute("pets", pets);

        request.getRequestDispatcher("/views/AddClient.jsp").forward(request, response);
    }
}
