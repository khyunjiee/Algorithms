package com.hyunji;

/*
2020 KAKAO BLIND RECRUITMENT
프로그래머스 60058번 괄호 변환
 */

public class Programmers60058 {

    class Solution {
        public String solution(String p) {
            if (p.equals("")) return "";
            if (isCorrectString(p)) return p;

            String answer = "";

            int check = 0;
            int index = 0;

            for (char c : p.toCharArray()) {
                index++;

                if (c == '(') check++;
                else if (c == ')') check--;

                if (check == 0) break;
            }

            String u = p.substring(0, index);
            String v = p.substring(index, p.length());

            if (isCorrectString(u)) {
                answer = u;
                answer += solution(v);
            } else {
                answer += "(";
                answer += solution(v);
                answer += ")";
                answer += manipulate(u);
            }

            return answer;
        }

        // 올바른 괄호 문자열인지 체크
        private boolean isCorrectString(String p) {
            int check = 0;

            for (char c : p.toCharArray()) {
                if (c == '(') check++;
                else if (c == ')') check--;

                if (check < 0) return false;
            }

            return true;
        }

        // 문자열 조작 함수
        private String manipulate(String u) {
            // 처음, 끝 제거
            String returnString = u.substring(1, u.length()-1);
            returnString = returnString.replace("(", "+");
            returnString = returnString.replace(")", "(");
            returnString = returnString.replace("+", ")");

            return returnString;
        }
    }

}
