package pro_118667;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {

        long sumQueue1 = 0;
        long sumQueue2 = 0;
        int max = 0;
        int answer = 0;

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        for (int i = 0; i < queue1.length; i++) {
            deque1.add(queue1[i]);
            deque2.add(queue2[i]);

            sumQueue1 += queue1[i];
            sumQueue2 += queue2[i];

            max = Math.max(0, Math.max(queue1[i], queue2[i]));
        }

        long sumResult = (sumQueue1 + sumQueue2);
        if (sumResult % 2 == 1 || sumResult / 2 < max) {
            return -1;
        }

        while (true) {
            if (sumQueue1 == sumQueue2) {
                break;
            } else if (sumQueue1 > sumQueue2) {
                sumQueue2 += deque1.getFirst();
                sumQueue1 -= deque1.getFirst();
                deque2.addLast(deque1.removeFirst());
            } else {
                sumQueue1 += deque2.getFirst();
                sumQueue2 -= deque2.getFirst();
                deque1.addLast(deque2.removeFirst());
            }
            answer++;

            if (answer == 300000) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }

}
