fun main() {
    val N = readln().toInt()
    
    val numbers = ArrayList<Pair<Int, Int>>()
    for (idx in 0..N-1) {
        val number = readln().toInt()
        numbers.add(Pair(number, idx))
    }
    
    mergeSort(numbers)
    
    var longestLeftMoves = 0
    for ((indexAfterSort, numberAndPreviousIndex) in numbers.withIndex()) {
        val indexBeforeSort = numberAndPreviousIndex.second
        val leftMoves = indexBeforeSort - indexAfterSort
        longestLeftMoves = Math.max(longestLeftMoves, leftMoves)
    }
    print(longestLeftMoves + 1)
}

fun mergeSort(numbers: ArrayList<Pair<Int, Int>>, start: Int = 0, end: Int = numbers.size-1) {
    if (start >= end) return

    val mid = (start + end) / 2
    mergeSort(numbers, start, mid)
    mergeSort(numbers, mid + 1, end)

    merge(numbers, start, mid, end)
}

fun merge(numbers: ArrayList<Pair<Int, Int>>, start: Int, mid: Int, end: Int) {
    val merged = ArrayList<Pair<Int, Int>>()
    var left = start
    var right = mid + 1

    while (left <= mid && right <= end) {
        if (numbers[left].first <= numbers[right].first) {
            merged.add(numbers[left])
            left++
        } else {
            merged.add(numbers[right])
            right++
        }
    }

    if (left > mid) {
        for (i in right..end) {
            merged.add(numbers[i])
        }
    }

    if (right > end) {
        for (i in left..mid) {
            merged.add(numbers[i])
        }
    }

    for (i in merged.indices) {
        numbers.set(start + i, merged[i])
    }
}