package oct.third;

public class p12951 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] list = s.split(" ");

            for(int i=0; i<list.length; i++) {
                String str = list[i].toLowerCase();
                if(!str.equals("")) {
                    str = String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1);
                }
                answer += str + " ";
            }

            if(s.charAt(s.length()-1) != ' ') {
                answer = answer.trim();
            }

            return answer;
        }
    }
}
