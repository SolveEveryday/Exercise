class Solution {
    var visited = BooleanArray(200)
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        for (i in 0..n-1) {
            if (visited[i]) continue
            dfs(i, computers)
            answer++
        }
        return answer
    }
    
    fun dfs(node: Int, adjacencyMatrix: Array<IntArray>) {
        visited[node] = true
        
        adjacencyMatrix[node].forEachIndexed { idx, adjacency ->
            if (adjacency != 0 && visited[idx] == false) {
                dfs(idx, adjacencyMatrix)
            }
        }
    }
}