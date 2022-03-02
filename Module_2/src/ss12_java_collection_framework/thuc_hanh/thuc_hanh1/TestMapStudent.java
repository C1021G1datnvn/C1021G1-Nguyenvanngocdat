package ss12_java_collection_framework.thuc_hanh.thuc_hanh1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMapStudent {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Anh Ling", 1993);
        hashMap.put("Anh Bảo", 1995);
        hashMap.put("Thuận", 2003);
        hashMap.put("Đạt", 2003);
        System.out.println("Hiển thị các mục trong HashMap");
        System.out.println(hashMap + "\n");
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Hiển thị các mục nhập theo thứ tự tăng dần của khóa");
        System.out.println(treeMap);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Anh Ling", 1993);
        linkedHashMap.put("Anh Bảo", 1995);
        linkedHashMap.put("Thuận", 2003);
        linkedHashMap.put("Đạt", 2003);
        System.out.println("\nThe age for " + "Thuận is " + linkedHashMap.get("Thuận"));
    }
}
