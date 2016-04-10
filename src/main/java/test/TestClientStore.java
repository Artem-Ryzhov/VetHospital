package test;

import models.clients.Client;
import models.clients.IClient;
import store.Storage;
import store.animalstore.AnimalStorage;
import store.clientstore.ClientStore;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class TestClientStore {


    public static void main(String args []) {
        Storage store = new ClientStore();
        Storage animalStorage = new AnimalStorage();




        IClient client = new Client();
        IClient client2 = new Client();
       //store.deleteAll();


        //   System.out.println(client.toString());
       //client.setId(1);
        client.setName("m");
        client.setLastname("m");
        client.setEmail("m");
        client.setPhone(333);
        client.setAnimal("m");
        client.setBreed("m");

        int id = store.add(client);

       client2 = (IClient) store.getById(id);

    //    System.out.println(client2.equals(client));
        System.out.println("+++++++++++++++++++++++++++++++++");



        ArrayList<IClient> list = (ArrayList<IClient>) store.getAllValues();
        for (int i = 0; i < list.size(); i++){
            IClient c = list.get(i);
            System.out.println(c.toString());
        }



    }

}
