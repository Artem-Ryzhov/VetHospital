package test;

import models.login.Login;
import store.login.LoginStorage;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 07.04.16
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class TestLoginStorage {
    public static void main (String args []){
        LoginStorage storage = new LoginStorage();
        Login login = storage.getLogin();
        System.out.println(login.toString());
    }
}
