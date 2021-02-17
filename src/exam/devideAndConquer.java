package exam;

public class devideAndConquer {
    public static void main(String[] args) {
        System.out.println(fastSum(10));
    }

    static int fastSum(int n) {
        if (n == 1) return 1;   // 기저사례
        if (n % 2 == 1) return fastSum(n - 1) + n; // n이 홀수일 때
        return 2 * fastSum(n/2) + (n/2) * (n/2);
    }


}
