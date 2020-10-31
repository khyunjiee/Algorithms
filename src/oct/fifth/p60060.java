package oct.fifth;
import java.util.*;

// Trie 써서 다시 해보기..


public class p60060 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie frontTrie = new Trie();
        Trie backTrie = new Trie();
        for(String s : words){
            frontTrie.addWord(s);
            backTrie.addWord(new StringBuffer(s).reverse().toString());
        }
        int i=0;
        for(String s : queries){
            if(s.charAt(0)=='?'){
                answer[i++]=backTrie.search(new StringBuffer(s).reverse().toString());
            }else answer[i++]=frontTrie.search(s);
        }
        return answer;
    }

    static class Node{
        char data;
        HashMap<Character,Node> child = new HashMap<>();
        HashMap<Integer,Integer> lenHashMap = new HashMap<>();

        public Node(char data){
            this.data = data;
        }

    }

    static class Trie{
        Node head;

        public Trie(){
            head = new Node('#');
        }

        public void addWord(String s){
            Node cur = head;
            for(char c : s.toCharArray()){
                if(cur.lenHashMap.containsKey(s.length())){
                    int lenCnt = cur.lenHashMap.get(s.length());
                    cur.lenHashMap.replace(s.length(),lenCnt+1);
                }else{
                    cur.lenHashMap.put(s.length(),1);
                }
                if(!(cur.child.containsKey(c))){
                    cur.child.put(c,new Node(c));
                }
                cur = cur.child.get(c);

            }
        }


        public int search(String s){
            Node cur = head;
            for(char c : s.toCharArray()){
                if(c=='?') break;
                else if(cur.child.containsKey(c)){
                    cur = cur.child.get(c);
                }
                else{
                    return 0;
                }
            }
            if(cur.lenHashMap.containsKey(s.length()))
                return cur.lenHashMap.get(s.length());
            else return 0;
        }

    }
}
