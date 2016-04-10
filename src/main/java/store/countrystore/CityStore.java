package store.countrystore;

import models.country.City;
import service.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class CityStore  implements ICity{
    private Connection connection;

    public CityStore() {
        connection = DbUtil.getConnection();
    }

    @Override
    public Collection<City> getAllValues() {
        ArrayList<City> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM city;");
            while (resultSet.next()){
                int id = resultSet.getInt("city_id");
                String name = resultSet.getString("city_name");
                int contry_id = resultSet.getInt("country_id");
                list.add(new City(id,name,contry_id));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(City user) {
        return 0;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(City user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public City getById(int id) {
        City city = null;
        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM city\n"  +  "WHERE city.city_id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                city = new City(rs.getInt("city_id"),rs.getString("city_name"),rs.getInt("country_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();              //To change body of catch statement use File | Settings | File Templates.
        }
        return city;
    }

    @Override
    public Collection<City> getAllObjById(int id) {
        ArrayList<City> list = new ArrayList<>();
        City city = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM city\n"  +  "WHERE city.country_id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                city = new City(rs.getInt("city_id"),rs.getString("city_name"),rs.getInt("country_id"));
                //     return person;
                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();              //To change body of catch statement use File | Settings | File Templates.
        }
        return list;
    }

  public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<City> getAllClientsWithSameType(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
