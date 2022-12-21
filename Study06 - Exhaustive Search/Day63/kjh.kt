import java.util.*

val minAttacks = Array(61) { Array(61) { Array(61) {0} } }

fun main() {
    readln()
    val scv = readln().split(" ").map { it.toInt() }

    print(
        getMinAttacks(
            scv.get(0),
            scv.getOrNull(1) ?: 0,
            scv.getOrNull(2) ?: 0
        )
    )
}

fun getMinAttacks(a: Int, b: Int, c: Int): Int {
    if (a < 0) return getMinAttacks(0, b, c)
    if (b < 0) return getMinAttacks(a, 0, c)
    if (c < 0) return getMinAttacks(a, b, 0)

    if (a == 0 && b == 0 && c == 0) {
        return 0
    }
    
    if (minAttacks[a][b][c] != 0) {
        return minAttacks[a][b][c]
    }
    
    minAttacks[a][b][c] = getMinAttacks(a-9, b-3, c-1) + 1
    minAttacks[a][b][c] = Math.min(minAttacks[a][b][c], getMinAttacks(a-9, b-1, c-3) + 1)
    minAttacks[a][b][c] = Math.min(minAttacks[a][b][c], getMinAttacks(a-3, b-9, c-1) + 1)
    minAttacks[a][b][c] = Math.min(minAttacks[a][b][c], getMinAttacks(a-3, b-1, c-9) + 1)
    minAttacks[a][b][c] = Math.min(minAttacks[a][b][c], getMinAttacks(a-1, b-9, c-3) + 1)
    minAttacks[a][b][c] = Math.min(minAttacks[a][b][c], getMinAttacks(a-1, b-3, c-9) + 1)
    
    return minAttacks[a][b][c]
}
