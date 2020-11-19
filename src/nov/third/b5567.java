package nov.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int roof = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] friends = new int[N + 1][N + 1];
        boolean[] invites = new boolean[N + 1];

        for (int i = 0; i < roof; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            if (friends[1][i] == 1) {
                if (!invites[i]) {
                    answer++;
                    invites[i] = true;
                }
                for (int j = 2; j < N + 1; j++) {
                    if (friends[i][j] == 1 && !invites[j]) {
                        answer++;
                        invites[j] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
