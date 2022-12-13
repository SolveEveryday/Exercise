var blue = 0
var white = 0

fun main() {
    val N = readln().toInt()
    val papers = Array(N) { Array(N) { false } }
    
    for (i in 0..N-1) {
        val linePapers = readln().split(" ")
        for (j in 0..N-1) {
            papers[i][j] = linePapers[j] == "1"
        }
    }

    slicePapers(papers, N, 0, 0)
    print("$white\n$blue")
}

fun slicePapers(papers: Array<Array<Boolean>>, size: Int, y: Int, x: Int) {
    if (areAllEqual(papers, size, y, x)) {
        if (papers[y][x]) {
            blue++
        } else {
            white++
        }
        return
    }
    
    val half = size / 2
    slicePapers(papers, half, y, x)
    slicePapers(papers, half, y, x + half)
    slicePapers(papers, half, y + half, x)
    slicePapers(papers, half, y + half, x + half)
}

fun areAllEqual(papers: Array<Array<Boolean>>, size: Int, y: Int, x: Int): Boolean {
    val standard = papers[y][x]
    for (i in y..y+size-1) {
        for (j in x..x+size-1) {
            if (papers[i][j] != standard) {
                return false
            }
        }
    }
    return true
}