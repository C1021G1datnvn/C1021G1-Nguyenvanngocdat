package ss5_access_modifier_static_method_static_property.thuc_hanh;

public class StaticProperty {
    private String name;
    private String engine;

    public static int number;

    StaticProperty(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String toString(){
        String TH;
        TH = ("name: " + name + " engine: " + engine);
        return TH;
    }

    public static void main(String[] args) {

        StaticProperty car = new StaticProperty();
        StaticProperty car1 = new StaticProperty();

        car.setName("mecerdes");
        car.setEngine("vip");
        System.out.println(car);

        car1.setName("Madaz");
        car1.setEngine("normal");
        System.out.println(car1);
    }
}
