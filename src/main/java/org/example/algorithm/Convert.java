package org.example.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Convert {

//    Z 字形变换
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        char[] chars = s.toCharArray();
        int length = chars.length;
        List<StringBuilder> result1 = new ArrayList<>();
        for (int i = 0; i < numRows; i++) result1.add(new StringBuilder());
        int cycleNum = 2 * numRows -2;
        for (int i = 1; i <= length; i++) {
            int index = i % cycleNum;
            if (index == 0) {
                index = cycleNum;
            }
            int y;
            if (index <= numRows) {
                y = index - 1;
            } else {
                y = 2 * numRows - index -1;
            }
            result1.get(y).append(chars[i-1]);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(result1.get(i));
        }
        return result.toString();
    }
}
