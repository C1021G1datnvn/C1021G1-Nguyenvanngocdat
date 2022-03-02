package thipassmodule2.utils;

public class NotFoundProductException extends Exception{
    public NotFoundProductException() {
    }

    @Override
    public String getMessage() {
        return "Sản phẩm không tồn tại!";
    }
}
