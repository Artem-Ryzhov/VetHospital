package service;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 24.02.16
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */
public class DbUtil {

      private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            //  Connection c = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/emp",
                                "postgres", "1993");
                System.out.println("Opened database successfully");

                //  connection.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            return connection;
        }
    }
}
