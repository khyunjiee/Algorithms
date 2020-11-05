package nov.first;

import java.util.Scanner;

public class b11723 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int s = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            int num = 0;

            if (operation.equals("all")) {
                s = (1 << 21) -1;
            } else if (operation.equals("empty")) {
                s = 0;
            } else {
                num = scanner.nextInt();
            }

            if (operation.equals("add")) {
                s = s | (1 << num);
            } else if (operation.equals("remove")) {
                s = s &~ (1 << num);
            } else if (operation.equals("check")) {
                if ((s & (1 << num)) > 0) result.append("1\n");
                else result.append("0\n");
            } else if (operation.equals("toggle")) {
                s = s ^ (1 << num);
            }
        }

        System.out.println(result);
    }
}
