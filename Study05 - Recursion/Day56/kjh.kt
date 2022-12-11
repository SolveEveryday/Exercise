fun main() {
    val N = readln().toInt()
    
    val pixels = Array(N) { Array<Boolean>(N) { false } }
    for (i in 0..N-1) {
        val pixelsInLine = readln()
        for (j in 0..N-1) {
            pixels[i][j] = if (pixelsInLine[j] == '1') true else false
        }
    }
    
    print(compress(pixels, N, 0, 0))
}

fun compress(pixels: Array<Array<Boolean>>, size: Int, y: Int, x: Int): String {
    val head = pixels[y][x]
    if (areAllEqual(pixels, size, y, x)) {
        return (if (head) "1" else "0")
    }
    
    val sb = StringBuilder()
    sb.append('(')
    
    val half = size / 2
    sb.append(compress(pixels, half, y, x))
    sb.append(compress(pixels, half, y, x + half))
    sb.append(compress(pixels, half, y + half, x))
    sb.append(compress(pixels, half, y + half, x + half))
    
    sb.append(')')
    
    return sb.toString()
}

fun areAllEqual(pixels: Array<Array<Boolean>>, size: Int, y: Int, x: Int): Boolean {
    val head = pixels[y][x]
    
    for (i in y..y+size-1) {
        for (j in x..x+size-1) {
            if (pixels[i][j] != head) {
                return false
            }
        }
    }
    
    return true
}