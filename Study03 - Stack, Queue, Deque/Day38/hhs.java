import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Truck {
        int weight, time;

        public Truck(int weight) {
            this.weight = weight;
            this.time = 0;
        }

        public void addTime() {
            this.time++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> crossQueue = new LinkedList<>();
        Queue<Truck> waitQueue = new LinkedList<>();
        Arrays.stream(truck_weights).forEach(x -> waitQueue.add(new Truck(x)));
        int answer = 0;
        int totalWeight = 0;

        while (!waitQueue.isEmpty() || !crossQueue.isEmpty()) {
            if (crossQueue.isEmpty()) {
                Truck truck = waitQueue.poll();
                totalWeight += truck.weight;
                answer++;
                crossQueue.add(truck);
                continue;
            }

            crossQueue.forEach(Truck::addTime);

            if (crossQueue.peek().time >= bridge_length) {
                Truck truck = crossQueue.poll();
                totalWeight -= truck.weight;
            }

            if (!waitQueue.isEmpty() && waitQueue.peek().weight + totalWeight <= weight) {
                Truck truck = waitQueue.poll();
                totalWeight += truck.weight;
                crossQueue.add(truck);
            }

            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 10, new int[] {7, 4, 5, 6}));
    }
}
