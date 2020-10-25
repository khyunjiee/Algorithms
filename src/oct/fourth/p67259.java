package oct.fourth;

import java.util.LinkedList;
import java.util.Queue;

public class p67259 {
    class Solution {
        int minValue;
        int[][] map;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};
        int n;

        private void bfs(int x, int y, int sum, int vector) {
            Queue<Road> q = new LinkedList<>();
            q.add(new Road(x, y, sum, vector));
            map[0][0] = 1;

            while (!q.isEmpty()) {
                Road road = q.poll();
                if (road.x == n - 1 && road.y == n - 1) {
                    if (minValue > road.sum) minValue = road.sum;
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = road.x + this.x[i];
                    int nextY = road.y + this.y[i];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[nextX][nextY] != 1) {
                        int nextFieldSum = 0;

                        if (road.vector == -1 || road.vector == i) nextFieldSum = road.sum + 100;
                        else nextFieldSum = road.sum + 600;

                        if (map[nextX][nextY] == 0) {
                            map[nextX][nextY] = nextFieldSum;
                            q.add(new Road(nextX, nextY, nextFieldSum, i));
                        } else if (map[nextX][nextY] >= nextFieldSum) {
                            map[nextX][nextY] = nextFieldSum;
                            q.add(new Road(nextX, nextY, nextFieldSum, i));
                        }
                    }
                }
            }
        }

        public int solution(int[][] board) {
            minValue = Integer.MAX_VALUE;
            n = board.length;
            map = board;

            bfs(0, 0, 0, -1);
            return minValue;
        }

        class Road {
            int x, y;
            int sum;
            int vector;

            public Road(int x, int y, int sum, int vector) {
                this.x = x;
                this.y = y;
                this.sum = sum;
                this.vector = vector;
            }
        }
    }
}
