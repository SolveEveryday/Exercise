import java.util.PriorityQueue

fun main() {
    val pq = PriorityQueue<Long>()
    val (_, M) = readln().split(" ").map { it.toInt() }
    
    readln().split(" ").map { it.toLong() }.forEach { pq.offer(it) }
    
    repeat(M) {
        val card1 = pq.poll()
        val card2 = pq.poll()
        val sum = card1 + card2
        pq.offer(sum)
        pq.offer(sum)
    }
    
    print(pq.sum())
}
