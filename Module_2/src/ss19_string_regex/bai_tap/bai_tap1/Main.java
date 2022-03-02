package ss19_string_regex.bai_tap.bai_tap1;

import java.util.Scanner;

public class Main {
    private static ValidateClassName validateClassName;
    private static String[] validName = {"C1021G"};
    private static String[] invalidName = {"T1021C, L2109M"};
    public static void main(String[] args) {
        validateClassName = new ValidateClassName();
        for (String name : validName) {
            boolean isValid = validateClassName.validate(name);
            System.out.println(isValid);
        }
        for (String name : invalidName) {
            boolean isValid = validateClassName.validate(name);
            System.out.println(isValid);
        }
    }
}
