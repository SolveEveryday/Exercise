import java.util.*

fun main() {
    val deque = ArrayDeque<Int>()

    val (N, M) = readln().split(" ").map { it.toInt() }
    for (i in 1..N) {
        deque.offerLast(i)
    }
    
    val numbers = readln().split(" ").map { it.toInt() }
    
    var totalOperates = 0
    for (i in 0..M-1) {
        var operates = 0
        while (true) {
            val poped = deque.pollFirst()
            if (poped == numbers[i]) {
                break
            }
            deque.offerLast(poped)
            operates++
        }
        
        if (operates > (deque.size+1)/2) {
            totalOperates += deque.size + 1 - operates
        } else {
            totalOperates += operates
        }
    }
    
    print(totalOperates)
    
}