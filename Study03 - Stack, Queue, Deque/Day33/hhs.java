package BOJ_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {

    static Deque<Integer> deque;
    static int shiftLeftCount = 0;
    static int shiftRightCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        deque = IntStream.range(1, N + 1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int[] mArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        for (int target :
                mArray) {

            Deque<Integer> a = new ArrayDeque<>(deque);
            Deque<Integer> b = new ArrayDeque<>(deque);

            int aCount = 0;
            int bCount = 0;

            while (deque.size() - 1 != a.size()) {
                if (a.peekFirst() == target) {
                    a.removeFirst();
                } else {
                    a.addLast(a.removeFirst());
                    aCount++;
                }
            }

            while (deque.size() - 1 != b.size()) {
                if (b.peekLast() == target) {
                    b.addFirst(b.removeLast());
                    b.removeFirst();
                } else {
                    b.addFirst(b.removeLast());
                    bCount++;
                }
            }

            if (aCount <= bCount) {
                deque = a;
                shiftLeftCount += aCount;
            } else {
                deque = b;
                shiftLeftCount++;
                shiftRightCount += bCount;
            }
        }

        System.out.println(shiftLeftCount + shiftRightCount);
    }
}
