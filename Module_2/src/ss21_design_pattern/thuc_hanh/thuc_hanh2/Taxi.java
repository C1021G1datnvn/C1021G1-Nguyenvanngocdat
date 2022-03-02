package ss21_design_pattern.thuc_hanh.thuc_hanh2;

public class Taxi {
    private String name;

    public Taxi() {
    }

    public Taxi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "taxi{" +
                "name='" + name + '\'' +
                '}';
    }
}
