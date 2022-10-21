package BOJ_1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Serial[] serials = new Serial[N];

        for (int i = 0; i < N; i++) {
            serials[i] = new Serial(br.readLine());
        }

        bubbleSort(serials);
//        Arrays.sort(serials);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(serials).forEach(x -> sb.append(x.getSerialNumber()).append('\n'));
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void bubbleSort(Serial[] serials) {
        for (int i = serials.length- 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (serials[j].compareTo(serials[j + 1]) > 0) {
                    Serial temp = serials[j];
                    serials[j] = serials[j + 1];
                    serials[j + 1] = temp;
                }
            }
        }
    }
}

class Serial implements Comparable<Serial> {
    private final String serialNumber;
    private final int sum;
    private final String alphabets;

    private int addFromString() {
        String numericString = serialNumber.replaceAll("[^0-9]", "");
        int result = 0;

        for (int i = 0; i < numericString.length(); i++) {
            result += numericString.charAt(i) - '0';
        }
        return result;
    }

    private String removeNonAlphanumeric() {
        return serialNumber.replaceAll("[^a-zA-Z]", "");
    }

    public Serial(String serialNumber) {
        this.serialNumber = serialNumber;
        this.sum = addFromString();
        this.alphabets = removeNonAlphanumeric();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getSum() {
        return sum;
    }

    public String getAlphabets() {
        return alphabets;
    }

    @Override
    public int compareTo(Serial o) {
        int compareLength = serialNumber.length() - o.serialNumber.length();
        if (compareLength == 0) {
            if (sum == o.sum) {
                return serialNumber.compareTo(o.serialNumber);
            }
            return sum - o.sum;
        }
        return compareLength;
    }
}