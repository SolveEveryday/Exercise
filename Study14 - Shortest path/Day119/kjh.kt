class Solution {
  fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
      val floyd = operateFloyd(n, fares)
      
      val noCarpoolCase = floyd[s][a] + floyd[s][b]
      
      var minCost = noCarpoolCase
      for (carpool in 1..n) {
          val oneOfCarpoolCases = floyd[s][carpool] + floyd[carpool][a] + floyd[carpool][b]
          minCost = minOf(minCost, oneOfCarpoolCases)
      }
      
      return minCost
  }
  
  fun operateFloyd(nodeCount: Int, edges: Array<IntArray>): Array<IntArray> {
      val floyd = Array(nodeCount+1) { IntArray(nodeCount+1) { 123456789 } }
      
      for (i in 1..nodeCount) {
          floyd[i][i] = 0
      }
      
      for (edge in edges) {
          val (node1, node2, cost) = edge
          floyd[node1][node2] = cost
          floyd[node2][node1] = cost
      }
      
      for (mid in 1..nodeCount) {
          for (start in 1..nodeCount) {
              for (end in 1..nodeCount) {
                  val shortcut = floyd[start][mid] + floyd[mid][end]
                  if (shortcut < floyd[start][end]) {
                      floyd[start][end] = shortcut
                  }
              }
          }
      }
      
      return floyd
  }
}