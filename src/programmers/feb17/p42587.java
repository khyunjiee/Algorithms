package programmers.feb17;

import java.util.*;

/*
 * Lv.2 프린터
 * */
public class p42587 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 초기화
        ArrayList<Integer> locationArray = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            locationArray.add(i);
        }

        while (true) {
            int max = Arrays.stream(priorities).max().getAsInt();
            int first = locationArray.get(0);

            if (priorities[first] == max) {
                answer++;

                if (first == location) {
                    break;
                }

                priorities[first] = -1;
                locationArray.remove(locationArray.get(0));
            } else {
                locationArray.remove(locationArray.get(0));
                locationArray.add(first);
            }
        }

        return answer;
    }
}