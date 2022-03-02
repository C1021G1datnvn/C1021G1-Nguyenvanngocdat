package case_study1.model.person;

public abstract class Person {
    private int id;
    private String name;
    private int age;
    private String adress;
    private String gender;
    private String dateOfBirth;
    private String numberPhone;
    private String numberCccd;
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String adress, String gender, String dateOfBirth, String numberPhone, String numberCccd, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numberPhone = numberPhone;
        this.numberCccd = numberCccd;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNumberCccd() {
        return numberCccd;
    }

    public void setNumberCccd(String numberCccd) {
        this.numberCccd = numberCccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
