package case_study1.model.person;

import case_study1.model.person.Person;

public class Customer extends Person {
    private String cusRank;

    public Customer() {

    }

    public Customer(String cusRank) {
        this.cusRank = cusRank;
    }

    public Customer(int id, String name, int age, String adress, String gender, String dateOfBirth, String numberPhone, String numberCccd, String email, String cusRank) {
        super(id, name, age, adress, gender, dateOfBirth, numberPhone, numberCccd, email);
        this.cusRank = cusRank;
    }


    public String getCusRank() {
        return cusRank;
    }

    public void setCusRank(String cusRank) {
        this.cusRank = cusRank;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " id= " + getId() +
                " ,name= " + getName()+
                " ,age= " + getAge() +
                " ,addres= " + getAdress()+
                " ,gender= " + getGender() +
                " ,date of birth= " + getDateOfBirth()+
                " ,phone number= " +getNumberPhone()+
                " ,numbercccd= " +getNumberCccd() +
                " ,email= " + getEmail()+
                "cusRank='" + cusRank + '\'' +
                '}';
    }
}
