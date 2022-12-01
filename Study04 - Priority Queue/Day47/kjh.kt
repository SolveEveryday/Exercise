import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    val pq = PriorityQueue<AbsoluteNumber>()
    
    val result = StringBuilder()
    repeat(N) {
        val num = readln().toInt()
        if (num == 0) {
            result.append(pq.poll()?.num ?: 0).append('\n')
        } else {
            pq.offer(AbsoluteNumber(num, Math.abs(num)))
        }
    }
    
    print(result)
}

data class AbsoluteNumber(val num: Int, val absNum: Int) : Comparable<AbsoluteNumber> {
    override fun compareTo(other: AbsoluteNumber) = when {
        (absNum != other.absNum) -> absNum - other.absNum
        else -> num - other.num
    }
}