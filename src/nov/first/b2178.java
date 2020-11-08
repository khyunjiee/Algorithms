package nov.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
    static int[] dr = {1, -1, 0, 0};
    static int[] ds = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] array;
    static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int j = 0; j < m; j++) {
                array[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(array[n - 1][m - 1]);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int location[] = queue.poll();
            visited[i][j] = true;

            for (int dir = 0; dir < 4; dir++) {
                int r = location[0] + dr[dir];
                int s = location[1] + ds[dir];

                if (r >= 0 && s >= 0 && r < n && s < m) {
                    if (array[r][s] != 0 && !visited[r][s]) {
                        queue.offer(new int[]{r, s});
                        visited[r][s] = true;
                        array[r][s] = array[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }
}
