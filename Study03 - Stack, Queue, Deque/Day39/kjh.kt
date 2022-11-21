class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): ArrayList<Int> {
        val answer = ArrayList<Int>()
        
        var i = 0
        while (i < speeds.size) {
            val bundleOfDays = getRequiredDays(progresses[i], speeds[i])
            
            var bundleOfDeploys = 1
            for (j in i+1..speeds.size-1) {
                val requiredDays = getRequiredDays(progresses[j], speeds[j])
                if (requiredDays > bundleOfDays) {
                    break
                }
                bundleOfDeploys++
            }
            
            answer.add(bundleOfDeploys)
            i += bundleOfDeploys
        }
    
        return answer
    }
    
    fun getRequiredDays(progress: Int, speed: Int) = Math.ceil((100.0-progress) / speed)
}