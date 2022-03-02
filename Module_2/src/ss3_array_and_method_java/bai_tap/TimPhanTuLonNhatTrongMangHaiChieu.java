package ss3_array_and_method_java.bai_tap;



public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        int array[][] = {{1, 2, 3, 4, 5}, {9, 8, 7, 6, 0}};
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Number max is: " + max);
    }
}
