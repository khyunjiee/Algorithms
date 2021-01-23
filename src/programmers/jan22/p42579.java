package programmers.jan22;

import java.util.*;

/*
 * Lv.3 베스트앨범
 * */
public class p42579 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> musicArrayList = new ArrayList<>();
        HashSet<String> genreSet = new HashSet<>();
        ArrayList<Integer> answerArrayList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genreSet.contains(genres[i])) {
                genreSet.add(genres[i]);
                Music music = new Music(genres[i]);
                music.addMusic(i, plays[i]);
                musicArrayList.add(music);
            } else {
                for (int j = 0; j < musicArrayList.size(); j++) {
                    if (musicArrayList.get(j).genre.equals(genres[i])) {
                        musicArrayList.get(j).addMusic(i, plays[i]);
                        break;
                    }
                }
            }
        }
        Collections.sort(musicArrayList,new MusicComparator());
        for (Music m : musicArrayList) {
            answerArrayList.addAll(m.sortPlayCount());
        }
                
        int[] answer = new int[answerArrayList.size()];
        int index = 0;
        for (int a : answerArrayList) {
            answer[index++] = a;
        }
        return answer;
    }
}

class Music {
    String genre;
    HashMap<Integer, Integer> playCount = new HashMap<>();
    int totalPlayCount = 0;

    public Music(String genre) {
        this.genre = genre;
    }

    public void addMusic(int uniqueNumber, int playing) {
        playCount.put(uniqueNumber, playing);
        totalPlayCount += playing;
    }

    public List<Integer> sortPlayCount() {
        List<Integer> keySetList = new ArrayList<>(playCount.keySet());
        Collections.sort(keySetList, (o1, o2) -> (playCount.get(o2).compareTo(playCount.get(o1))));

        if (keySetList.size() == 1) {
            return keySetList.subList(0, 1);
        } else {
            return keySetList.subList(0, 2);
        }
    }
}

class MusicComparator implements Comparator<Music>{
    @Override
    public int compare(Music a,Music b){
        if(a.totalPlayCount<b.totalPlayCount) return 1;
        else if(a.totalPlayCount>b.totalPlayCount) return -1;
        else return 0;
    }
}
