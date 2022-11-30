import java.util.*

fun main() {
    val T = readln().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    
    val sb = StringBuilder()
    for (i in 1..T) {
        val number = readln().toInt()
        if (number != 0) {
            pq.offer(number)
            continue
        }
        
        if (pq.size > 0) {
            sb.append(pq.poll()).append('\n')
        } else {
            sb.append(0).append('\n')
        }
    }
    
    print(sb)
}