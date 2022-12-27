fun main() {
    while (true) {
        val N = readlnOrNull()?.toInt() ?: -1
        if (N == -1) {
            break
        }
        println(makeKantor(N))
    }
}

fun makeKantor(N: Int): String {
    if (N == 0) {
        return "-"
    }
    
    val kantor = makeKantor(N-1)
    return kantor + " ".repeat(3.pow(N-1)) + kantor
}

fun Int.pow(n: Int): Int = Math.pow(toDouble(), n.toDouble()).toInt()