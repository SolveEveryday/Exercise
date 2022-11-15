package BOJ_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<File> queue = new LinkedList<>();

            for (int j = 1; j <= N; j++) {
                File file = new File(j, Integer.parseInt(st.nextToken()));
                queue.add(file);
                priorityQueue.add(file.getPriority());
            }

            int count = 1;
            while (!queue.isEmpty()) {
                File file = queue.poll();

                if (priorityQueue.peek() == file.getPriority()) {
                    priorityQueue.poll();

                    if (file.getNumber() == (M + 1)) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                } else {
                    queue.add(file);
                }
            }

        }
    }
}

class File {
    int number;
    int priority;

    public File(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }

    public int getNumber() {
        return number;
    }

    public int getPriority() {
        return priority;
    }
}
