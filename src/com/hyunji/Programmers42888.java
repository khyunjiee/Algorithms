package com.hyunji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers42888 {
    class Solution {
        public List<String> solution(String[] record) {
            List<String> answer = new ArrayList<String>();
            HashMap<String, String> nickname = new HashMap<>();

            for (String ment : record) {
                String[] mentList = ment.split(" ");
                if (mentList[0].equals("Leave")) {
                    continue;
                }
                nickname.put(mentList[1], mentList[2]);
            }

            for (String ment : record) {
                String[] mentList = ment.split(" ");
                if (mentList[0].equals("Leave")) {
                    answer.add(nickname.get(mentList[1]) + "님이 나갔습니다.");
                } else if (mentList[0].equals("Enter")) {
                    answer.add(nickname.get(mentList[1]) + "님이 들어왔습니다.");
                }
            }

            return answer;
        }
    }
}
