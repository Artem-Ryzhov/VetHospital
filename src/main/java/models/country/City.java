package models.country;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class City {
    private int id;
    private String city_name;
    private int country_id;

    public City() {
    }

    public City(int id, String city_name,int country_id ) {
        this.id = id;
        this.city_name = city_name;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
