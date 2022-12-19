fun main() {
    val (targetE, targetS, targetM) = readln().split(" ").map { it.toInt() }
    var (e, s, m) = Triple(1, 1, 1)

    var year = 1
    while (e != targetE || s != targetS || m != targetM) {
        e = e%15 + 1
        s = s%28 + 1
        m = m%19 + 1
        year++
    }
    
    print(year)
}