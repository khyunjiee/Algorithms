package nov.first;

import java.util.Scanner;
import java.util.Stack;

public class b17413 {
    public static String solution(String string) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        String[] list = string.split("");
        int index = 0;
        boolean flag = false;

        while (true) {
            if (index == list.length) break;
            else if (list[index].equals("<")) {
                while (!stack.isEmpty()) answer += stack.pop();
                answer += list[index];
                flag = true;
            }
            else if (list[index].equals(">")) {
                answer += list[index];
                flag = false;
            }
            else if (flag) {
                answer += list[index];
            }
            else if (list[index].equals(" ")) {
                while (!stack.isEmpty()) answer += stack.pop();
                answer += " ";
            }
            else stack.push(list[index]);
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        string += " ";
        System.out.println(solution(string));
    }
}
