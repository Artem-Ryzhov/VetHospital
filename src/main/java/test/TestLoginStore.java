package test;

import store.login.LoginStorage;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.04.16
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class TestLoginStore {
    public static void main(String args []){
        LoginStorage login = new LoginStorage();

        String name = "b2b6";
        String pass = "1992";


       if (login.val(name,pass)){
           System.out.println("LoginServ");
       } else {
           System.out.println("Error");
       }
    }
}
