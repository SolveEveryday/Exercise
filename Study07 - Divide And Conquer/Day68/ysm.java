import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {


    static StringBuilder v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            int number = Integer.parseInt(str);
            int sizeArray = (int) Math.pow(3, number);
            v = new StringBuilder();
            for(int x=0;x<sizeArray;x++) {
                v.append("-");
            }
            run(0,sizeArray);
            System.out.println(v);
        }
    }

    public static void run(int start, int size) {
        if(size == 1) {
            return;
        }

        int divSize = size/3;
        for (int x = divSize + start; x < 2 * divSize + start; x++) {
            v.setCharAt(x, ' ');
        }
    
        run(start, divSize);
        run(start + 2 * divSize, divSize);
    }
    

}
