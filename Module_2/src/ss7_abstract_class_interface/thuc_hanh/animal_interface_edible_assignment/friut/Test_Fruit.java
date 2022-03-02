package ss7_abstract_class_interface.thuc_hanh.animal_interface_edible_assignment.friut;

public class Test_Fruit {
    public static void main(String[] args) {
        Fruit[] fruits = {new Apple(), new Orange()};
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
