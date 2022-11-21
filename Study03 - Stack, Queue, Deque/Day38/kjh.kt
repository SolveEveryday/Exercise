class Solution {
    fun solution(bridgeLength: Int, weightLimit: Int, truckWeights: IntArray): Int {
        val bridge = ArrayDeque<TruckInBridge>()
        
        var currentWeight = 0
        for (truckWeight in truckWeights) {
            val lastEnteredSec = (bridge.lastOrNull()?.enteredSec) ?: 0
            if (currentWeight + truckWeight <= weightLimit) {
                bridge.addLast(TruckInBridge(truckWeight, lastEnteredSec + 1))
                currentWeight += truckWeight
                continue
            }
            
            var lastDequeued = TruckInBridge(0, 0)
            while (currentWeight + truckWeight > weightLimit) {
                lastDequeued = bridge.removeFirst()
                currentWeight -= lastDequeued.weight
            }
            
            bridge.addLast(TruckInBridge(truckWeight, Math.max(lastEnteredSec + 1, lastDequeued.enteredSec + bridgeLength)))
            currentWeight += truckWeight
        }
        
        return bridge.last().enteredSec + bridgeLength
    }
}

data class TruckInBridge(val weight: Int, val enteredSec: Int)