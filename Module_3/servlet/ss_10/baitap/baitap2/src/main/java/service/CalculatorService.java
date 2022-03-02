package service;

public class CalculatorService {
    public static Double result(Double number1, String operator, Double number2) {

        if (operator.equals("add")) {
            return number1 + number2;
        } else if (operator.equals("sub")) {
            return number1 - number2;
        } else if (operator.equals("mul")) {
            return number1 * number2;
        } else if (operator.equals("div")) {
            try {
                Double result = number1 / number2;
                return result;
            } catch (Exception e) {

            }
        }
        return null;
    }
}
