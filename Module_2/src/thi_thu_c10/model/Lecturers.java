package thi_thu_c10.model;

public class Lecturers extends Person{
    private String specialize;

    public Lecturers() {
    }

    public Lecturers(String specialize) {
        this.specialize = specialize;
    }

    public Lecturers(String id, String name, String dateOfBirth, String gender, String specialize) {
        super(id, name, dateOfBirth, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                super.toString() +
                "specialize='" + specialize + '\'' +
                '}';
    }
}
