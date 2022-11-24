package BOJ_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Top> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            Top top = new Top(Integer.parseInt(st.nextToken()), i);

            while (!deque.isEmpty()) {
                if (deque.peekLast().getHeight() < top.getHeight()) {
                    deque.removeLast();
                } else {
                    answer[top.getIdx()] = deque.peekLast().getIdx() + 1;
                    break;
                }
            }

            deque.addLast(top);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}


class Top {
    private int height;
    private int idx;

    public Top(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }

    public int getHeight() {
        return height;
    }

    public int getIdx() {
        return idx;
    }
}
