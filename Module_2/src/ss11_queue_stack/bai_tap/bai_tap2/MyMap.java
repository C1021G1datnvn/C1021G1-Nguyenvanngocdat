package ss11_queue_stack.bai_tap.bai_tap2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi");
        String str = scanner.nextLine();
        Character charac;
        Map<Character, Integer> mapChaInt = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            charac = str.charAt(i);
            if (mapChaInt.containsKey(charac)) {
                int count = mapChaInt.get(charac);
                mapChaInt.put(charac, count + 1);
            }else {
                mapChaInt.put(charac, 1);
            }
        }
        System.out.println(mapChaInt);
    }
}
