package ss4_class_and_object_java.bai_tap;

public class Fan {
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private boolean status = false;
    private int speed = SLOW;
    private double radius = 5;
    private String color = "blue";
public Fan(int speed, String color, double radius, boolean status) {
    this.speed = speed;
    this.color = color;
    this.radius = radius;
    this.status = status;
}
    public boolean getStatus() {
        return status;
    }
    public int getSpeed() {
        return speed;
    }
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public void setRadius() {
        this.radius = radius;
    }
    public void setColor() {
        this.color = color;
    }
    public boolean getOn() {
        return this.status = true;
    }

    @Override
    public String toString() {
        if (getOn()) {
            return "Fan{" +
                    "SLOW=" + SLOW +
                    ", MEDIUM=" + MEDIUM +
                    ", FAST=" + FAST +
                    ", status=" + status +
                    ", speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }else {
            return "Fan is off {" +
                    ", Color = " + color +
                    ", Radius = " + radius + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Fan fan_1 = new Fan(1, "yellow", 10,false);
        System.out.println(fan_1.toString());
    }
}
