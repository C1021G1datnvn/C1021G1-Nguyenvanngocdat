package ss2_loop_java.bai_tap;

public class InRaSNTNhoHon100 {
    public static void main(String[] args) {
        System.out.println("PrimeNumber smaller than 100");

        for (int i = 2; i < 100; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i + " ");
            }
        }
    }
    public  static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
