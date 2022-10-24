fun main() {
    readln()
    val aSet = HashSet<Int>()
    aSet.addAll(readln().split(" ").map { it.toInt() })
    
    val bSet = HashSet<Int>()
    bSet.addAll(readln().split(" ").map { it.toInt() })
    
    val subtracted = aSet.subtract(bSet)
    
    val list = subtracted.toList()
    val sortedList = quickSort(list)
    
    println(sortedList.size)
    if (sortedList.size == 0) {
        return
    }
    print(sortedList.joinToString(" "))
}

fun quickSort(items: List<Int>): List<Int> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val left = items.filter { it < pivot }
    val right = items.filter { it > pivot }

    return quickSort(left) + listOf(pivot) + quickSort(right)
}