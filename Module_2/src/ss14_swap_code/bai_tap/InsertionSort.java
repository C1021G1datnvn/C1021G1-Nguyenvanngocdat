package ss14_swap_code.bai_tap;

public class InsertionSort {
    public static void insertionSort(int[] arrNumber) {
        for (int i = 1; i < arrNumber.length; i++) {
            int currentElement = arrNumber[i];
            int j = i - 1;
            for (; j >= 0 && arrNumber[j] > currentElement; j--) {
                arrNumber[j + 1] = arrNumber[j];
            }
            arrNumber[j + 1] = currentElement;
        }
    }
}
