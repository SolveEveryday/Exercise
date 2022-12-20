import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());
        int answer = 1;

        while (E != 1 || S != 1 || M != 1) {
            answer++;
            E--;
            S--;
            M--;

            if (E < 1)
                E = 15;
            if (S < 1)
                S = 28;
            if (M < 1)
                M = 19;
        }

        System.out.println(answer);
    }
}
