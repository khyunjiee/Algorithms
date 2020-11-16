package nov.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (beforePermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    private static boolean beforePermutation(int[] arr) {

        int a = arr.length - 1;
        while(a > 0 && arr[a-1] <= arr[a]) a--;
        if (a <= 0 ) return false;

        int b = arr.length - 1;
        while(arr[a-1] <= arr[b]) b--;

        int tmp = arr[a-1];
        arr[a-1] = arr[b];
        arr[b] = tmp;

        int start = a;
        int end = arr.length - 1;
        while(start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return true;
    }
}
