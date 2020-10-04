package sep.third;

import java.util.*;

public class p42627 {
    class Solution {
        class Job {
            int requestTime;
            int workingTime;

            public Job(int requestTime, int workingTime) {
                this.requestTime = requestTime;
                this.workingTime = workingTime;
            }
        }

        public int solution(int[][] jobs) {
            LinkedList<Job> waiting = new LinkedList<>();
            PriorityQueue<Job> queue = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.workingTime - o2.workingTime;
                }
            });

            for (int[] job : jobs) {
                waiting.offer(new Job(job[0], job[1]));
            }

            Collections.sort(waiting, new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.requestTime - o2.requestTime;
                }
            });

            int answer = 0;
            int count = 0;
            int time = waiting.peek().requestTime;

            while (count < jobs.length) {
                while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                    queue.offer(waiting.pollFirst());
                }

                if (!queue.isEmpty()) {
                    Job job = queue.poll();
                    time += job.workingTime;
                    answer += time - job.requestTime;
                    count++;
                } else {
                    time++;
                }
            }

            return answer / count;
        }
    }
}
