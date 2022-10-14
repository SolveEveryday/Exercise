import java.util.HashMap;
import java.util.Map;

class Solution {
    static Character[][] evaluationIndex = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    static Map<Character, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        init();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < survey.length; i++) {
            Character disagree = survey[i].charAt(0);
            Character agree = survey[i].charAt(1);

            int choice = choices[i];
            if (choice < 4) {
                map.merge(disagree, (4 - choice), Integer::sum);
            } else if (choice > 4) {
                map.merge(agree, (choice - 4), Integer::sum);
            }
        }

        for (int i = 0; i < 4; i++) {
            Character disagree = evaluationIndex[i][0];
            Character agree = evaluationIndex[i][1];

            int disagreeScore = map.get(disagree);
            int agreeScore = map.get(agree);

            if (disagreeScore == agreeScore || disagreeScore > agreeScore) {
                answer.append(disagree);
            } else {
                answer.append(agree);
            }
        }

        return answer.toString();
    }

    public void init() {
        for (Character[] e : evaluationIndex) {
            for (Character name : e) {
                map.put(name, 0);
            }
        }
    }
}