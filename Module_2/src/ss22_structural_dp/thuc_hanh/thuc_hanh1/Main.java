package ss22_structural_dp.thuc_hanh.thuc_hanh1;

public class Main {
    public static void main(String[] args) {
        CalculatorProxy proxy = new CalculatorProxy();
        double result = proxy.add(1, 2);
        System.out.println("1 + 2 = " + result);
        result = proxy.add(2, Double.MAX_VALUE);
        System.out.println("2 + Double.MAX_VALUE = " + result);
    }
}
