package BOJ_1213;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String middle = "";

        int[] alphabet = new int[26];

        str.chars().forEach(x -> alphabet[x - 'A']++);

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(String.valueOf((char) (i + 'A')).repeat(alphabet[i] / 2));
            if (alphabet[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'A'));
            }
        }

        String result = sb + middle;
        result += sb.reverse();

        System.out.println((result.length() == str.length()) ? result : "I'm Sorry Hansoo");
    }
}
