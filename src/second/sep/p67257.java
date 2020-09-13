package second.sep;

import java.util.ArrayList;

public class p67257 {

    class Solution {
        char[] prior = {'+', '-', '*'};
        boolean[] check = new boolean[3];
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        long answer;

        public long solution(String expression) {
            answer = 0;
            String num = "";

            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num += expression.charAt(i);
                } else {
                    nums.add(Long.parseLong(num));
                    num = "";
                    ops.add(expression.charAt(i));
                }
            }
            nums.add(Long.parseLong(num));

            return answer;
        }

        private Long calculation(Long num1, Long num2, char op) {
            long num = 0;
            switch (op) {
                case '+': return num1 + num2;
                case '-': return num1 - num2;
                case '*': return num1 * num2;
            }
            return num;
        }

        private void dfs(int count, char[] p) {
            if (count == 3) {
                ArrayList<Long> numbers = new ArrayList<>(nums);
                ArrayList<Character> operations = new ArrayList<>(ops);

                for (int i = 0; i < p.length; i++) {
                    for (int j = 0; j < operations.size(); j++) {
                        if (p[i] == operations.get(j)) {
                            Long res = calculation(numbers.remove(j), numbers.remove(j), p[i]);
                            numbers.add(j, res);
                            operations.remove(j);
                            j--;
                        }
                    }
                }
                answer = Math.max(answer, Math.abs(numbers.get(0)));
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (!check[i]) {
                    check[i] = true;
                    p[count] = prior[i];
                    dfs(count + 1, p);
                    check[i] = false;
                }
            }
        }
    }

}
