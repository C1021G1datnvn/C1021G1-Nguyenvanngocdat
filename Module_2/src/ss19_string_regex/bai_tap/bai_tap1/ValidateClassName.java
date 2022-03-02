package ss19_string_regex.bai_tap.bai_tap1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {

    public static final String REGEX = "^[ACP][0-9]*[GHIKLM]*$";

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
