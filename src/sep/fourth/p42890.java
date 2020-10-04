package sep.fourth;

import java.util.HashSet;

public class p42890 {
    class Solution {
        public int solution(String[][] relation) {
            int answer = 0;
            int column = relation[0].length;
            int row = relation.length;
            HashSet<String> selects = new HashSet<>();
            HashSet<Integer> candidates = new HashSet<>();

            for (int i = 1; i < (1 << column); i++) {
                selects.clear();

                for (int j = 0; j < row; j++) {
                    String data = "";
                    for (int k = 0; k < column; k++) {
                        if ((i & (1 << k)) != 0) {
                            data += relation[j][k] + ",";
                        }
                    }
                    selects.add(data);
                }
                if (selects.size() == row) {
                    push(candidates, i);
                }
            }

            return candidates.size();
        }

        private void push(HashSet<Integer> candidates, int set) {
            for (int key : candidates) {
                if ((key & set) == key) return;
            }
            candidates.add(set);
        }
    }
}
