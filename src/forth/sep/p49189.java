package forth.sep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p49189 {
    class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            int[] distance = new int[n+1];
            int[] parent = new int[n+1];
            int start = 1;

            Queue<Integer> queue = new LinkedList<>();
            distance[start] = 0;
            parent[start] = start;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int here = queue.poll();
                for (int i = 0; i < edge.length; i++) {
                    int there = -1;
                    if (edge[i][0] == here) {
                        there = edge[i][1];
                    } else if (edge[i][1] == here) {
                        there = edge[i][0];
                    }

                    if (there != -1 && distance[there] == 0) {
                        queue.offer(there);
                        distance[there] = distance[here] + 1;
                        parent[there] = here;
                    }
                }
            }

            int max = 0;

            for (int d : distance) {
                if (d > max) max = d;
            }

            for (int i = 2; i < n+1; i++) {
                if (distance[i] == max) answer++;
            }

            return answer;
        }
    }
}
