package thi_thu_c10.model;

public class Student extends Person {
    private String classPerson;
    private Double score;

    public Student() {
    }

    public Student(String classPerson, Double score) {
        this.classPerson = classPerson;
        this.score = score;
    }

    public Student(String id, String name, String dateOfBirth, String gender, String classPerson, Double score) {
        super(id, name, dateOfBirth, gender);
        this.classPerson = classPerson;
        this.score = score;
    }

    public String getClassPerson() {
        return classPerson;
    }

    public void setClassPerson(String classPerson) {
        this.classPerson = classPerson;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "classPerson='" + classPerson + '\'' +
                ", score=" + score +
                '}';
    }
}
