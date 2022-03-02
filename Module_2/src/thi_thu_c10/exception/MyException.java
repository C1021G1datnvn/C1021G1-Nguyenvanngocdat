package thi_thu_c10.exception;

public class MyException extends Exception {
    public MyException() {
    }

    @Override
    public String getMessage() {
        return "Mã sinh viên không hợp lệ!";
    }
}
