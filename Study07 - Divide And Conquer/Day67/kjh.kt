fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    print(getSolution(a, b, c))
}

fun getSolution(a: Long, b: Long, c: Long): Long {
    if (b == 1L) {
        return a % c
    }

    val prevSolution = getSolution(a, b/2, c) % c
    var solution = (prevSolution * prevSolution) % c
    if (b % 2 == 1L) {
        solution = (solution * a) % c
    }
    return solution
}
