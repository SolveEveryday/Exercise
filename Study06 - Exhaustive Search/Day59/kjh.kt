fun main() {
    val dwarfs = ArrayList<Int>()
    
    repeat(9) {
        val height = readln().toInt()
        dwarfs.add(height)
    }
    
    dwarfs.exceptFake()
    dwarfs.sort()

    print(dwarfs.joinToString("\n"))
}

fun ArrayList<Int>.exceptFake() {
    for (i in 0..8) {
        for (j in (i+1)..8) {
            val heightA = this[i]
            val heightB = this[j]
            
            val isFake = (this.sum() - heightA - heightB) == 100
            if (isFake) {
                this.removeAt(i)
                this.removeAt(j-1)
                return
            }
        }
    }
}
