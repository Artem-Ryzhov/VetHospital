package models.animals;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class Breed  implements Pets{
    private int id;
    private String type;
    private int animal_id;

    public Breed() {
    }

    public Breed(int id, String name, int animal_id) {
        this.id = id;
        this.type = name;
        this.animal_id = animal_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return type;
    }

    @Override
    public void setName(String name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", animal_id=" + animal_id +
                '}';
    }
}
