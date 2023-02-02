fun main() {
    val N = readln().toInt()
    
    val files = mutableListOf<File>()
    for (i in 0..N-1) {
        val strContentIncludingMinusOne = readln()
        val strContent = strContentIncludingMinusOne.substring(0, strContentIncludingMinusOne.length-3)
        
        val content = strContent.split(" ").map { it.toInt() }
        val file = File(content)
        files.add(file)
    }
    
    var k = 0
    while (files.size > 0) {
        val uniqueFilesAtK = getUniqueFilesAtK(files, k)
        files.removeAll(uniqueFilesAtK)
        k++
    }
    
    print(k)
}

fun getUniqueFilesAtK(files: List<File>, k: Int): List<File> {
    val distinctFiles = files.distinctBy { it[k] }
    
    val uniqueFiles = mutableListOf<File>()
    for (file in distinctFiles) {
        val fileCount = files.count { it[k] == file[k] }
        if (fileCount == 1) {
            uniqueFiles.add(file)
        }
    }
    
    return uniqueFiles.toList()
}

data class File(val content: List<Int>) {
    operator fun get(index: Int) = content.getOrNull(index) ?: -1
}