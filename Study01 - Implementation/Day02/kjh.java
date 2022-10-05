import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] usedCount = new int['z'-'a'+1];

        String line;
        while ((line = br.readLine()) != null) {
            for (char ch : line.toCharArray()) {
                if (ch == ' ') continue;
                int chIdx = ch - 'a';
                usedCount[chIdx]++;
            }
        }

        int max = 0;
        List<Integer> maxIndicies = new ArrayList<>();
        for (int i = 0; i < usedCount.length; i++) {
            if (usedCount[i] > max) {
                max = usedCount[i];
                maxIndicies.clear();
                maxIndicies.add(i);
            } else if (usedCount[i] == max) {
                maxIndicies.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int maxIndex : maxIndicies) {
            char ch = (char) ('a' + maxIndex);
            result.append(ch);
        }

        System.out.println(result);
    }
}