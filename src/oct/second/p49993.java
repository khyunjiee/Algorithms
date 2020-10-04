package oct.second;

public class p49993 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i = 0; i < skill_trees.length; i++) {
                int len = skill_trees[i].length();
                String skill_clones = new String(skill_trees[i]);
                for (int j = 0; j < len; j++) {
                    String one = String.valueOf(skill_clones.charAt(j));
                    if (!skill.contains(one)) skill_trees[i] = skill_trees[i].replace(one, "");
                }
            }

            for (String tree : skill_trees) {
                if (skill.indexOf(tree) == 0) answer++;
            }

            return answer;
        }
    }
}
