package exam;

import java.util.HashMap;

public class dynamicProgramming {
    static int num = 10000;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        hashMap.put(0, 0);
        hashMap.put(1, 1);
        System.out.println(fib(num));
    }

    static int fib(int num) {
        if (hashMap.containsKey(num)) return hashMap.get(num);
        else {
            hashMap.put(num, fib(num - 2) + fib(num - 1));
            return hashMap.get(num);
        }
    }
}
