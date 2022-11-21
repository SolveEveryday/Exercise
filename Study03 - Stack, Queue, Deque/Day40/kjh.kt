import java.util.Stack

fun main() {
    val N = readln().toInt()
    val towerHeights = readln().split(" ").map { it.toInt() }
    
    val reversedTowers = ArrayList<Tower>()
    for (pos in N downTo 1) {
        reversedTowers.add(Tower(pos, towerHeights[pos-1]))
    }
    
    val receivedPos = IntArray(N, { 0 })
    val stack = Stack<Tower>()
    for (tower in reversedTowers) {
        if (stack.isEmpty() || tower.height < stack.peek().height) {
            stack.push(tower)
            continue
        }
        
        while (stack.isNotEmpty() && tower.height >= stack.peek().height) {
            val sentTower = stack.pop()
            receivedPos[sentTower.pos-1] = tower.pos
        }
        stack.push(tower)
    }
    
    val answer = receivedPos.joinToString(separator=" ")
    print(answer)
}

data class Tower(val pos: Int, val height: Int)