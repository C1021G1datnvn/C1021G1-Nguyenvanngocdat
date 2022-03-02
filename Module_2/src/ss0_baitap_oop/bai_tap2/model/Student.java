package ss0_baitap_oop.bai_tap2.model;

public class Student implements Comparable<Student> {
    private int mssV;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nameClass;
    private String course;

    public Student() {

    }

    public Student(int mssV, String name, String dateOfBirth, String gender, String nameClass, String course) {
        this.mssV = mssV;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nameClass = nameClass;
        this.course = course;
    }

    public int getMssV() {
        return mssV;
    }

    public void setMssV(int mssV) {
        this.mssV = mssV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mssV=" + mssV +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.mssV - o.mssV;
    }
}
