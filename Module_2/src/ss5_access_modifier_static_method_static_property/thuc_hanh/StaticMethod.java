package ss5_access_modifier_static_method_static_property.thuc_hanh;

public class StaticMethod {
    private int rollno;
    private String name;
    private static String college = "BBDIT";
    StaticMethod(int r, String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        college = "CODEGYM";
    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
    public static void main(String[] args) {
        StaticMethod.change(); //calling change method

        //creating objects
        StaticMethod s1 = new StaticMethod(111, "Hoang");
        StaticMethod s2 = new StaticMethod(222, "Khanh");
        StaticMethod s3 = new StaticMethod(333, "Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
