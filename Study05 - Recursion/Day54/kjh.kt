fun main() {
    val height = readln().toInt()
    val width = height * 2 - 1
    
    val triangle = Array(height) { Array<Boolean>(width) { false } }
    
    makeTriangle(triangle, height, 0, 0)
    printTriangle(triangle)
}

fun makeTriangle(triangle: Array<Array<Boolean>>, height: Int, y: Int, x: Int) {
    if (height == 3) {
        makeSmallestTriangle(triangle, y, x)
        return
    }
    
    val halfHeight = height / 2
    makeTriangle(triangle, halfHeight, y             , x + halfHeight)
    makeTriangle(triangle, halfHeight, y + halfHeight, x       )
    makeTriangle(triangle, halfHeight, y + halfHeight, x + height    )
}

fun makeSmallestTriangle(triangle: Array<Array<Boolean>>, y: Int, x: Int) {
    triangle[y][x+2] = true
    triangle[y+1][x+1] = true
    triangle[y+1][x+3] = true
    for (i in 0..4) {
      triangle[y+2][x+i] = true
    }
}

fun printTriangle(triangle: Array<Array<Boolean>>) {
    val sb = StringBuilder()
    
    val height = triangle.size
    val width = triangle[0].size
    
    for (y in 0..height-1) {
        for (x in 0..width-1) {
            if (triangle[y][x] == true) {
                sb.append('*')
            } else {
                sb.append(' ')
            }
        }
        sb.append('\n')
    }
    print(sb)
}