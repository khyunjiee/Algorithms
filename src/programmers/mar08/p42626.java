package programmers.mar08;

import java.util.Collections;
import java.util.PriorityQueue;

public class p42626 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        for (int s: scoville) {
            scovilleQueue.add(s);
        }

        while (scovilleQueue.peek() < K) {
            if (scovilleQueue.size() == 1 && scovilleQueue.peek() < K) {
                answer = -1;
                break;
            }

            int first = scovilleQueue.poll();
            int second = scovilleQueue.poll();
            scovilleQueue.add(first + (second * 2));

            answer++;
        }

        return answer;
    }
}