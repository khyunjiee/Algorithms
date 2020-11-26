package nov.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] days = new int[N + 10];
        int[] costs = new int[N + 10];
        int[] dp = new int[N + 10];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <=N+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[days[i]+i] = Math.max(dp[days[i]+i],costs[i]+dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
