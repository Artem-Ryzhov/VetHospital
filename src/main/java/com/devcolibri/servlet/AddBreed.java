package com.devcolibri.servlet;

import models.animals.Pets;
import store.Storage;
import store.animalstore.BreedStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
public class AddBreed extends HttpServlet {
     private Storage breedstore = new BreedStorage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html:charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Pets> breeds = (ArrayList<Pets>)  breedstore.getAllObjById(id);

        PrintWriter out = response.getWriter();
        response.getWriter().write("Breed : <select name = 'bre'>" );
        for (int i = 0; i < breeds.size(); i++){
            response.getWriter().write("<option value = '"+ breeds.get(i).getId() +"'  >" + breeds.get(i).getName() + "</option>");
        }
         response.getWriter().write("</select>");
    }

}

