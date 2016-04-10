package store.clientstore;

import models.clients.Client;
import models.clients.IClient;
import service.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class ClientStore implements ClientStorage{

    private Connection connection;

    public ClientStore() {
     this.connection  = DbUtil.getConnection();
    }




    public Collection<IClient> getAllValues() {

        final List<IClient> clients = new ArrayList<IClient>();
        final Statement statement; // создали коннект к базе данных
        try {
            statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("SELECT * FROM client;");   // получаем данные по заданному запросу
            while (rs.next()) {    //идем по всем пунктам таблицы

                clients.add(new Client(rs.getInt("id"), rs.getString("name"),rs.getString("lastname"),rs.getInt("phone"),
                        rs.getString("email"),rs.getString("country"),rs.getString("city"),rs.getString("animal"),rs.getString("breed")));
            }

            if (clients.isEmpty()){
                return null;
            }
            return  clients;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("Could not create new user");
    }


    public int add(IClient client){

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT into client (name,lastname,phone,email,country,city,animal,breed)values (?, ?, ?, ?, ?, ?, ?, ? )");
            stmt.setString(1, client.getName());
            stmt.setString(2,client.getLastname());
            stmt.setInt(3,client.getPhone());
            stmt.setString(4,client.getEmail());
            stmt.setString(5,client.getCountry());
            stmt.setString(6,client.getCity());
            stmt.setString(7,client.getAnimal());
            stmt.setString(8,client.getBreed());
            // stmt.setDate(5, new java.sql.Date(user.getDob().getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
            return client.getId();
        }






    public int addClient(IClient client){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT into client (id,name,lastname,phone,email,country,city,animal,breed)values (?, ?, ?, ?, ?, ?, ?, ?,? )");
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getName());
            stmt.setString(3,client.getLastname());
            stmt.setInt(4,client.getPhone());
            stmt.setString(5,client.getEmail());
            stmt.setString(6,client.getCountry());
            stmt.setString(7,client.getCity());
            stmt.setString(8,client.getAnimal());
            stmt.setString(9,client.getBreed());
            // stmt.setDate(5, new java.sql.Date(user.getDob().getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return client.getId();
    }






    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE from client where id =?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(IClient user) {
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE  client SET name=?, lastname=?,phone=?,email=?,country=?,city=?,animal=?,breed=? WHERE id =?")) {
            // statement.setInt(1,user.getId());
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setInt(3,user.getPhone());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getCountry());
            statement.setString(6,user.getCity());
            statement.setString(7,user. getAnimal());
            statement.setString(8,user.getBreed());
            statement.setInt(9,user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IClient getById(int id) {
        IClient client = null;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM client\n"  +  "WHERE id = (?)");
            statement.setInt(1,id);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                client = new Client(rs.getInt("id"), rs.getString("name"),rs.getString("lastname"),rs.getInt("phone"),
                        rs.getString("email"),rs.getString("country"),rs.getString("city"),rs.getString("animal"),rs.getString("breed"));
                //     return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }




    public Collection<IClient> getAllClientsWithSameType(String type) {
        final List<IClient> list = new ArrayList<IClient>();
        IClient client;

        final PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT  * " +  "FROM client\n"  +  "WHERE animal = (?)");
            statement.setString(1,type);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                client = new Client(rs.getInt("id"), rs.getString("name"),rs.getString("lastname"),rs.getInt("phone"),
                        rs.getString("email"),rs.getString("country"),rs.getString("city"),rs.getString("animal"),rs.getString("breed"));
                //     return person;

                list.add(client);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Collection<IClient> getAllObjById(int id) {
        return null;
    }


    public void deleteAll(){
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE from client")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Could not create new user");
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
