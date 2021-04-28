package nov.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10974 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        perm(arr, output, visited, 0, N, N);
        System.out.println(sb);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i : output) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }
}
