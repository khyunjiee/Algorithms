package nov.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());

        long answer = 1;
        long mul = N % O;

        while (M > 0) {
            if (M % 2 == 1) {
                answer *= mul;
                answer %= O;
            }
            mul = ((mul%O)*(mul%O))%O;
            M /= 2;
        }
        System.out.println(answer);
    }
}
