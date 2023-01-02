val boxes = ArrayList<Int>()
val maxBoxes = IntArray(1000)

fun main() {
    val N = readln().toInt()
    readln().split(" ").map { boxes.add(it.toInt()) }
    
    var maxOfMax = 0
    for (toIdx in 0..N-1) {
        maxOfMax = Math.max(getMaxBoxes(toIdx), maxOfMax)
    }
    
    print(maxOfMax)
}

fun getMaxBoxes(toIdx: Int): Int {
    if (toIdx < 0) return 0
    if (maxBoxes[toIdx] > 0) return maxBoxes[toIdx]
    
    var recursionMax = 0
    for (i in 0..toIdx-1) {
        if (boxes[i] < boxes[toIdx]) {
            val recursion = getMaxBoxes(i)
            recursionMax = Math.max(recursion, recursionMax)
        }
    }
    
    maxBoxes[toIdx] = recursionMax + 1
    return maxBoxes[toIdx]
}
