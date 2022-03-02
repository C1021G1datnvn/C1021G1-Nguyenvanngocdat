package model;


import org.springframework.stereotype.Service;

@Service
public class CalculateImpl implements ICalculate {
    @Override
    public double calculation(double num1, double num2, String calculate) {
        double result;
        switch (calculate) {
            case "Add":
                result = num1 + num2;
                break;
            case "Sub":
                result = num1 - num2;
                break;
            case "Mul":
                result = num1 * num2;
                break;
            case "Div":
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
