package models.country;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class Country {
    private int id;
    private String county_name;

    public Country() {
    }

    public Country(int id, String county_name) {
        this.id = id;
        this.county_name = county_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", county_name='" + county_name + '\'' +
                '}';
    }
}
