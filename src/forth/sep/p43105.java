package forth.sep;

public class p43105 {
    class Solution {

        public int solution(int[][] triangle) {
            for (int i = triangle.length - 1; i > 0; i--) {
                maxList(triangle[i - 1], triangle[i]);
            }
            return triangle[0][0];
        }

        private void maxList(int[] upList, int[] downList) {
            for (int i = 0; i < upList.length; i++) {
                if (downList[i] >= downList[i + 1]) upList[i] = upList[i] + downList[i];
                else upList[i] = upList[i] + downList[i + 1];
                System.out.println(upList[i]);
            }
        }
    }
}
