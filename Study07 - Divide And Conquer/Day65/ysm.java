import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       // BufferedReader를 사용하기 위해서는 throws IOException을 해 주어야 함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        int[] arr = new int[total];
        for(int x=0;x<total;x++) {
            arr[x] = Integer.parseInt(token[x]);
        }
        int lastNumber = Integer.parseInt(br.readLine());

        for(int i = 0; i < total; i += total / lastNumber) {
			Arrays.sort(arr, i, i + total / lastNumber);
		}

        for(int i : arr) {
			sb.append(i + " ");
		}
        System.out.println(sb.toString());
      
    }
    
}
