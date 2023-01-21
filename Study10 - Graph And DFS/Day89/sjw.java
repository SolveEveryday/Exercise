import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int result;
    static LinkedList<Integer>[] adjList;

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new LinkedList[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0);

            if(result > 0){
                break;
            }
        }

        System.out.println(result);
    }

    static void dfs(int startVertex, int cnt) {

        if(cnt == 4){
            result = 1;
            return;
        }

        visit[startVertex] = true;

        for (int i : adjList[startVertex]) {
            if(!visit[i]){
                dfs(i, cnt + 1);
            }
        }
        visit[startVertex] = false;
    }
}