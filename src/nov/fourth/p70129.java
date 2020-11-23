package nov.fourth;

// Integer.toBinaryString() : 2진수 변환

public class p70129 {
    static int[] solution(String s) {
        int[] answer = new int[2];
        int removeTime = 0;
        int changeTime = 0;

        while (s.length() > 1) {
            int zero = 0;
            changeTime++;

            for (String string : s.split("")) {
                if (string.equals("0")) {
                    zero++;
                }
            }
            removeTime += zero;
            int num = s.length() - zero;
            s = Integer.toBinaryString(num);
        }

        answer[0] = removeTime;
        answer[1] = changeTime;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("110010101001"));
        System.out.println(solution("01110"));
        System.out.println(solution("1111111"));
    }
}
