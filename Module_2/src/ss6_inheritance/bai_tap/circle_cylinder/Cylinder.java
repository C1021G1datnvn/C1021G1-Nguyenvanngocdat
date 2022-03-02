package ss6_inheritance.bai_tap.circle_cylinder;

import ss6_inheritance.bai_tap.circle_cylinder.Circle;

public class Cylinder extends Circle {
    private double chieucao;
    public Cylinder() {
        this.chieucao = 1.0;
    }
    public Cylinder(double chieucao, double radius, String color) {
        super(radius, color);
        this.chieucao = chieucao;
    }
    public Cylinder(double chieucao) {
        this.chieucao = chieucao;
    }
    public double getChieucao() {
        return chieucao;
    }
    public void setChieucao(double chieucao) {
        this.chieucao = chieucao;
    }
    public double getVolume() {
        return Math.pow(super.getRadius(), 2) * this.chieucao * Math.PI;
    }

    @Override
    public String toString() {
        return "a Cylinder of chieucao=" + this.getChieucao() + " and volume" + this.getVolume();
    }
}
