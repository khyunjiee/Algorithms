package nov.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int day = Integer.parseInt(st.nextToken()) - 2;
        int numberOfRiceCake = Integer.parseInt(st.nextToken());
        String[] list = {"A", "B"};

        while (day > 0) {
            String temp = list[1];
            list[1] = list[0] + list[1];
            list[0] = temp;
            day--;
        }

        int aCount = 0;
        int bCount = 0;
        int a = 1;
        int b = 1;

        for (String s : list[1].split("")) {
            if (s.equals("A")) aCount++;
            else if (s.equals("B")) bCount++;
        }

        while (true) {
            if ((numberOfRiceCake - (a * aCount)) % bCount == 0) {
                sb.append(a + "\n");
                b = (numberOfRiceCake - (a * aCount)) / bCount;
                sb.append(b);
                break;
            } else {
                a++;
            }
        }

        System.out.println(sb);
    }
}
