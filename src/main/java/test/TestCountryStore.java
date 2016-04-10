package test;

import models.country.City;
import models.country.Country;
import store.Storage;
import store.countrystore.CityStore;
import store.countrystore.CountryStorage;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class TestCountryStore {

    public static void main(String args []) {

        Storage city  = new CityStore();
        Storage country  = new CountryStorage();



        /*
        Получаем все значения городов их хранилища
         */
        ArrayList<City> list = (ArrayList<City>) city.getAllValues();
        for (int i = 0; i < list.size(); i++){
            City cit = list.get(i);
            System.out.println(cit.toString());
        }

        System.out.println("==============================");

        /*
       Получаем все значения стран их хранилища
        */
        ArrayList<Country> list2 = (ArrayList<Country>) country.getAllValues();
        for (int i = 0; i < list2.size(); i++){
            Country coun = list2.get(i);
            System.out.println(coun.toString());
        }



        City c = (City) city.getById(1);
        System.out.println(c.toString());

        System.out.println("===============================");

        ArrayList<City> list3 = (ArrayList<City>)  city.getAllObjById(1);
        for (int i = 0; i < list3.size(); i++){
            City cit = list3.get(i);
            System.out.println(cit.toString());
        }



    }




}
