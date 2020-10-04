package oct.first;

import java.util.HashMap;
import java.util.Map;

public class p64063 {
    class Solution {
        Map<Long, Long> hotel = new HashMap<>();

        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];

            for (int i = 0; i < room_number.length; i++) {
                answer[i] = emptyRoom(room_number[i]);
            }

            return answer;
        }

        private long emptyRoom(long room) {
            if (!hotel.containsKey(room)) {
                hotel.put(room, room + 1);
                return room;
            }
            long nextRoom = hotel.get(room);
            long emptyRoom = emptyRoom(nextRoom);
            hotel.put(room, emptyRoom);
            return emptyRoom;
        }
    }
}
