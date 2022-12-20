import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static long a,b,c,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.print(power(b));

    }
    
    public static long power(long B) {
        if(B==0) return 1;
        if(B==1) return a % c;

        k = power(B/2)%c;
        if(B%2 == 0) return k*k%c;
        return k*k%c*a%c;
    }
}
