import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int cnt = 1;

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[] visited = new int[n + 1];

        LinkedList[] adjList = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<>();
        }

        //간선 정보
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        //정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        dfs(r, adjList, visited);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    public void dfs(int r, LinkedList<Integer>[] adjList, int[] visited) {
        visited[r] = cnt;

        Iterator<Integer> iter = adjList[r].listIterator();

        while (iter.hasNext()) {
            int w = iter.next();
            if (visited[w] == 0) {
                cnt++;
                dfs(w, adjList, visited);
            }
        }
    }

}
