fun main() {
    val T = readln().toInt()
    
    repeat(T) {
        val (M, N, K) = readln().split(" ").map { it.toInt() }
        val field = Array(M) { BooleanArray(N) }
        repeat(K) {
            val (y, x) = readln().split(" ").map { it.toInt() }
            field[y][x] = true
        }
        
        val requiredWorm = countRequiredWorm(field)
        println(requiredWorm)
    }
}

fun countRequiredWorm(field: Array<BooleanArray>): Int {
    val visited = Array(field.size) { BooleanArray(field[0].size) }
    
    var requiredWorm = 0
    for (y in 0..field.size-1) {
        for (x in 0..field[0].size-1) {
            if (field[y][x] == false || visited[y][x]) continue
            dfs(visited, field, y, x)
            requiredWorm++
        }
    }
    return requiredWorm
}

fun dfs(visited: Array<BooleanArray>, field: Array<BooleanArray>, y: Int, x: Int) {
    visited[y][x] = true
    
    val dy = arrayOf(-1, +1, 0, 0)
    val dx = arrayOf(0, 0, -1, +1)
    for (i in 0..3) {
        val aroundY = y + dy[i]
        val aroundX = x + dx[i]
        
        val outOfIndex = aroundY < 0 || aroundX < 0 || aroundY >= visited.size || aroundX >= visited[0].size
        if (outOfIndex || visited[aroundY][aroundX] || field[aroundY][aroundX] == false) continue
        
        dfs(visited, field, aroundY, aroundX)
    }
}