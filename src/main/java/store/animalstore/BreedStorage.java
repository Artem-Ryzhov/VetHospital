package store.animalstore;

import models.animals.Breed;
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
public class BreedStorage implements IAnimalStorage{

    private Connection connection;

    public BreedStorage() {
        this.connection = DbUtil.getConnection();
    }

    @Override
    public Collection<Pets> getAllValues() {
          final List<Pets> annimals = new ArrayList<Pets>();
        final Statement statement; // создали коннект к базе данных
        try {
            statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT * FROM breed;");   // получаем данные по заданному запросу
            while (rs.next()) {    //идем по всем пунктам таблицы

                annimals.add(new Breed(rs.getInt("id"),rs.getString("type"),rs.getInt("animal_id")));
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
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void edit(Pets user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pets getById(int id) {
        Breed breed = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM breed\n"  +  "WHERE id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                breed = new Breed(rs.getInt("id"),rs.getString("type"),rs.getInt("animal_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breed;
    }

    @Override
    public Collection<Pets> getAllObjById(int id) {
           ArrayList<Pets> list = new ArrayList<>();
        Breed breed = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM breed\n"  +  "WHERE animal_id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                breed = new Breed(rs.getInt("id"),rs.getString("type"),rs.getInt("animal_id"));
                //     return person;
                list.add(breed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Collection<Pets> getAllClientsWithSameType(String type) {
        return null;
    }
}
