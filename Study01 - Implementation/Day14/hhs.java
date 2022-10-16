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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            Country country = new Country(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            list.add(country);
        }

        Collections.sort(list);

        int resultIndex = 0;
        int count = 2;
        list.get(0).rank = 1;

        for (int i = 1; i < list.size(); i++) {
            Country temp = list.get(i - 1);
            Country now = list.get(i);

            if (temp.equals(now)) {
                now.rank = temp.rank;
            } else {
                now.rank = count;
            }

            if (temp.n == K) {
                resultIndex = i - 1;
            } else if (now.n == K) {
                resultIndex = i;
            }

            count++;
        }

        System.out.println(list.get(resultIndex).rank);
    }
}

class Country implements Comparable<Country> {
    int n;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Country(int n, int gold, int silver, int bronze) {
        this.n = n;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
    
    public boolean equals(Country o) {
        return gold == o.gold && silver == o.silver && bronze == o.bronze;
    }

    @Override
    public int compareTo(Country o) {
        if (gold == o.gold) {
            if (silver == o.silver) {
                return o.bronze - bronze;
            } else {
                return o.silver - silver;
            }
        } else {
            return o.gold - gold;
        }
    }
}
