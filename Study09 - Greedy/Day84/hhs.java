package pro_42861;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[] parent = new int[n];
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            if (find(parent, cost[0]) != find(parent, cost[1])) {
                answer += cost[2];

                union(parent, cost[0], cost[1]);
            }
        }

        return answer;
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent, parent[x]);
    }
}
