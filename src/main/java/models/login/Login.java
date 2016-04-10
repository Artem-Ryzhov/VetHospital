package models.login;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 07.04.16
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class Login {
    private int id;
    private String name;
    private String password;

    public Login() {
    }

    public Login(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
