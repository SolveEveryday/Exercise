import java.util.*;

class Solution {
    List<String> letters = List.of("A", "E", "I", "O", "U");
    
    public int solution(String word) {
        String current = "";
        int order = 0;
        while (!current.equals(word)) {
            order++;
            current = nextWord(current);
        }
        return order;
    }
    
    public String nextWord(String word) {
        if (word.equals("")) {
            return "A";
        }
        if (word.length() < 5) {
            return word + "A";
        }
        
        while (true) {
            String lastOneLetter = word.substring(word.length()-1, word.length());
            word = word.substring(0, word.length()-1);
            
            if (lastOneLetter.equals("") || !lastOneLetter.equals("U")) {
                word += letters.get(letters.indexOf(lastOneLetter)+1);
                break;
            }
        }
        return word;
    }
}