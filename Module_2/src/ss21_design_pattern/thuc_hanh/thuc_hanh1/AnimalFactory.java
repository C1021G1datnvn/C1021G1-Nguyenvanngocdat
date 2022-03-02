package ss21_design_pattern.thuc_hanh.thuc_hanh1;

public class AnimalFactory {
    public Animals getAnimal(String string) {
        if ("canine".equals(string)) {
            return new Dog();
        }else {
            return new Cat();
        }
    }
}
