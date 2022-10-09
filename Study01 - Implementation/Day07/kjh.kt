var row = 0
var col = 0

fun main() {
    val sizeInfos = readln().split(" ")
    row = sizeInfos[0].toInt()
    col = sizeInfos[1].toInt()
    
    val storeCount = readln().toInt()
    val stores = arrayOfNulls<Location>(storeCount)
    for (i in 0 until storeCount) {
        val (direction, position) = readln().split(" ").map { it.toInt() }
        stores[i] = Location(direction, position)
    }
    
    val (direction, position) = readln().split(" ").map { it.toInt() }
    val dongGeun = Location(direction, position)
    
    var sumOfDistances = 0
    for (store in stores) {
        sumOfDistances += dongGeun.getShortestDistance(store!!)
    }
    print(sumOfDistances)
}


data class Location(val direction: Int, val position: Int) {
    fun getShortestDistance(location: Location): Int {
        val sameDirection = location.direction == this.direction
        if (sameDirection) {
            return Math.abs(location.position - this.position)
        }
        
        val oppositeDirection = (location.direction + this.direction) == 3 ||  (location.direction + this.direction) == 7
        if (oppositeDirection) {
            val distanceToOpposite = getDistanceToOpposite()
        
            val clockwise = location.position + this.position + distanceToOpposite
            val counterclockwise = (getMyDirectionBlocks() - this.position) + (location.getMyDirectionBlocks() - location.position) + distanceToOpposite
            return Math.min(clockwise, counterclockwise)
        }
        
        return getDistanceToDirection(location.direction) + location.getDistanceToDirection(this.direction)
    }
    
    fun getMyDirectionBlocks(): Int {
        return when (this.direction) {
            1, 2 -> row
            3, 4 -> col
            else -> -1
        }
    }
    
    fun getDistanceToOpposite(): Int {
        return when (this.direction) {
            1, 2 -> col
            3, 4 -> row
            else -> -1
        }
    }
    
    fun getDistanceToDirection(direction: Int): Int {
        if (this.direction <= 2) {
            if (direction == 3) return position
            if (direction == 4) return getMyDirectionBlocks() - position
        }
        if (this.direction >= 3) {
            if (direction == 1) return position
            if (direction == 2) return getMyDirectionBlocks() - position
        }
        return -1
    }
}