package BOJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Time> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Time(start, end));
        }

        quickSort(list);

        PriorityQueue<Time> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        pq.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            if (pq.peek().end <= list.get(i).start) {
                pq.poll();
            }
            pq.add(list.get(i));
        }

        System.out.println(pq.size());
    }

    public static void quickSort(List<Time> timeList) {
        sort(timeList, 0, timeList.size() - 1);
    }

    private static void sort(List<Time> timeList, int low, int high) {
        if (low >= high) return;

        int mid = partition(timeList, low, high);
        sort(timeList, low, mid - 1);
        sort(timeList, mid, high);
    }

    private static int partition(List<Time> timeList, int low, int high) {
        Time pivot = timeList.get((low + high) / 2);
        while (low <= high) {
            while (timeList.get(low).compareTo(pivot) < 0) low++;
            while (timeList.get(high).compareTo(pivot) > 0) high--;
            if (low <= high) {
                Collections.swap(timeList, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
