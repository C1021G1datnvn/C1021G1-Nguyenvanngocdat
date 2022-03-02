package ss7_abstract_class_interface.thuc_hanh.animal_interface_edible_assignment.animal;

import ss7_abstract_class_interface.thuc_hanh.animal_interface_edible_assignment.ediable.Edible;

public class Test_animal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                ((Edible)animal).howToEat();
                System.out.println(((Chicken) animal).howToEat());
            }
        }
    }
}
