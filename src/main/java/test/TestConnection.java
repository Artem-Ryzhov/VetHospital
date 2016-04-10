package test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static junit.framework.Assert.assertNull;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 20.02.16
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class TestConnection {


    @Test
    public void testConnection() throws Exception {
     //   final JdbcStorage storage = new JdbcStorage();
        String url =  "jdbc:postgresql://localhost:5432/emp";
        String nick =  "postgres";
        String password = "1993";
        Connection connection = DriverManager.getConnection(url, nick, password);
  //      storage.close();
     //   connection = storage.getCon();
        connection.close();
        assertNull(connection);

    }

}
