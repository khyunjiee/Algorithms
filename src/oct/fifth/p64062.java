package oct.fifth;

import java.util.*;

public class p64062 {
    public int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        return binarySearch(stones, k, min, max);
    }

    private int binarySearch(int[] stones, int k, int lo, int hi) {
        if (hi == lo) return lo;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (canCross(stones, k, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo - 1;
    }

    private boolean canCross(int[] stones, int k, int friends) {
        int passCount = 0;

        for (int stone : stones) {
            if (stone - friends < 0) {
                passCount++;
            } else {
                passCount = 0;
            }

            if (passCount == k) return false;
        }

        return true;
    }
}
