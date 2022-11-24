package BOJ_17178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Deque<Info> deque = new ArrayDeque<>();
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                Info info = new Info(st.nextToken());
                deque.addLast(info);
                priorityQueue.add(info);
            }
        }


        Deque<Info> stack = new ArrayDeque<>();
        while (!priorityQueue.isEmpty()) {
            if (deque.peekFirst() == priorityQueue.peek()) {
                deque.removeFirst();
                priorityQueue.poll();
                continue;
            }

            if (stack.peekLast() == priorityQueue.peek()) {
                stack.removeLast();
                priorityQueue.poll();
                continue;
            }

            if (deque.isEmpty()) {
                System.out.println("BAD");
                return;
            }

            stack.addLast(deque.removeFirst());
        }

        System.out.println("GOOD");
    }
}


class Info implements Comparable<Info> {
    char ch;
    int number;

    public Info(String str) {
        String[] arr = str.split("-");
        this.ch = arr[0].charAt(0);
        this.number = Integer.parseInt(arr[1]);
    }

    @Override
    public int compareTo(Info o) {
        if (ch == o.ch) {
            return number - o.number;
        }

        return ch - o.ch;
    }
}
