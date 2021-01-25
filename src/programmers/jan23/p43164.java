package programmers.jan23;

import java.util.ArrayList;
import java.util.Collections;

public class p43164 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{{"ICN","JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        solution.solution(new String[][]{{"ICN","SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL","ICN"}, {"ATL","SFO"}});
        solution.solution(new String[][]{{"ICN","A"}, {"ICN", "B"}, {"B", "ICN"}});
    }
}

class Solution {
    boolean[] visited;
    ArrayList<String> answerList;

    public String[] solution(String[][] tickets) {
        answerList = new ArrayList<>();
        visited = new boolean[tickets.length];
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);

        Collections.sort(answerList);
        String[] answer = answerList.get(0).split(" ");

        printArray(answer);

        return answer;
    }

    private void printArray(String[] answer) {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    public void dfs(int count, String startLocation, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answerList.add(answer);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(startLocation)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        return;
    }
}
