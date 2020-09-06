package com.hyunji;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Programmers60063 {
    class Solution {
        class Node {
            int r1, c1, r2, c2;

            Node(int r1, int c1, int r2, int c2){
                this.r1 = r1;
                this.c1 = c1;
                this.r2 = r2;
                this.c2 = c2;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + getEnclosingInstance().hashCode();
                result = prime * result + c1;
                result = prime * result + c2;
                result = prime * result + r1;
                result = prime * result + r2;
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                Node node = (Node)obj;
                if(this.r1 == node.r1 && this.c1 == node.c1 && this.r2 == node.r2 && this.c2 == node.c2) return true;
                if(this.r1 == node.r2 && this.c1 == node.c2 && this.r2 == node.r1 && this.c2 == node.c1) return true;
                return false;
            }

            private Solution getEnclosingInstance() {
                return Solution.this;
            }


        }

        HashSet<Node> visited;
        Queue<Node> q;
        int[][] map;
        int N, answer;

        public int solution(int[][] board) {
            answer = 0;
            N = board.length;
            visited = new HashSet<>();
            q = new LinkedList<>();
            map = new int[N + 2][N + 2];

            for(int r = 0 ; r < map.length ; ++r){
                for(int c = 0 ; c < map.length ; ++c){
                    if(r == 0 || r == map.length - 1 || c == 0 || c == map.length - 1) map[r][c] = 1;
                    else map[r][c] = board[r - 1][c - 1];
                }
            }

            push(1, 1, 1, 2);
            bfs();

            return answer;
        }

        private void bfs() {
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int[] rotate = {-1, 1};

            while(!q.isEmpty()) {
                int size = q.size();

                for(int i = 0 ; i < size ; ++i) {
                    Node now = q.poll();

                    if((now.r1 == N && now.c1 == N) || (now.r2 == N && now.c2 == N)) return;

                    // 회전 없이 상하좌우 이동
                    for(int d = 0 ; d < 4 ; ++d) {
                        int nr1 = now.r1 + dir[d][0];
                        int nc1 = now.c1 + dir[d][1];
                        int nr2 = now.r2 + dir[d][0];
                        int nc2 = now.c2 + dir[d][1];

                        if(map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                            push(nr1, nc1, nr2, nc2);
                        }
                    }

                    // 가로 회전
                    if(now.r1 == now.r2) {
                        for(int r : rotate) {
                            int nr1 = now.r1 + r;
                            int nc1 = now.c1;
                            int nr2 = now.r2 + r;
                            int nc2 = now.c2;

                            if(map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                                push(now.r1, now.c1, nr1, nc1);
                                push(now.r2, now.c2, nr2, nc2);
                            }
                        }
                    }

                    // 세로 회전
                    if(now.c1 == now.c2) {
                        for(int r : rotate) {
                            int nr1 = now.r1;
                            int nc1 = now.c1 + r;
                            int nr2 = now.r2;
                            int nc2 = now.c2 + r;

                            if(map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                                push(now.r1, now.c1, nr1, nc1);
                                push(now.r2, now.c2, nr2, nc2);
                            }
                        }
                    }
                }
                answer++;
            }
        }

        private boolean push(int r1, int c1, int r2, int c2) {
            Node node = new Node(r1, c1, r2, c2);

            if(visited.contains(node)) return false;

            visited.add(node);
            q.offer(new Node(r1, c1, r2, c2));

            return true;
        }
    }
}
