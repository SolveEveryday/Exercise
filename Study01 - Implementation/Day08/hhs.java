package BOJ_1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long W, H, f, c, x1, y1, x2, y2;

        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());
        f = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        long totalArea = W * H;
        long overlapArea;
        long nonOverlapArea;

        if (W == f || f == 0) {
            overlapArea = (x2 - x1) * (y2 - y1) * (c + 1);
            nonOverlapArea = 0;
        }
        else if (W / 2 < f) {
            long maxX = W - f;

            overlapArea = (Math.min(maxX, x2) - x1) * (y2 - y1) * (c + 1) * 2;
            nonOverlapArea = (x2 - Math.max(maxX, x1)) * (y2 - y1) * (c + 1);
        } else {
            overlapArea = (Math.min(f, x2) - x1) * (y2 - y1) * (c + 1) * 2;
            nonOverlapArea = (x2 - Math.max(f, x1)) * (y2 - y1) * (c + 1);
        }

        overlapArea = (overlapArea < 0) ? 0 : overlapArea;
        nonOverlapArea = (nonOverlapArea < 0) ? 0 : nonOverlapArea;

        System.out.println(totalArea - overlapArea - nonOverlapArea);
    }
}
