package ss19_string_regex.thuc_hanh.thuc_hanh2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcountExample {
    private static Pattern pattern;
    public static Matcher matcher;
    public static final String ACOUNT = "^[_a-z0-9]{6,}$";

    public AcountExample() {
         pattern = Pattern.compile(ACOUNT);
    }
    public boolean validate(String string) {
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
