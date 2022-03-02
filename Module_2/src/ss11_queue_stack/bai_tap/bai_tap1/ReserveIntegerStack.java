package ss11_queue_stack.bai_tap.bai_tap1;

import java.util.Stack;

public class ReserveIntegerStack {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int[] arrayInt = {1, 2, 3, 4, 5};
        for (int i = 0; i < arrayInt.length; i++) {
            integerStack.push(arrayInt[i]);
        }
        System.out.println("Element before: " + integerStack);
        System.out.println("---------------");
        System.out.println("Element after: ");
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = integerStack.pop();
            System.out.println(arrayInt[i]);
        }
//        while (!integerStack.isEmpty()) {
//            System.out.println(integerStack.pop());
//        }
    }
}
