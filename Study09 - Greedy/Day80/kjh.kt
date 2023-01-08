import java.util.PriorityQueue

fun main() {
    val T = readln().toInt()
    
    val sb = StringBuilder()
    repeat(T) {
        readln()
        val strPriceByDay = readln()
        
        val maxRevenues = getMaxRevenues(strPriceByDay)
        sb.append(maxRevenues).append('\n')
    }
    print(sb)
}

fun getMaxRevenues(strPriceByDay: String): Long {
    val priceByDay = strPriceByDay.split(" ").map { it.toInt() }.toList()
    val willBeHigher = BooleanArray(priceByDay.size)
    
    var currentMax = priceByDay.last()
    for (i in priceByDay.size-2 downTo 0) {
        if (priceByDay[i] < currentMax) {
            willBeHigher[i] = true
        } else {
            currentMax = priceByDay[i]
        }
    }
    
    var stocks = 0L
    var revenues = 0L
    for (i in 0..priceByDay.size-1) {
        if (willBeHigher[i]) {
            stocks++
            revenues -= priceByDay[i]
        } else {
            revenues += priceByDay[i] * stocks
            stocks = 0
        }
    }
    
    return revenues
}