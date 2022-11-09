fun main() {
    val N = readln().toInt()
    
    val villages = ArrayList<Pair<Int, Int>>()
    var sumOfPeople = 0L
    repeat(N) {
        val (position, people) = readln().split(" ").map { it.toInt() }
        sumOfPeople += people
        villages.add(Pair(position, people))
    }
    
    val sortedVillages = quickSort(villages)
    val middleSumOfPeople = (sumOfPeople + 1) / 2
    
    var sum = 0L
    for (village in sortedVillages) {
        sum += village.second
        if (sum >= middleSumOfPeople) {
            print(village.first)
            break
        }
    }
}

fun quickSort(items: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val left = items.filter { it.first < pivot.first }
    val right = items.filter { it.first > pivot.first }

    return quickSort(left) + items.filter { it.first == pivot.first } + quickSort(right)
}