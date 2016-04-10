package store.countrystore;

import models.country.Country;
import service.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class CountryStorage implements ICountry{
    private Connection connection;

    public CountryStorage() {
        this.connection = DbUtil.getConnection();
    }

    @Override
    public Collection<Country> getAllValues(){
        ArrayList<Country> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM country;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("country_name");
                list.add(new Country(id,name));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Country user) {
        return 0;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(Country user) {

    }

    @Override
    public Country getById(int id) {
        Country country = null;
        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM country\n"  +  "WHERE id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                country = new Country(rs.getInt("id"),rs.getString("country_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public Collection<Country> getAllObjById(int id) {
        return null;
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Country> getAllClientsWithSameType(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
