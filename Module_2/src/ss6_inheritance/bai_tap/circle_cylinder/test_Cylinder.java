package ss6_inheritance.bai_tap.circle_cylinder;

public class test_Cylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder.setChieucao(6.7);
        System.out.println(cylinder);
        cylinder = new Cylinder(2.5, 5.0, "blue");
        System.out.println(cylinder);
    }
}
