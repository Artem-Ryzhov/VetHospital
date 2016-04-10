package models.clients;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 05.04.16
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public interface IClient {
    public int getId();
    public void setId(int id);

    public String getName();
    public void setName(String name);
    public String getLastname();

    public void setLastname(String lastname);

    public String getEmail();

    public void setEmail(String email);

    public String getCountry();

    public void setCountry(String country);

    public String getCity();

    public void setCity(String city);
    public String getAnimal();

    public void setAnimal(String animal);
    public String getBreed();

    public void setBreed(String breed);

    public int getPhone();

    public void setPhone(int phone);



}
