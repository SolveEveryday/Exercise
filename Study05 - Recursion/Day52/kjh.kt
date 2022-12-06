import kotlin.math.*

fun main() {
    val (N, r, c) = readln().split(" ").map { it.toInt() }
    
    val sideLength = (2.0).pow(N).toInt()
    print(solve(sideLength, r + 1, c + 1))
}

fun solve(sideLength: Int, r: Int, c: Int): Int {
    val quadrant = getQuadrantNum(sideLength, r, c)
    if (sideLength == 2) {
        return quadrant - 1    
    }
    
    val half = sideLength / 2
    val area = sideLength * sideLength
    when (quadrant) {
        1 -> return solve(half, r, c)
        2 -> return area / 4 * 1 + solve(half, r, c - half)
        3 -> return area / 4 * 2 + solve(half, r - half, c)
        else -> return area / 4 * 3 + solve(half, r - half, c - half)
    }
}

fun getQuadrantNum(sideLength: Int, r: Int, c: Int): Int {
    val standard = sideLength / 2
    if (r <= standard && c <= standard) {
        return 1
    }
    if (r <= standard && c > standard) {
        return 2
    }
    if (r > standard && c <= standard) {
        return 3
    }
    return 4
}