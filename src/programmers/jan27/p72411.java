package programmers.jan27;

import java.util.*;

public class p72411 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        solution.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5});
        solution.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});
    }
}

class Solution {
    ArrayList<HashMap<String, Integer>> allCourses;

    public String[] solution(String[] orders, int[] course) {
        allCourses = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            allCourses.add(new HashMap<>());
        }

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                dfs(orders[i].split(""), "", course[j], 0, j);
            }
        }

        ArrayList<String> answerList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            if (allCourses.get(i) != null) {
                List<String> stringList = sortCourses(i);
                int max = -1;

                for (String key: stringList) {
                    if (allCourses.get(i).get(key) >= max && allCourses.get(i).get(key) >= 2) {
                        answerList.add(key);
                        max = allCourses.get(i).get(key);
                    }
                    else if (allCourses.get(i).get(key) < max) break;
                }
            }
        }
        Collections.sort(answerList);

        String[] answer = answerList.toArray(new String[answerList.size()]);

        return answer;
    }

    public void dfs(String[] singleMenus, String resultCourse, int size, int startIndex, int arrayListIndex) {
        if (size == 0) {
            String[] resultArray = resultCourse.split("");
            Arrays.sort(resultArray);
            addCourse(String.join("", resultArray), arrayListIndex);
            return;
        }
        else {
            for (int i = startIndex; i <= singleMenus.length - size; i++) {
                dfs(singleMenus, resultCourse + singleMenus[i], size - 1, i + 1, arrayListIndex);
            }
        }
    }

    public void addCourse(String resultCourse, int arrayListIndex) {
        if (allCourses.get(arrayListIndex).containsKey(resultCourse)) {
            allCourses.get(arrayListIndex).put(resultCourse, allCourses.get(arrayListIndex).get(resultCourse) + 1);
        } else {
            allCourses.get(arrayListIndex).put(resultCourse, 1);
        }
    }

    public List<String> sortCourses(int arrayListIndex) {
        List<String> keySetList = new ArrayList<>(allCourses.get(arrayListIndex).keySet());
        Collections.sort(keySetList, (o1, o2) -> (allCourses.get(arrayListIndex).get(o2).compareTo(allCourses.get(arrayListIndex).get(o1))));

        return keySetList;
    }
}