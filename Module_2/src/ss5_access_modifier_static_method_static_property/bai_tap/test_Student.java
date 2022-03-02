package ss5_access_modifier_static_method_static_property.bai_tap;

public class test_Student {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Đạt Nopro");
        System.out.println("Name is " + student.getName());
        student.setClasses("C1021G1");
        System.out.println("Class is " + student.getClasses());

    }
}
