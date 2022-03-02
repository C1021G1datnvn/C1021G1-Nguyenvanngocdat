package ss11_queue_stack.bai_tap.bai_tap1;

import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;

public class ReserveStringStack {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String string = "abcde";
        for (int i = 0; i < string.length(); i++) {
            stringStack.push(string.charAt(i) + " ");
        }
        System.out.println("Element of stack before: " + stringStack);
        System.out.println("-----------------------");
        System.out.println("Element of stack after: ");
//        for (int i = 0; i < stringStack.size(); i++) {
//            System.out.println(stringStack.pop());
//        }
        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }
}
