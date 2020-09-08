package com.hyunji;

import java.util.Arrays;

public class Programmers67256 {
    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int[] left = {1, 4, 7, 10};
            int[] center = {2, 5, 8, 0};
            int[] right = {3, 6, 9, 10};
            int leftNum = 10;
            int rightNum = 10;
            int leftIndex = 3;
            int rightIndex = 3;
            boolean isLeft = true;
            boolean isRight = true;

            for (int n : numbers) {
                if (Arrays.stream(left).anyMatch(x -> x == n)) {
                    answer += "L";
                    isLeft = true;
                    leftNum = n;
                    leftIndex = findIndex(left, n);
                } else if (Arrays.stream(right).anyMatch(x -> x == n)) {
                    answer += "R";
                    isRight = true;
                    rightNum = n;
                    rightIndex = findIndex(right, n);
                } else {
                    int centerIndex = findIndex(center, n);
                    int leftTermIndex = (isLeft) ? Math.abs(centerIndex - leftIndex) + 1 : Math.abs(centerIndex - leftIndex);
                    int rightTermIndex = (isRight) ? Math.abs(centerIndex - rightIndex) + 1 : Math.abs(centerIndex - rightIndex);

                    if (leftTermIndex < rightTermIndex) {
                        leftNum = n;
                        isLeft = false;
                        answer += "L";
                        leftIndex = centerIndex;
                    } else if (leftTermIndex > rightTermIndex) {
                        rightNum = n;
                        isRight = false;
                        answer += "R";
                        rightIndex = centerIndex;
                    } else {
                        if (hand.equals("left")) {
                            leftNum = n;
                            isLeft = false;
                            answer += "L";
                            leftIndex = centerIndex;
                        } else {
                            rightNum = n;
                            isRight = false;
                            answer += "R";
                            rightIndex = centerIndex;
                        }
                    }
                }
            }
            return answer;
        }

        private int findIndex(int[] arr, int num) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    return i;
                }
            }
            return -1;
        }
    }
}
