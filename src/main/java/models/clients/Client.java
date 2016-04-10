package models.clients;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class Client implements IClient{
    private int id;
    private String name;
    private String lastname;
    private int phone;
    private String email;
    private String country;
    private String city;
    private String animal;
    private String breed;

    public Client() {
    }



    public Client(int id, String name, String lastname, int phone, String email, String country, String city, String animal, String breed) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.city = city;
        this.animal = animal;
        this.breed = breed;
    }

    public Client( String name, String lastname, int phone, String email, String country, String city, String animal, String breed) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.city = city;
        this.animal = animal;
        this.breed = breed;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }



@Override
    public boolean equals(Object obj) {
        if (this == obj){
            return  true;
        }
        if (obj == null){
            return false;
        }
        Client client = (Client) obj;
        if (id!=client.id){
            return false;
        }
        if (!this.getName().equals(((Client) obj).getName())){
            return false;
        }
        if (this.getId()!= ((Client) obj).getId()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        return result;
    }






    @Override
    public String toString() {
        return "Client{" +
                "userid=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", animal='" + animal + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }



}
