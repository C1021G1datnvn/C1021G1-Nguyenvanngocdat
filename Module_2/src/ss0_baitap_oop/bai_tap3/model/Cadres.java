package ss0_baitap_oop.bai_tap3.model;

public class Cadres {
    private String mCB;
    private String name;
    private String dress;
    private String yearOfBirth;
    private String speciaLize;
    private String level;
    private double salary;
    private double allowance;
    public Cadres() {

    }

    public Cadres(String mCB, String name, String dress, String yearOfBirth, String speciaLize, String level, double salary, double allowance) {
        this.mCB = mCB;
        this.name = name;
        this.dress = dress;
        this.yearOfBirth = yearOfBirth;
        this.speciaLize = speciaLize;
        this.level = level;
        this.salary = salary;
        this.allowance = allowance;
    }

    public String getmCB() {
        return mCB;
    }

    public void setmCB(String mCB) {
        this.mCB = mCB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getSpeciaLize() {
        return speciaLize;
    }

    public void setSpeciaLize(String speciaLize) {
        this.speciaLize = speciaLize;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    public double getActuallyReceived() {
        return (this.salary + this.allowance) * 450000;
    }

    @Override
    public String toString() {
        return "Cadres{" +
                "mCB='" + mCB + '\'' +
                ", name='" + name + '\'' +
                ", dress='" + dress + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", speciaLize='" + speciaLize + '\'' +
                ", level='" + level + '\'' +
                ", salary=" + salary +
                ", allowance=" + allowance +
                '}';
    }
}
