package case_study1.model.person;

import case_study1.model.person.Person;

public class Employee extends Person {
    private int level;
    private Double salary;

    public Employee() {

    }

    public Employee(int level, Double salary) {
        this.level = level;
        this.salary = salary;
    }

    public Employee(int id, String name, int age, String adress, String gender, String dateOfBirth, String numberPhone, String numberCccd, String email, int level, Double salary) {
        super(id, name, age, adress, gender, dateOfBirth, numberPhone, numberCccd, email);
        this.level = level;
        this.salary = salary;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " id= " + getId() +
                " ,name= " + getName()+
                " ,age= " + getAge() +
                " ,addres= " + getAdress()+
                " ,gender= " + getGender() +
                " ,date of birth= " + getDateOfBirth()+
                " ,phone number= " +getNumberPhone()+
                " ,numbercccd= " +getNumberCccd() +
                " ,email= " + getEmail()+
                " ,level= " + level +
                " ,salary= '" + salary + '\'' +
                '}';
    }
}
