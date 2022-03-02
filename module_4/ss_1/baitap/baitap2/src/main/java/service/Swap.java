package service;

import java.util.HashMap;
import java.util.Map;

public class Swap {
    public Map<String, String> swap() {
        Map<String, String> swapDictionary = new HashMap<>();
        swapDictionary.put("hello", "xin chào");
        swapDictionary.put("miss", "nhớ");
        swapDictionary.put("uncle", "cậu");
        swapDictionary.put("people", "người");
        swapDictionary.put("person", "người");
        swapDictionary.put("english", "tiếng anh");
        return swapDictionary;
    }

}
