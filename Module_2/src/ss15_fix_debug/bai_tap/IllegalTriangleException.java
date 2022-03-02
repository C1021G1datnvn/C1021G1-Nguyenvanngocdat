package ss15_fix_debug.bai_tap;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {

    }
    public void negative() {
        System.out.println("Độ dài của cạnh tam giác không thể là số âm!");
    }


}

