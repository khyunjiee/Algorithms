package programmers.feb19;

import java.util.ArrayList;

public class p42586 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int index = 0;
        int dayCount = 1;
        int remainFunctions = progresses.length;

        while (remainFunctions > 0) {
            if (progresses[index] + speeds[index] * dayCount < 100) {
                dayCount++;
            }
            else {
                int functions = 1;
                for (int i = index + 1; i < progresses.length; i++) {
                    if (progresses[i] + (speeds[i] * dayCount) >= 100) {
                        functions++;
                    } else {
                        break;
                    }
                }

                answerList.add(functions);
                index += functions;
                remainFunctions -= functions;
            }
        }

        int[] answer = listToArray(answerList);
        return answer;
    }

    private int[] listToArray(ArrayList<Integer> answerList) {
        int[] answer =  new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
