val w = Array(21) { Array(21) { Array<Int?>(21) { null } } }

fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) {
            break
        }
        
        println("w($a, $b, $c) = ${funFun(a, b, c)}")
    }
}

fun funFun(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1
    }
    if (a > 20 || b > 20 || c > 20) {
        w[20][20][20] = w[20][20][20] ?: funFun(20, 20, 20)
        return w[20][20][20]!!
    }
    if (a < b && b < c) {
        w[a][b][c-1] = w[a][b][c-1] ?: funFun(a, b, c-1)
        w[a][b-1][c-1] = w[a][b-1][c-1] ?: funFun(a, b-1, c-1)
        w[a][b-1][c] = w[a][b-1][c] ?: funFun(a, b-1, c)
        return w[a][b][c-1]!! + w[a][b-1][c-1]!! - w[a][b-1][c]!!
    }
    w[a-1][b][c] = w[a-1][b][c] ?: funFun(a-1, b, c)
    w[a-1][b-1][c] = w[a-1][b-1][c] ?: funFun(a-1, b-1, c)
    w[a-1][b][c-1] = w[a-1][b][c-1] ?: funFun(a-1, b, c-1)
    w[a-1][b-1][c-1] = w[a-1][b-1][c-1] ?: funFun(a-1, b-1, c-1)

    return w[a-1][b][c]!! + w[a-1][b-1][c]!! + w[a-1][b][c-1]!! - w[a-1][b-1][c-1]!!
}