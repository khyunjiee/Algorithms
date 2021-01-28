package programmers.jan28;

public class p12904 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcdcba"));
        System.out.println(solution.solution("abacde"));
        System.out.println(solution.solution("abccba"));
        System.out.println(solution.solution("aaabbaaaa"));
    }
}

class Solution
{
    public int solution(String s)
    {
        int odd = 0;
        int even = 0;

        if (s.length() == 1) return 1;

        for (int i = 0; i < s.length() - 1; i++) {
            // 홀수
            if (i > 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                int halfLength = getHalfLength(s, i - 1, i + 1);

                if (odd < halfLength) odd = halfLength;
            }
            // 짝수
            if (s.charAt(i) == s.charAt(i + 1)) {
                int halfLength = getHalfLength(s, i, i + 1);

                if (even < halfLength) even = halfLength;
            }
        }

        return Integer.max(odd * 2 + 1, even * 2);
    }

    private int getHalfLength(String s, int left, int right) {
        int halfLength = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                halfLength++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return halfLength;
    }
}