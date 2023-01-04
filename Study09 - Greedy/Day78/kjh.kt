fun main() {
    val N = readln().toInt()
    
    var bags = 0
    var delivered = 0
    while (delivered < N) {
        val remaining = N - delivered
    
        if (remaining % 5 == 0) {
            bags += remaining / 5
            delivered += remaining
            break
        }
        if (remaining < 3) {
            bags = -1
            break
        }
        
        bags++
        delivered += 3
    }
    
    print(bags)
}