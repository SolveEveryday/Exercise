package BOJ_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

        int result = 0;
        int lastEndTime = 0;

        for (Time time : list) {
            if (lastEndTime <= time.start) {
                lastEndTime = time.end;
                result++;
            }
        }

        System.out.println(result);
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
        if (end == o.end) {
            return start - o.start;
        }
        return end - o.end;
    }
}
