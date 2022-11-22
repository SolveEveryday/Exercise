package BOJ_2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] barChart = new int[1001];
        List<BarInfo> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            BarInfo barInfo =
                    new BarInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(barInfo);
        }

        Collections.sort(list, Collections.reverseOrder());

        Deque<BarInfo> deque = new ArrayDeque<>();

        int midIndex = getMaxIndex(list);
        barChart[list.get(midIndex).getIndex()] = list.get(midIndex).getValue();

        for (int i = 0; i <= midIndex; i++) {
            BarInfo temp = list.get(i);

            if (deque.isEmpty()) {
                deque.addLast(temp);
                continue;
            }

            if (deque.peekLast().getValue() <= temp.getValue()) {
                for (int j = deque.peekLast().getIndex(); j < temp.getIndex(); j++) {
                    barChart[j] = deque.peekLast().getValue();
                }

                deque.addLast(temp);
            }
        }

        deque.clear();

        for (int i = list.size() - 1; i >= midIndex; i--) {
            BarInfo temp = list.get(i);

            if (deque.isEmpty()) {
                deque.addLast(temp);
                continue;
            }

            if (deque.peekLast().getValue() <= temp.getValue()) {
                for (int j = deque.peekLast().getIndex(); j > temp.getIndex(); j--) {
                    barChart[j] = deque.peekLast().getValue();
                }

                deque.addLast(temp);
            }
        }

        int answer = 0;
        for (int temp : barChart) {
            answer += temp;
        }

        System.out.println(answer);
    }

    private static int getMaxIndex(List<BarInfo> list) {
        int index = 0;
        int maxValue = 0;

        for (int i = 0; i < list.size(); i++) {
            BarInfo barInfo = list.get(i);

            if (barInfo.getValue() >= maxValue) {
                index = i;
                maxValue = barInfo.getValue();
            }
        }

        return index;
    }
}


class BarInfo implements Comparable<BarInfo> {
    private int index;
    private int value;

    public BarInfo(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(BarInfo o) {
        return o.index - index;
    }
}
