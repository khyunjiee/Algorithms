package nov.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (N % 5 == 0 && N % 3 == 0) {
                N -= 5;
            } else if (N % 5 == 0) {
                N -= 5;
            } else if (N % 3 == 0) {
                N -= 3;
            } else {
                N -= 5;
            }
            count++;

            if (N == 0) {
                System.out.println(count);
                break;
            }
            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
