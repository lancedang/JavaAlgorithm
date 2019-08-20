package dang.algorithm;

import java.util.HashMap;
import java.util.Map;

public class TmpMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "hi");
        System.out.println("result " + map.get("a"));
    }
}
