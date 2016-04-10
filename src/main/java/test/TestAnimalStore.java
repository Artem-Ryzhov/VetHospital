package test;

import models.animals.Pets;
import store.animalstore.AnimalStorage;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */
public class TestAnimalStore {

    public static void main(String args []){
        AnimalStorage store = new AnimalStorage();
        ArrayList<Pets> list = (ArrayList<Pets>) store.getAllValues();
        for (int i = 0; i < list.size(); i++){
            Pets annimal = list.get(i);
            System.out.println(annimal.toString());
        }

        System.out.println("-------------------");

        ArrayList<Pets> breeds = (ArrayList<Pets>) store.getAllObjById(1);
        for (int i = 0; i < breeds.size(); i++){
            Pets breed = breeds.get(i);
            System.out.println(breed.getName()+  " " + breed.getId());
        }


ArrayList<Pets> type = (ArrayList<Pets>) store.getByType("Dog");
        for (int i = 0; i < breeds.size(); i++){
            Pets breed = breeds.get(i);
            System.out.println(breed.getName()+  " " + breed.getId());
        }

    }
}
