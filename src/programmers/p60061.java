package programmers;

import java.util.Arrays;

/*
* 기둥과 보 설치 (2020 KAKAO BLIND)
* */
public class p60061 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] solution1 = solution.solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        int[][] solution2 = solution.solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(Arrays.toString(solution1[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < solution2.length; i++) {
            System.out.print(Arrays.toString(solution2[i]) + " ");
        }
    }
}

class Solution {
    int[][] 기둥;
    int[][] 보;
    int count = 0;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        int index = 0;
        기둥 = new int[n + 2][n + 2];
        보 = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                기둥[i][j] = 0;
                보[i][j] = 0;
            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            기둥과_보(build_frame[i], 기둥, 보, n);
        }

        if (count > 0) answer = new int[count][3];
        else return null;

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (기둥[i][j] == 1) {
                    int[] temp = {i - 1, j - 1, 0};
                    answer[index++] = temp;
                }
                if (보[i][j] == 1) {
                    int[] temp = {i - 1, j - 1, 1};
                    answer[index++] = temp;
                }
            }
        }

        return answer;
    }

    private void 기둥과_보(int[] build, int[][] 기둥, int[][] 보, int n) {
        int x = build[0] + 1;
        int y = build[1] + 1;
        int structure = build[2];
        int addOrRemove = build[3];

        switch (addOrRemove) {
            case 0:
                if (structure == 0) {
                    기둥[x][y] = 0;
                    count--;

                    if (!삭제(n)) {
                        기둥[x][y] = 1;
                        count++;
                    }
                } else if (structure == 1) {
                    보[x][y] = 0;
                    count--;

                    if (!삭제(n)) {
                        보[x][y] = 1;
                        count++;
                    }
                }
                break;

            case 1:
                if (structure == 0) {
                    if (기둥_유효성_검사(x, y)) {
                        기둥[x][y] = 1;
                        count++;
                    }
                } else if (structure == 1) {
                    if (보_유효성_검사(x, y)) {
                        보[x][y] = 1;
                        count++;
                    }
                }
                break;
        }
    }

    private boolean 삭제(int n) {
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (기둥[i][j] == 1) {
                    if (!기둥_유효성_검사(i, j)) return false;
                }
                if (보[i][j] == 1) {
                    if (!보_유효성_검사(i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean 기둥_유효성_검사(int x, int y) {
        if (y == 1 || 기둥[x][y - 1] == 1) return true;
        if (보[x - 1][y] == 1 || 보[x][y] == 1) return true;
        return false;
    }

    private boolean 보_유효성_검사(int x, int y) {
        if (기둥[x][y - 1] == 1 || 기둥[x + 1][y - 1] == 1) return true;
        if (보[x - 1][y] == 1 && 보[x + 1][y] == 1) return true;
        return false;
    }
}