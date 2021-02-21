package model;

public class User {
    private String first_name;
    private String last_name;
    private int age;
    private int id;
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id,String first_name, String last_name, int age, String login, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(String first_name, String last_name, int age,String login, String password) {
        this(0,first_name, last_name,age,login,password);
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
