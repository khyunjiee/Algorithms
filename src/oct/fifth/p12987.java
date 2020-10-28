package oct.fifth;

import java.util.Arrays;

public class p12987 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            if (A[aIndex] > B[bIndex]) bIndex++;
            else if (A[aIndex] == B[bIndex]) bIndex++;
            else {
                aIndex++;
                bIndex++;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        p12987 p = new p12987();
        System.out.println(p.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
        System.out.println(p.solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));
    }
}
