package models.animals;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class Annimal  implements Pets{

    private int id;
    private String name;

    public Annimal() {
    }

    public Annimal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
