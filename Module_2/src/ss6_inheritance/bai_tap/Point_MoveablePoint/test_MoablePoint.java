package ss6_inheritance.bai_tap.Point_MoveablePoint;

public class test_MoablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(4.4f, 5.6f);
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(7.2f, 2.8f,10.0f,6.0f);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
