import java.util.*

fun main() {
    val T = readln().toInt()
    
    val result = StringBuilder()
    repeat(T) {
        val (numberOfDocs, targetDoc) = readln().split(" ").map { it.toInt() }
        val priorities = readln()
        
        val printerQueue = PrinterQueue(numberOfDocs, priorities)
        for (i in 1..numberOfDocs) {
            val printedDoc = printerQueue.print()
            if (printedDoc == targetDoc) {
                result.append(i).append('\n')
                break
            }
        }
    }
    
    print(result)
}

class PrinterQueue {
    val queue: Queue<Int>
    val priorities: Queue<Int>
    
    constructor(numberOfDocs: Int, strPriorities: String) {
    queue = LinkedList<Int>()
    for (i in 0..numberOfDocs-1) {
        queue.add(i)
    }
    
    priorities = LinkedList<Int>()
    strPriorities.split(" ")
        .map { it.toInt() }
        .forEach { priorities.add(it) }
    }
    
    fun print(): Int {
        while (queue.size > 0) {
            val highestPriority = priorities.maxOrNull() ?: -1
            
            val dequeued = queue.remove()
            val priority = priorities.remove()
            
            if (priority == highestPriority) {
                return dequeued
            }
            
            queue.add(dequeued)
            priorities.add(priority)
        }
        return -1
    }
}