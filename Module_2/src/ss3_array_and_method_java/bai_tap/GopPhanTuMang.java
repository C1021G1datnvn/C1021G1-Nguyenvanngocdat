package ss3_array_and_method_java.bai_tap;


public class GopPhanTuMang {
    public static void main(String[] args) {
        int array1[] = {1, 2, 3, 4, 5};
        int array2[] = {6, 7, 8, 9, 0};
        int array3[] = sum(array1, array2);
        for(int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
    public static int[] sum(int array1[], int array2[]) {
        int array3[] = new int[array1.length + array2.length];
        for (int j = 0; j < array1.length; j++) {
            array3[j] = array1[j];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }
        return array3;
    }
}
