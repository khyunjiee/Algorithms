package oct.first;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p67258 {
    class Solution {
        public int[] solution(String[] gems) {
            Set<String> gemSet = Arrays.stream(gems).collect(Collectors.toSet());
            HashMap<String, Integer> gemMap = new HashMap<>();
            Queue<String> gemQ = new LinkedList<>();
            int start = 0;
            int index = 0;
            int length = Integer.MAX_VALUE;

            for (int i = 0; i < gems.length; i++) {
                gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);

                gemQ.add(gems[i]);

                while (true) {
                    String temp = gemQ.peek();
                    if (gemMap.get(temp) > 1) {
                        gemMap.put(temp, gemMap.get(temp) - 1);
                        gemQ.poll();
                        index++;
                    } else {
                        break;
                    }
                }

                if (gemMap.size() == gemSet.size() && length > gemQ.size()) {
                    length = gemQ.size();
                    start = index;
                }
            }
            return new int[]{start + 1, start + length};
        }
    }
}
