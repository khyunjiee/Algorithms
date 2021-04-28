package programmers.mar13;

import java.util.*;

/*
* 프로그래머스 단어 변환
* */

public class p43163 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}

class Solution {
    int answer;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = 51;
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return (answer > 50)? 0: answer;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = (answer > count)? count: answer;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && checkValidation(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    private  boolean checkValidation(String begin, String target) {
        int notEqualChar = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) notEqualChar++;
        }

        return (notEqualChar == 1)? true: false;
    }
}
