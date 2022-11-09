package BOJ_2141;

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

        long sum = 0;
        StringTokenizer st;
        List<Town> towns = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Town town = new Town(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

            sum += town.A;
            towns.add(town);
        }

        quickSort(towns);

        long temp = 0;

        for (Town town : towns) {
            temp += town.A;
            if (temp >= (sum += 1) / 2) {
                System.out.println(town.X);
                break;
            }
        }
    }

    public static void quickSort(List<Town> towns) {
        sort(towns, 0, towns.size() - 1);
    }

    private static void sort(List<Town> towns, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = partition(towns, low, high);
        sort(towns, low, mid - 1);
        sort(towns, mid, high);
    }

    private static int partition(List<Town> towns, int low, int high) {
        Town pivot = towns.get((low + high) / 2);
        while (low <= high) {
            while (towns.get(low)
                        .compareTo(pivot) < 0) {
                low++;
            }
            while (towns.get(high)
                        .compareTo(pivot) > 0) {
                high--;
            }
            if (low <= high) {
                Collections.swap(towns, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
}

class Town implements Comparable<Town> {

    long X;
    long A;

    public Town(long x, long a) {
        X = x;
        A = a;
    }

    @Override
    public int compareTo(Town o) {
        if (X == o.X) {
            return (int) (A - o.A);
        }
        return (int) (X - o.X);
    }
}