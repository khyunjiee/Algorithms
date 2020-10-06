package oct.second;

import java.lang.reflect.Array;
import java.util.*;

public class p42884 {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 0;

            Arrays.sort(routes, new Comparator<int[]>() {
                @Override
                public int compare(int[] a , int[] b) {
                    return a[0] - b[0];
                }
            });

            int min = routes[0][0];
            int max = routes[0][1];

            for (int i = 1; i < routes.length; ++i) {
                int in = routes[i][0];
                int out = routes[i][1];

                if (in > max || out < min) {
                    answer++;
                    min = in;
                    max = out;
                } else {
                    min = in > min ? in : min;
                    max = out < max ? out : max;
                }
            }

            return answer;
        }
    }
}
