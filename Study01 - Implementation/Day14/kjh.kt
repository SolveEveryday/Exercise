fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    
    val nationScores = ArrayList<NationScore>()
    var targetScore = NationScore(0, 0, 0, 0)
    for (i in 0..N-1) {
        val (number, gold, silver, bronze) = readln().split(" ").map { it.toInt() }
        val score = NationScore(number, gold, silver, bronze)
        if (number == K) {
            targetScore = score
            continue
        }
        
        nationScores.add(score)
    }
    
    var betterNations = 0
    for (score in nationScores) {
        if (targetScore.compareTo(score) < 0) {
            betterNations++
        }
    }
    print(betterNations+1)
}

data class NationScore(val number: Int, val gold: Int, val silver: Int, val bronze: Int) : Comparable<NationScore> {
    override fun compareTo(other: NationScore) = when {
        gold != other.gold -> gold - other.gold
        silver != other.silver -> silver - other.silver
        else -> bronze - other.bronze
    }
}