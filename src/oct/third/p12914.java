package oct.third;

public class p12914 {
    class Solution {
        public long solution(int n) {
            long jump[] = new long[2001];
            jump[1] = 1;
            jump[2] = 2;

            for (int i = 3; i <= 2000; i++) {
                jump[i] = (jump[i - 1] + jump[i - 2]) % 1234567;
            }
            return jump[n];
        }
    }
}
