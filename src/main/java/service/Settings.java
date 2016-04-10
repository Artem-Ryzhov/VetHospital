package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 11.02.16
 * Time: 1:49
 * To change this template use File | Settings | File Templates.
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();
     private static Connection connection = null;

	private final Properties properties = new Properties();


	private Settings() {
		try {
			properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("/../resources/db.properties").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static synchronized  Settings getInstance() {
		return INSTANCE;
	}

	public String value(String key) {
		return this.properties.getProperty(key);
	}
}
