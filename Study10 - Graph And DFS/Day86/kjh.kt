fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    
    val computers = Array(N+1) { Computer() }
    repeat(M) {
        val (c1, c2) = readln().split(" ").map { it.toInt() }
        computers[c1].connect(computers[c2])
        computers[c2].connect(computers[c1])
    }
    
    infect(computers[1])
    print(computers.count { it.infected == true } - 1)
}

fun infect(target: Computer) {
    target.infect()
    
    for (connected in target.connected) {
        if (connected.infected == true) continue
        infect(connected)
    }
}

class Computer(var infected: Boolean = false, val connected: MutableList<Computer> = mutableListOf<Computer>()) {
    fun connect(computer: Computer) = connected.add(computer)
    fun infect() {
        infected = true
    }
}