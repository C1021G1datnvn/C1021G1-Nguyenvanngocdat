package ss19_string_regex.thuc_hanh.thuc_hanh2;

public class AcountExampleTest {
    private static AcountExample accountExample;
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        accountExample = new AcountExample();
        for (String acount : validAccount) {
            boolean isvalid = accountExample.validate(acount);
            System.out.println("Account is " + acount +" is valid: "+ isvalid);
        }
        for (String acount : invalidAccount) {
            boolean isvalid = accountExample.validate(acount);
            System.out.println("Account is " + acount +" is valid: "+ isvalid);
        }
    }
}
