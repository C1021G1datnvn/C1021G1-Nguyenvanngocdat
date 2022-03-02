package ss13_search_code.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class AsciiCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = scanner.nextLine();
        LinkedList<Character> maxList = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > maxList.size()) {
                maxList.clear();
                maxList.addAll(list);
            }
            list.clear();
        }
        for (Character character : maxList) {
            System.out.println(character);
        }
    }
}
