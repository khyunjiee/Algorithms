package oct.first;

public class p60059 {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int n = key.length;
            int m = lock.length;
            int[][] secLock = new int[m * 3][m * 3];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    secLock[i+m][j+m] = lock[i][j];
                }
            }

            for (int t = 0; t < 4; t++) {
                key = turn(key);

                for (int a = 0; a < m * 2; a++) {
                    for (int b = 0; b < m * 2; b++) {
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                secLock[a + i][b + j] += key[i][j];
                            }
                        }

                        if (check(secLock)) return true;

                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                secLock[a + i][b + j] -= key[i][j];
                            }
                        }
                    }
                }
            }
            return false;
        }

        int[][] turn(int[][] key) {
            int[][] ret = new int[key.length][key[0].length];
            for (int i = 0; i < ret.length; i++) {
                for (int j = 0; j < ret.length; j++) {
                    // 90도 회전
                    ret[i][j] = key[key.length - 1 - j][i];
                }
            }
            return ret;
        }

        boolean check(int[][] lock) {
            int count = 0;
            int len = lock.length / 3;
            for (int i = len; i < len * 2; i++) {
                for (int j = len; j < len * 2; j++) {
                    if (lock[i][j] == 1) count++;
                }
            }
            return count == len * len;
        }
    }
}
