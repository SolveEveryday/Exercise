import java.util.*

fun main() {
    val N = readln().toInt()
    
    val pillars = ArrayList<Pillar>()
    var highestPillars = ArrayList<Pillar>()
    highestPillars.add(Pillar(0, 0))
    
    repeat(N) {
        val (pos, height) = readln().split(" ").map { it.toInt() }
        val pillar = Pillar(pos, height) 
        pillars.add(pillar)
        
        if (pillar.height > highestPillars[0].height) {
            highestPillars = ArrayList<Pillar>()
            highestPillars.add(pillar)
        } else if (pillar.height == highestPillars[0].height) {
            highestPillars.add(pillar)
        }
    }
    
    if (pillars.size == 1) {
        print(pillars[0].height)
        return
    }
    
    pillars.sortBy { it.pos }
    highestPillars.sortBy { it.pos }
    
    val leftStack = Stack<Pillar>()
    leftStack.push(pillars[0])
    for (i in 1..pillars.size-1) {
        val pillar = pillars[i]
        if (highestPillars.contains(pillar)) {
            break
        }
        if (pillar.height > leftStack.peek().height) {
            leftStack.push(pillar)
        }
    }
    
    val rightStack = Stack<Pillar>()
    rightStack.push(pillars[pillars.size-1])
    for (i in pillars.size-2 downTo 0) {
        val pillar = pillars[i]
        if (highestPillars.contains(pillar)) {
            break
        }
        if (pillar.height > rightStack.peek().height) {
            rightStack.push(pillar)
        }
    }
    
    var leftArea = 0
    var standardPos = highestPillars[0].pos
    while (leftStack.isNotEmpty()) {
        val current = leftStack.pop()
        leftArea += (standardPos - current.pos) * current.height
        
        standardPos = current.pos
    }
    
    var rightArea = 0
    standardPos = highestPillars[highestPillars.size-1].pos
    while (rightStack.isNotEmpty()) {
        val current = rightStack.pop()
        rightArea += (current.pos - standardPos) * current.height
        
        standardPos = current.pos
    }
    
    val highestArea = highestPillars[0].height * (highestPillars[highestPillars.size-1].pos - highestPillars[0].pos + 1)
    
    print(leftArea + rightArea + highestArea)
}

data class Pillar(val pos: Int, val height: Int)