package oct.second;

import java.util.*;

public class p42895 {
    class Solution {
        public int solution(int N, int number) {
            int answer = 0;
            ArrayList<HashSet<Integer>> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            set.add(N);
            list.add(set);

            while (answer < 8) {
                if (list.get(answer).contains(number)) break;
                answer++;

                HashSet<Integer> nset = new HashSet<>();
                String n = String.valueOf(N);
                for (int i = 0; i < answer; i++) n += String.valueOf(N);
                nset.add(Integer.parseInt(n));

                for (int i = 0; i < answer; i++) {
                    for (int j = 0; i + j < answer; j++) {
                        for (Iterator it1 = list.get(i).iterator(); it1.hasNext();) {
                            int n1 = (int) it1.next();
                            for (Iterator it2 = list.get(j).iterator(); it2.hasNext();) {
                                int n2 = (int) it2.next();
                                nset.add(n1 + n2);
                                nset.add(n1 - n2);
                                nset.add(n1 * n2);
                                if (n2 != 0) nset.add(n1 / n2);
                            }
                        }
                    }
                }
                list.add(nset);
            }
            return (answer >= 8) ? -1 : answer + 1;
        }
    }
}
