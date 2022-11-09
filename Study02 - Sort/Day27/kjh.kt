fun main() {
    readln()
    val liquids = readln().split(" ").map { it.toInt() }.toMutableList()
    
    val initMixedLiquid = liquids[0] + liquids[1]
    var minMixed = Math.abs(initMixedLiquid)
    var sign = if (initMixedLiquid >= 0) +1 else -1
    
    for (i in 0..liquids.size-2) {
        val standard = liquids[i]
        var left = i + 1
        var right = liquids.size - 1
        
        while (left <= right) {
            val mid = (left + right) / 2
            
            val mixedLiquid = standard + liquids[mid]
            if (Math.abs(mixedLiquid) < minMixed) {
                minMixed = Math.abs(mixedLiquid)
                sign = if (mixedLiquid >= 0) +1 else -1
            }
            
            if (mixedLiquid == 0) {
                print(0)
                return
            }
            if (mixedLiquid < 0) {
                left = mid + 1
                continue
            }
            right = mid - 1
        }
    }
    
    print(minMixed * sign)
}