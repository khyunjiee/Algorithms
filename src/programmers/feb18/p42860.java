package programmers.feb18;

public class p42860 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("JEROEN"));
        System.out.println(solution.solution("JAN"));
    }
}

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int directionCount = len - 1;

        for (int i = 0; i < name.length(); i++) {
            int nextIndex = i + 1;
            if (name.charAt(i) != 'A') answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            while (nextIndex < len && name.charAt(nextIndex) == 'A') nextIndex++;
            directionCount = Math.min(directionCount, i + i + len - nextIndex);
        }

        answer += directionCount;
        return answer;
    }
}
