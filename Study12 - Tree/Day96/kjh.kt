fun main() {
    val T = readln().toInt()
    
    val sb = StringBuilder()
    repeat(T) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        repeat(M) {
            readln()
        }
        sb.append(N-1).append('\n')
    }
    print(sb)
}