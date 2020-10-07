package oct.second;

import java.util.*;

public class p49191 {
    class Boxer {
        int num;
        Set<Integer> win = new HashSet<>();
        Set<Integer> lose = new HashSet<>();

        public Boxer(int num) {
            this.num = num;
        }

    }

    class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            Boxer[] boxers = new Boxer[n + 1];

            for (int i = 0; i <= n; i++) {
                boxers[i] = new Boxer(i);
            }

            for (int[] result : results) {
                boxers[result[0]].win.add(result[1]);
                boxers[result[1]].lose.add(result[0]);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    Boxer boxer = boxers[j];
                    Set<Integer> winners = new HashSet<>();

                    for (Integer win : boxer.win) {
                        for (Integer winOfWin : boxers[win].win) {
                            winners.add(winOfWin);
                        }
                    }
                    boxer.win.addAll(winners);

                    Set<Integer> losers = new HashSet<>();

                    for (Integer lose : boxer.lose) {
                        for (Integer loseOfLose : boxers[lose].lose) {
                            losers.add(loseOfLose);
                        }
                    }
                    boxer.lose.addAll(losers);
                }
            }

            for (Boxer boxer : boxers) {
                if (boxer.win.size() + boxer.lose.size() == n - 1) answer++;
            }

            return answer;
        }
    }
}
