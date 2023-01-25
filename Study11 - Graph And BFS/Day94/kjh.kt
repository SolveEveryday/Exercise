import java.util.*

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    
    val minDistance = IntArray(100001) { Int.MAX_VALUE }
    
    val queue: Queue<Int> = LinkedList<Int>()
    queue.offer(N)
    minDistance[N] = 0
    
    while (queue.size > 0) {
        val current = queue.poll()
        
        if (current == K) {
            print(minDistance[current])
            break
        }
        
        val goBackward = current - 1
        if (goBackward >= 0 && minDistance[goBackward] > minDistance[current] + 1) {
            queue.add(goBackward)
            minDistance[current-1] = minDistance[current] + 1
        }
        
        if (current > K) {
            continue
        }
        
        val goForward = current + 1
        if (goForward <= 100000 && minDistance[goForward] > minDistance[current] + 1) {
            queue.add(goForward)
            minDistance[current+1] = minDistance[current] + 1
        }
        
        val teleport = current * 2
        if (teleport <= 100000 && minDistance[teleport] > minDistance[current]) {
            queue.add(teleport)
            minDistance[current*2] = minDistance[current]
        }
    }
}