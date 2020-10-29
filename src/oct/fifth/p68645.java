package oct.fifth;

import java.util.ArrayList;

public class p68645 {
    public static int[] solution(int n) {
        int[][] list = new int[n][n];
        int max = factorial(n);
        int[] answer = new int[max];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                list[i][j] = -1;
            }
        }

        int i = 0, j = 0, k = 1;
        list[i][j] = k;

        while (k < max) {
            while (i + 1 < n && list[i + 1][j] < 0) {
                list[++i][j] = ++k;
            }
            while (j + 1 < n && list[i][j + 1] < 0) {
                list[i][++j] = ++k;
            }
            while (i - 1 > 0 && list[i - 1][j - 1] < 0) {
                list[--i][--j] = ++k;
            }
        }

        k = 0;

        for (int l = 0; l < n; l++) {
            for (int m = 0; m <= l; m++) {
                answer[k++] = list[l][m];
            }
        }

        return answer;
    }

    static int factorial(int n) {
        return n == 1 ? 1 : factorial(n - 1) + n;
    }

    public static void main(String[] args) {
        p68645 p = new p68645();
        System.out.println(p.solution(4));
        System.out.println(p.solution(5));
        System.out.println(p.solution(6));
    }
}
