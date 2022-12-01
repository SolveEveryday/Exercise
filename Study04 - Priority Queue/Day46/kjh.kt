import java.util.PriorityQueue

fun main() {
    val pq = PriorityQueue<Int>()
    val N = readln().toInt()
    repeat(N) {
        val cards = readln().toInt()
        pq.offer(cards)
    }
    
    var countSum = 0
    while (pq.size > 1) {
        val cards1 = pq.poll()
        val cards2 = pq.poll()
        
        val sum = cards1 + cards2
        countSum += sum
        pq.offer(sum)
    }
    
    print(countSum)
}
