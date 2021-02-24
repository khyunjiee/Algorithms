package programmers.feb24;

import java.util.ArrayList;

/*
 * Lv.2 가장 큰 수
 * */
public class p42883 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1924", 2));
        System.out.println(solution.solution("1231234", 3));
        System.out.println(solution.solution("4177252841", 4));
        System.out.println(solution.solution("999", 2));
        System.out.println(solution.solution("99991", 3));
        System.out.println(solution.solution("111119", 3));
    }
}

class Solution {
    public String solution(String number, int k) {
        String[] strings = number.split("");
        int[] numberArray = new int[number.length()];
        for (int i = 0; i < strings.length; i++) {
            numberArray[i] = Integer.parseInt(strings[i]);
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(numberArray[0]);

        String answer = "";
        int len = number.length() - k;

        for (int i = 1; i < numberArray.length; i++) {
            if (k == 0) {
                for (int j = i; j < numberArray.length; j++) {
                    answerList.add(numberArray[j]);
                }
                break;
            }

            answerList.add(numberArray[i]);

            if (answerList.get(answerList.size() - 1) > answerList.get(answerList.size() - 2)) {
                while (answerList.size() != 1
                        && answerList.get(answerList.size() - 1) > answerList.get(answerList.size() - 2)
                        && k > 0) {
                    answerList.remove(answerList.get(answerList.size() - 2));
                    k--;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            answer += answerList.get(i);
        }

        return answer;
    }
}
