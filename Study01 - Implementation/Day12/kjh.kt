class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val surveyResult = SurveyResult()
        for (i in 0 until survey.size) {
            surveyResult.survey(survey[i], choices[i])
        }
        
        return surveyResult.getResult()
    }
}

class SurveyResult {
    var rt = arrayOf(0, 0)
    var cf = arrayOf(0, 0)
    var jm = arrayOf(0, 0)
    var an = arrayOf(0, 0)
    
    fun survey(types: String, choice: Int) {
        when (choice) {
            1 -> recordScore(types[0], 3)
            2 -> recordScore(types[0], 2)
            3 -> recordScore(types[0], 1)
            5 -> recordScore(types[1], 1)
            6 -> recordScore(types[1], 2)
            7 -> recordScore(types[1], 3)
        }
    }
    
    private fun recordScore(type: Char, score: Int) {
        when (type) {
            'R' -> rt[0] += score
            'T' -> rt[1] += score
            'C' -> cf[0] += score
            'F' -> cf[1] += score
            'J' -> jm[0] += score
            'M' -> jm[1] += score
            'A' -> an[0] += score
            'N' -> an[1] += score
        }
    }
    
    fun getResult(): String {
        val rt = if (rt[0] >= rt[1]) "R" else "T"
        val cf = if (cf[0] >= cf[1]) "C" else "F"
        val jm = if (jm[0] >= jm[1]) "J" else "M"
        val an = if (an[0] >= an[1]) "A" else "N"
        
        return rt+cf+jm+an
    }
}
