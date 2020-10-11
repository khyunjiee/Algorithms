package oct.second;

public class p60062 {
    public class Solution {
        public int n, min;
        public int[] weak, dist;
        public int[][] rotateWeak;
        public boolean[] visit;

        public int solution(int n, int[] weak, int[] dist) {
            this.n = n;
            this.weak = weak;
            this.dist = dist;
            rotateWeak = new int[weak.length][weak.length];
            visit = new boolean[dist.length];
            min = Integer.MAX_VALUE;
            rotate();

            for(int i = 1; i <= dist.length; i++) {
                per(0, i, "");
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public void rotate() {
            for(int j = 0; j < weak.length; j++) {
                int ro[] = new int[weak.length];
                int index = j;

                for(int i = 0; i < weak.length; i++) {
                    ro[i] = weak[index % weak.length];

                    if(index >= weak.length)
                        ro[i] += n;
                    index++;
                }
                rotateWeak[j] = ro;
            }
        }

        public void per(int count, int length, String s) {
            if(count == length) {
                check(s.trim().split(" "));
                return;
            }

            for(int i = 0; i < dist.length; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    per(count+1, length, s + dist[i]+ " ");
                    visit[i] = false;
                }
            }
        }

        public void check(String s[]) {
            int people[] = new int[s.length];
            for(int i = 0; i < s.length; i++)
                people[i] = Integer.parseInt(s[i]);

            for(int i = 0; i < rotateWeak.length; i++) {
                int index = 0;
                int start = rotateWeak[i][index];

                for(int j = 0; j < people.length; j++) {
                    while(index < rotateWeak.length && rotateWeak[i][index]-start <= people[j]) {
                        index++;
                    }
                    if(index >= rotateWeak.length)
                        min = Math.min(min, people.length);
                    else
                        start = rotateWeak[i][index];
                }
            }
        }
    }
}
