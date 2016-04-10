package store.login;

import models.login.Login;
import service.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.04.16
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class LoginStorage {
    private Connection connection;

    public LoginStorage() {
        this.connection  = DbUtil.getConnection();
    }

    public boolean val(String name,String password){
        boolean val = false;
        final Statement statement; // создали коннект к базе данных
        try {
            statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from login");
            while (rs.next()) {    //идем по всем пунктам таблицы
                String user = rs.getString("name");
                String pass = rs.getString("password");
                if(validation(name,password,user,pass)){
                    val = true;
                }
            }
            return val;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not login");

    }




    private boolean validation(String name,String password ,String user,String pass){
        if (name.equals(user) && password.equals(pass)){
            return true;
        }    else
            return false;
    }



    public Login getLogin() {
        Login login = null;
        final Statement statement; // создали коннект к базе данных
        try {
            statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT * FROM login;");   // получаем данные по заданному запросу
            while (rs.next()) {    //идем по всем пунктам таблицы
                login = new Login(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
            }

            return  login;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("Could not create new user");
    }






}

/*
<form action="/login" method="post">
   <fieldset style="width: 300px">
       <legend> LoginServ to App </legend>
       <table>
           <tr>
               <td>LoginServ</td>
               <td><input type="text" name="username" required="required" /></td>
           </tr>
           <tr>
               <td>Password</td>
               <td><input type="password" name="userpass" required="required" /></td>
           </tr>
           <tr>
               <td><input type="submit" value="LoginServ" /></td>
           </tr>
       </table>
   </fieldset>
</form>

*/