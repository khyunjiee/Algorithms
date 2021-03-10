package programmers.mar10;

import java.util.*;

public class p42577 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution.solution(new String[]{"123", "456", "789"}));
        System.out.println(solution.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < phone_book.length; i++) {
            hashSet.add(phone_book[i]);
        }

        for (String phone: phone_book) {
            for (int len = 1; len < phone.length(); len++) {
                if (hashSet.contains(phone.substring(0, len))) answer = false;
            }
        }

        return answer;
    }
}