package ss19_string_regex.bai_tap.bai_tap2;

public class Main {
    private static ValidateNumberPhone validateNumberPhone;
    private static String[] isvalid = {"(84)-(0978489648)"};
    private static String[] unisvalid = {"(a8)-(22222222)"};

    public static void main(String[] args) {
        validateNumberPhone = new ValidateNumberPhone();
        for (String regex : isvalid) {
            boolean isvalidate = validateNumberPhone.validate(regex);
            System.out.println(isvalidate);
        }
        for (String regex : unisvalid) {
            boolean isvalidate = validateNumberPhone.validate(regex);
            System.out.println(isvalidate);
        }
    }
}
