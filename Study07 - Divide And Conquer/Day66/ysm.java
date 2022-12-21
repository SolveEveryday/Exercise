import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int size;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine()); //문자 하나 받기
        arr = new int[size][size];

    for(int y=0;y<size;y++) {
        StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 분리하기
        for(int x=0;x<size;x++) {
            arr[y][x] = Integer.parseInt(st.nextToken());
        }
    }

    while(size != 1) {
        int[][] tmp = new int[size/2][size/2];

        for(int y=0;y<size;y+=2) {
            for(int x=0;x<size;x+=2) {
                int[] tmpV = new int[4];
                tmpV[0] = arr[y][x];
                tmpV[1] = arr[y+1][x];
                tmpV[2] = arr[y][x+1];
                tmpV[3] = arr[y+1][x+1];

                Arrays.sort(tmpV);

                tmp[y/2][x/2] = tmpV[2];
            }
        }

        size/= 2;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                arr[y][x] = tmp[y][x];
            }
        }
    }
    System.out.print(arr[0][0]+"\n");
    }
    
}

