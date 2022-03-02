package ss19_string_regex.bai_tap.bai_tap2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    public static final String REGEX = "^\\(84\\)\\-\\(\\d{10}\\)$";

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
