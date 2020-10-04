package sep.second;

import java.util.HashSet;

public class p42839 {
    class Solution {
        public int solution(String numbers) {
            int answer = 0;
            HashSet<Integer> set = new HashSet<>();

            String[] numList = numbers.split("");
            int[] arr = new int[numList.length];
            int k = 0;

            for (String str : numList) {
                arr[k] = Integer.parseInt(str);
                k++;
            }

            for (int i = 1; i <= arr.length; i++) {
                permutation(arr, 0, arr.length, i, set);
            }

            answer = set.size();
            return answer;
        }

        private void permutation(int[] arr, int depth, int n, int r, HashSet<Integer> set) {
            if (depth == r) {
                String k = "";
                for (int i = 0; i < r; i++) {
                    k += arr[i];
                }
                isItAnswer(Integer.parseInt(k), set);
                return;
            }

            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, n, r, set);
                swap(arr, depth, i);
            }
        }

        private void swap(int[] arr, int depth, int i) {
            int temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }

        private void isItAnswer(int k, HashSet<Integer> set) {
            int n = 2;
            boolean flag = true;

            while (n < k) {
                if (k % n == 0) {
                    flag = false;
                    break;
                }
                n++;
            }

            if (flag == true && k != 1 && k != 0) set.add(k);
        }
    }
}
