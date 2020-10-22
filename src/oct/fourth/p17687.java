package oct.fourth;

public class p17687 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            String str = "0";
            int count = 0;

            while (str.length() < (t * m + p)) {
                String numStr = "";
                int num = count++;

                while (num != 0) {
                    if (num % n >= 10) numStr += String.valueOf((char) (num % n + 55));
                    else numStr += String.valueOf(num % n);
                    num /= n;
                }
                str += new StringBuilder(numStr).reverse().toString();
            }
            String answer = "";
            for (int i = 0; i < t; i++) {
                answer += String.valueOf(str.charAt(m * i + p - 1));
            }
            return answer;
        }
    }
}
