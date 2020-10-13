package oct.third;

import java.util.ArrayList;
import java.util.Collections;

public class p12915 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            ArrayList<String> list = new ArrayList<>();

            for (String string : strings) {
                list.add(string.charAt(n) + string);
            }
            Collections.sort(list);

            for (int i = 0; i < strings.length; i++) {
                strings[i] = list.get(i).substring(1);
            }

            return strings;
        }
    }
}
