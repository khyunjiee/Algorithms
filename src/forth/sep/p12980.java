package forth.sep;

public class p12980 {
    class Solution {
        public int solution(int n) {
            int ans = 1;

            while (n > 1) {
                if (!isItEven(n)) ans++;
                n = divideTwo(n);
            }

            return ans;
        }

        private boolean isItEven(int number) {
            if (number % 2 == 0) return true;
            else return false;
        }

        private int divideTwo(int number) {
            return number / 2;
        }
    }
}
