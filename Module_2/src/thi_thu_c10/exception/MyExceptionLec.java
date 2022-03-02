package thi_thu_c10.exception;

public class MyExceptionLec extends Exception{
    public MyExceptionLec() {
    }

    @Override
    public String getMessage() {
        return "Mã giảng viên không hợp lệ!";
    }
}
