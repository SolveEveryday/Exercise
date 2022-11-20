import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int[] days = new int[100];

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            queue.add((int) Math.ceil((100 - progress) / (double) speed));
        }

        int max = queue.poll();
        days[max]++;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            max = Math.max(max, temp);

            days[max]++;
        }

        return Arrays.stream(days).filter(x -> x != 0).toArray();
    }
}
