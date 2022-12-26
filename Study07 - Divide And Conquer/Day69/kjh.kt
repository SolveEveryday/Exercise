val papers = ArrayList<ArrayList<Int>>()

fun main() {
    val N = readln().toInt()
    
    repeat(N) {
        val linePapers = readln().split(" ").map { it.toInt() }
        papers.add(ArrayList(linePapers))
    }
    
    val nzp = countNZP(size = N, startY = 0, startX = 0)
    print(nzp.joinToString("\n"))
}

fun countNZP(size: Int, startY: Int, startX: Int): IntArray {
    val nzp = IntArray(3)
    
    if (areAllEqual(size, startY, startX)) {
        nzp[papers[startY][startX]+1] += 1
        return nzp
    }
    
    val recSize = size / 3
    for (i in 0..2) {
        for (j in 0..2) {
            val recursion = countNZP(recSize, startY + (recSize * i), startX + (recSize * j))
            nzp[0] += recursion[0]
            nzp[1] += recursion[1]
            nzp[2] += recursion[2]
        }
    }
    
    return nzp
}

fun areAllEqual(size: Int, startY: Int, startX: Int): Boolean {
    val standard = papers[startY][startX]
    
    for (i in startY..startY+size-1) {
        for (j in startX..startX+size-1) {
            if (papers[i][j] != standard) {
                return false
            }
        }
    }
    
    return true
}