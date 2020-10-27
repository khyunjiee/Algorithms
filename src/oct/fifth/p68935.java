package oct.fifth;

public class p68935 {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        String numStr = "";

        while (n != 0) {
            numStr += String.valueOf(n % 3);
            n /= 3;
        }
        str = new StringBuilder(numStr).reverse().toString();
        String[] list = str.split("");

        for (int i = 0; i < str.split("").length; i++) {
            answer += Integer.valueOf(list[i]) * Math.pow(3, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        p68935 p68935 = new p68935();
        System.out.println(p68935.solution(45));
        System.out.println(p68935.solution(125));

    }
}
