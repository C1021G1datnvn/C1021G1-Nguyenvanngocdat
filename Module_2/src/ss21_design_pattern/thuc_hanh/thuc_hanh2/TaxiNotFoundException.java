package ss21_design_pattern.thuc_hanh.thuc_hanh2;

public class TaxiNotFoundException extends Throwable {
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}
