import java.util.Stack

fun main() {
    val N = readln().toInt()
    val towerHeights = readln().split(" ").map { it.toInt() }
    
    val towers = ArrayList<Tower>()
    for (pos in N downTo 1) {
        towers.add(Tower(pos, towerHeights[pos-1]))
    }
    
    val recievedTowers = IntArray(N, { 0 })
    val stack = Stack<Tower>()
    for (tower in towers) {
        if (stack.isEmpty() || tower.height < stack.peek().height) {
            stack.push(tower)
            continue
        }
        
        while (stack.isNotEmpty() && tower.height >= stack.peek().height) {
            val sentTower = stack.pop()
            recievedTowers[sentTower.pos-1] = tower.pos
        }
        stack.push(tower)
    }
    
    val answer = recievedTowers.joinToString(separator=" ")
    print(answer)
}

data class Tower(val pos: Int, val height: Int)