package oct.fourth;

import java.util.HashMap;
import java.util.HashSet;

public class p49994 {
    class Solution {
        public int solution(String dirs) {
            int x = 0, y = 0;

            HashSet<String> set = new HashSet<>();
            HashMap<Character, int[]> map = new HashMap<>();

            map.put('U', new int[]{0, -1});
            map.put('D', new int[]{0, 1});
            map.put('L', new int[]{-1, 0});
            map.put('R', new int[]{1, 0});

            for (Character dir : dirs.toCharArray()) {
                int lastX = x, lastY = y;

                x += map.get(dir)[0];
                y += map.get(dir)[1];

                if (x < -5 || x > 5) {
                    x -= map.get(dir)[0];
                    continue;
                }
                if (y < -5 || y > 5) {
                    y -= map.get(dir)[1];
                    continue;
                }

                set.add(lastX + "" + lastY + "" + x + "" + y);
                set.add(x + "" + y + "" + lastX + "" + lastY);
            }
            
            return (set.size() / 2);
        }
    }
}
