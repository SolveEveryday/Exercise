import java.util.*

fun main() {
    val N = readln().toInt()
    val pq = PriorityQueue<Int>()

    val initNItems = readln().split(" ").map { it.toInt() }
    pq.addAll(initNItems)
    
    repeat(N-1) {
        val items = readln().split(" ").map{ it.toInt() }
        items.forEach { item -> 
            pq.offer(item)
            pq.poll()
        }
    }

    val nthLarge = pq.poll()
    print(nthLarge)
}