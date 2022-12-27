fun main() {
    val stairsCount = readln().toInt()
    
    val scores = ArrayList<Int>()
    repeat(stairsCount) {
        val score = readln().toInt()
        scores.add(score)
    }

    print(getAvailableMax(scores))
}

val availableMax = HashMap<Pair<Int, Int>, Int>()

fun getAvailableMax(scores : List<Int>) : Int = getAvailableMax(scores, scores.size-1, 1)

fun getAvailableMax(scores : List<Int>, index : Int, continualCount : Int) : Int {
    if (index < 0) return 0
    if (continualCount >= 3) return Int.MIN_VALUE

    val pair = Pair(index, continualCount)
    if (availableMax.contains(pair)) {
        return availableMax.get(pair)!!
    }

    var prevAvailableMax = getAvailableMax(scores, index-1, continualCount+1)
    prevAvailableMax = Math.max(prevAvailableMax, getAvailableMax(scores, index-2, 1))
    
    val current = scores[index];
    availableMax[pair] = prevAvailableMax + current
    
    return availableMax[pair]!!
}