package oct.third;

import java.util.ArrayList;

public class p17677 {
    class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.replaceAll("[^a-zA-Z]","0").toLowerCase();
            str2 = str2.replaceAll("[^a-zA-Z]","0").toLowerCase();
            ArrayList<String> str1List = new ArrayList<>();
            ArrayList<String> str2List = new ArrayList<>();
            ArrayList<String> intersection = new ArrayList<>();

            addList(str1, str1List);
            addList(str2, str2List);

            if (str1List.size() == 0 && str2List.size() == 0) return 65536;

            for (int i = 0; i < str1List.size(); i++) {
                for (int j = 0; j < str2List.size(); j++) {
                    if (str1List.get(i).equals(str2List.get(j))) {
                        intersection.add(str1List.get(i));
                        str2List.remove(j);
                        break;
                    }
                }
            }

            double answer = (double) intersection.size() / (str1List.size() + str2List.size());
            return (int) (answer * 65536);
        }

        private void addList(String string, ArrayList<String> list) {
            for (int i = 0; i < string.length() - 1; i++) {
                if (!string.substring(i,i+2).contains("0")) {
                    list.add(string.substring(i, i + 2));
                }
            }
        }
    }
}
