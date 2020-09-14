package third.sep;

import java.util.*;
import java.util.stream.Collectors;

public class p12981 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0,0};
            Set<String> wordSet = Arrays.asList(words).stream().collect(Collectors.toSet());
            wordSet.remove(words[0]);

            for (int i = 1; i < words.length; i++) {
                if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0) && wordSet.contains(words[i])) {
                    wordSet.remove(words[i]);
                    continue;
                } else if (i == words.length - 1 && wordSet.contains(words[i])) {
                    return answer;
                } else {
                    answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                    answer[1] = (i + 1) / n;
                }
            }

            return answer;
        }
    }
}
