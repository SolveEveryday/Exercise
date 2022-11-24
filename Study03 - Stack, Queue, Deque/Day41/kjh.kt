import java.util.Stack

fun main() {
    val queue = ArrayDeque<Ticket>()
    val N = readln().toInt()
    repeat(N) {
        val ticketCodes = readln().split(" ")
        for (ticketCode in ticketCodes) {
            val (alphabet, strNumber) = ticketCode.split("-")
            
            val ticket = Ticket(alphabet, strNumber.toInt())
            queue.addLast(ticket)
        }
    }
    
    val sortedQueue = ArrayDeque(
        queue.sortedWith(
            compareBy<Ticket> { it.alphabet }
            .thenBy { it.number }
        )
    )
    val stack = ArrayDeque<Ticket>()
    
    while (sortedQueue.isNotEmpty()) {
        if (queue.firstOrNull() == sortedQueue.first()) {
            queue.removeFirst()
            sortedQueue.removeFirst()
            continue
        }
        
        if (stack.firstOrNull() == sortedQueue.first()) {
            stack.removeFirst()
            sortedQueue.removeFirst()
            continue
        }
        
        if (queue.isEmpty()) {
            print("BAD")
            return
        }
        
        stack.addFirst(queue.removeFirst())
    }
    
    print("GOOD")
}

data class Ticket(val alphabet: String, val number: Int)