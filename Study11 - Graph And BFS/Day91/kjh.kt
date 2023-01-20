import java.util.*

fun main() {
    val (A, B) = readln().split(" ").map { it.toLong() }
    
    val queue: Queue<Node> = LinkedList<Node>()
    queue.offer(Node(A, 1))
    
    while (queue.size > 0) {
        val (num, depth) = queue.poll()
        
        val oper1 = num * 2
        if (oper1 < B) queue.add(Node(oper1, depth+1))
        if (oper1 == B) {
            print(depth+1)
            return
        }
        
        val oper2 = num * 10 + 1
        if (oper2 < B) queue.add(Node(oper2, depth+1))
        if (oper2 == B) {
            print(depth+1)
            return
        }
    }
    
    print(-1)
}

data class Node(val num: Long, val depth: Int)