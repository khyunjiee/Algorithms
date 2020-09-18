package third.sep;

import java.util.List;

public class p43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] check = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    dfs(computers, i, check);
                    answer++;
                }
            }

            return answer;
        }

        private boolean[] dfs(int[][] computers, int i, boolean[] check) {
            check[i] = true;

            for (int j = 0; j < computers.length; j++) {
                if (i != j && check[j] == false && computers[i][j] == 1) {
                    check = dfs(computers, j, check);
                }
            }
            return check;
        }
    }
}
