package ss17_binary_serialization.thuc_hanh.thuc_hanh2;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String addres;

    public Student() {

    }

    public Student(int id, String name, String addres) {
        this.id = id;
        this.name = name;
        this.addres = addres;
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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
