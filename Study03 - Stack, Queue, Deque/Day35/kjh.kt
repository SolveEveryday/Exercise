import java.util.*

fun main() {
    val (N, K, M) = readln().split(" ").map { it.toInt() }
    
    val josephus = Josephus(N)
    val result = StringBuilder()
    
    for (i in 1..N) {
        result.append(josephus.popNth(K))
            .append('\n')
        
        val needReverse = (i % M) == 0
        if (needReverse) {
            josephus.reverse()
        }
    }
    
    print(result)
}

class Josephus(val numberOfPeople: Int) {
    val sequence = ArrayDeque<Int>()    
    var isNaturalOrder = true
    
    init {
        for (i in 1..numberOfPeople) {
            sequence.add(i)
        }
    }
    
    fun popNth(n: Int): Int {
        for (i in 0..n-2) {
            popAndPush()
        }
        return pop()
    }
    
    fun reverse() {
        isNaturalOrder = !isNaturalOrder
    }
    
    private fun popAndPush() {
        if (isNaturalOrder) {
            sequence.offerLast(sequence.pollFirst())
        } else {
            sequence.offerFirst(sequence.pollLast())
        }
    }
    
    private fun pop(): Int {
        if (isNaturalOrder) {
            return sequence.pollFirst()        
        } else {
            return sequence.pollLast()
        }
    }
}