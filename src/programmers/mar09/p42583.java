package programmers.mar09;

import java.util.ArrayList;

public class p42583 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(solution.solution(100, 100, new int[]{10}));
        System.out.println(solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int truckIndex = 0;
        int remainWeight = weight;
        int[] truckLocationArray = new int[truck_weights.length];
        ArrayList<Integer> currentBridgeTruck = new ArrayList<>();

        while (truckLocationArray[truck_weights.length - 1] > -1) {
            answer++;

            if (truckIndex < truck_weights.length && truck_weights[truckIndex] <= remainWeight) {
                currentBridgeTruck.add(truckIndex);
                remainWeight -= truck_weights[truckIndex];
                truckIndex++;
            }

            for (int index: currentBridgeTruck) {
                truckLocationArray[index]++;
            }

            for (int i = 0; i < truckLocationArray.length; i++) {
                if (truckLocationArray[i] == bridge_length) {
                    truckLocationArray[i] = -1;
                    currentBridgeTruck.remove(0);
                    remainWeight += truck_weights[i];
                }
                else if (truckLocationArray[i] >= 0){
                    break;
                }
            }
        }

        return answer;
    }
}
