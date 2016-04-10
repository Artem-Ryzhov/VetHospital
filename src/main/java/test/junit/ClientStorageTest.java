package test.junit;

import models.clients.Client;
import models.clients.IClient;
import org.junit.Test;
import store.clientstore.ClientStore;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 08.04.16
 * Time: 1:44
 * To change this template use File | Settings | File Templates.
 */
public class ClientStorageTest {

    @Test
    public void checkReturnValues() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();
        assertNull(storage.getAllValues());
        storage.addClient(new Client("artem","ryzhov",123,"er","ukrain","df","df","dfdff"));
        assertNotNull(storage.getAllValues());
    }
    @Test
    public void ckeckGetUserByID() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();
        storage.addClient(new Client(1, "artem", "ryzhov", 123, "er", "ukrain", "df", "df", "dfdff"));
        assertEquals(1,storage.getAllValues().size());
        storage.addClient(new Client(2, "artem", "ryzhov", 123, "er", "ukrain", "df", "df", "dfdff"));
        storage.addClient(new Client(3, "artem", "ryzhov", 123, "er", "ukrain", "df", "df", "dfdff"));
        assertEquals(3,storage.getAllValues().size());
    }

    @Test
    public void checkClients() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();

        IClient client = new Client();
        IClient client2 = new Client();
        client.setId(1);
        client.setName("m");
        client.setLastname("m");
        client.setEmail("m");
        client.setPhone(333);
        client.setAnimal("m");
        client.setBreed("m");

        int id = storage.addClient(client);
        client2 = (IClient) storage.getById(id);
        assertEquals(client,client2);
    }


    @Test
    public void checkDeleteAlll() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();

        IClient client = new Client();
        IClient client2 = new Client();
        client.setId(1);
        client.setName("m");
        client.setLastname("m");
        client.setEmail("m");
        client.setPhone(333);
        client.setAnimal("m");
        client.setBreed("m");

        client2.setId(2);
        client2.setName("k");
        client2.setLastname("k");
        client2.setEmail("k");
        client2.setPhone(333);
        client2.setAnimal("k");
        client2.setBreed("k");

        storage.addClient(client);
        storage.addClient(client2);

        assertEquals(2, storage.getAllValues().size());

        storage.deleteAll();
        assertEquals(null,storage.getAllValues());
    }



    @Test
    public void checDeleteUserByIdl() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();

        IClient client = new Client();
        IClient client2 = new Client();
        IClient client3 = new Client();
        IClient client4 = new Client();

        client.setId(1);
        client.setName("m");
        client.setLastname("m");
        client.setEmail("m");
        client.setPhone(333);
        client.setAnimal("m");
        client.setBreed("m");

        client2.setId(2);
        client2.setName("k");
        client2.setLastname("k");
        client2.setEmail("k");
        client2.setPhone(333);
        client2.setAnimal("k");
        client2.setBreed("k");

        int first = storage.addClient(client);
        int second = storage.addClient(client2);

        assertEquals(2,storage.getAllValues().size());

        storage.delete(first);
        assertEquals(1, storage.getAllValues().size());

        client3 =  storage.getById(first);
        client4 = storage.getById(second);

        assertEquals(client3,null);
        System.out.println(client4.toString());
        assertNotNull(client4);

    }


    @Test
    public void testUpdateUser() throws Exception{
        final ClientStore storage = new ClientStore();
        storage.deleteAll();

        IClient client = new Client();
        IClient client2 = new Client();
        client.setId(1);
        client.setName("m");
        client.setLastname("m");
        client.setEmail("m");
        client.setPhone(333);
        client.setAnimal("m");
        client.setBreed("m");

       int first =  storage.addClient(client);
        System.out.println(client.getName());
        String name = "mars";
        client.setName(name);


        storage.edit(client);

        client2 = storage.getById(first);
        assertEquals(client2.getName(),name);
        System.out.println(client2.getName());

      //  storage.deleteAll();

    }




}
