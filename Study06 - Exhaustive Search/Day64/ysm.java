
import java.util.*;

public class Main {

    public static void main(String[] args) {
      
       Scanner sc = new Scanner(System.in) ;
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();
       int year = 0;
       int E = 0;
       int S = 0;
       int M = 0;
       while(true) {
            E++;
            S++;
            M++;
            if(E > 15) {
                E = 1;
            }
            if(S>28) {
                S = 1;
            }

            if(M>19) {
                M = 1;
            }
            year++;

            if (E == a && S == b && M == c) {
                System.out.print(year);
                break;
            }
       }
    }
}
