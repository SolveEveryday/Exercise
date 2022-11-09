fun main() {
    val N = readln().toInt()
    
    var coordinates = readln().split(" ").map{ it.toInt() }.toCollection(ArrayList())
    val sortedCoordinates = quickSort(coordinates)
    
    val map = HashMap<Int, Int>()
    var compressed = 0
    for (coordinate in sortedCoordinates) {
        map[coordinate] = compressed++
    }

    val result = StringBuilder()
    for (i in 0..N-1){
        result.append(map.get(coordinates[i])).append(' ')
    }
    print(result)
}

fun quickSort(items: List<Int>): List<Int> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val left = items.filter { it < pivot }
    val right = items.filter { it > pivot }

    return quickSort(left) + pivot + quickSort(right)
}