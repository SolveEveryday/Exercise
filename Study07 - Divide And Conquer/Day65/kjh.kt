fun main() {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val K = readln().toInt()
    
    val bundleSize = N / K
    val bundles = numbers.chunked(bundleSize)
    
    for (bundle in bundles) {
        print(bundle.sorted().joinToString(separator = " ", postfix = " "))
    }
}
