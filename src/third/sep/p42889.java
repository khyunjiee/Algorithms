package third.sep;

import java.util.HashMap;
import java.util.Map;

public class p42889 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int size = 0;
            Map<Integer, Double> failure = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                failure.put(i, calculateFailure(i, stages));
                System.out.println(failure.get(i));
            }

            for (int i = 0; i < N; i++) {
                double max = -1;
                int stage = N+1;

                for (int key : failure.keySet()) {
                    System.out.println(key);
                    if (max < failure.get(key)) {
                        max = failure.get(key);
                        stage = key;
                    }
                }
                answer[size++] = stage;
                failure.remove(stage, max);
            }
            return answer;
        }

        private double calculateFailure(int N, int[] stages) {
            int num = 0;
            int count = 0;

            for (int stage : stages) {
                if (stage == N) num++;
                if (stage >= N) count++;
            }

            if (count > 0) return ((double) num / count);

            return 0;
        }
    }
}
