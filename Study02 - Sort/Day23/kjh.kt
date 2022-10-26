fun main() {
    val N = readln().toInt()
    val honors = ArrayList<Int>()
    repeat(N) {
        val honor = readln().toInt()
        honors.add(honor)
    }
    
    val sortedHonors = quickSort(honors)
    var hackers = 0L
    var oneToN = 1
    
    for (honor in sortedHonors) {
        val hackerNeeded = honor - oneToN
        if (hackerNeeded >= 0) {
            oneToN++
            hackers += hackerNeeded
        }
    }
    print(hackers)
}

fun quickSort(items: List<Int>): List<Int> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val left = items.filter { it < pivot }
    val right = items.filter { it > pivot }

    return quickSort(left) + items.filter { it == pivot } + quickSort(right)
}