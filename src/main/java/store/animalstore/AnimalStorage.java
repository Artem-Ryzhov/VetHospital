package store.animalstore;

import models.animals.Annimal;
import models.animals.Pets;
import service.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
public class AnimalStorage implements IAnimalStorage{
    private Connection connection;

    public AnimalStorage() {
        this.connection  = DbUtil.getConnection();
    }

    @Override
    public Collection<Pets> getAllValues() {
        final List<Pets> annimals = new ArrayList<Pets>();
        final Statement statement; // создали коннект к базе данных
        try {
            statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT * FROM animal;");   // получаем данные по заданному запросу
            while (rs.next()) {    //идем по всем пунктам таблицы

                annimals.add(new Annimal(rs.getInt("id"),rs.getString("type")));
            }
            if (annimals.isEmpty()){
                return null;
            }
            return  annimals;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public int add(Pets user) {
        return 0;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(Pets user) {

    }

    @Override
    public Pets getById(int id) {
        Pets breed = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM animal\n"  +  "WHERE id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                breed = new Annimal(rs.getInt("id"),rs.getString("type"));
                //     return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();              //To change body of catch statement use File | Settings | File Templates.
        }
        return breed;
    }



    public Collection<Pets>  getByType(String type) {
        final List<Pets> list = new ArrayList<Pets>();
        Pets breed = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM animal\n"  +  "WHERE type = (?)");
            statement.setString(1,type);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                breed = new Annimal(rs.getInt("id"),rs.getString("type"));
                //     return person;
                list.add(breed);
            }
        } catch (SQLException e) {
            e.printStackTrace();              //To change body of catch statement use File | Settings | File Templates.
        }
        return list;
    }





    @Override
    public Collection<Pets> getAllObjById(int id) {
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
    public Collection<Pets> getAllClientsWithSameType(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
