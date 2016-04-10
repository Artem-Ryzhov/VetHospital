package test;

import models.animals.Breed;
import store.Storage;
import store.animalstore.BreedStorage;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class TestBreedStorage {

    public static void main(String args []){
        Storage storage = new BreedStorage();

        ArrayList<Breed> list  = (ArrayList<Breed>) storage.getAllValues();
        for (int i = 0; i < list.size(); i++){
            Breed breeed = list.get(i);
            System.out.println(breeed.toString());
        }
    }
}
