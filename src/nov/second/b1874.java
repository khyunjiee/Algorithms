package nov.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        boolean flag = false;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (count <= num) {
                stack.push(count++);
                sb.append("+\n");
            }

            if (stack.isEmpty() || stack.peek() < num) flag = true;

            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
                sb.append("-\n");
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
