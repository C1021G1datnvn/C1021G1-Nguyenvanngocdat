package ss7_abstract_class_interface.thuc_hanh.animal_interface_edible_assignment.animal;

import ss7_abstract_class_interface.thuc_hanh.animal_interface_edible_assignment.ediable.Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken: Cluck cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
