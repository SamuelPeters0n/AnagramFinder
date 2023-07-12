import java.io.File

fun main() {
    val filePath = "src/ordbok-utf8.txt"
    File(filePath).readLines().filter { it.isNotBlank() }
        .groupBy { it.toCharArray().sorted().joinToString("") }
        .values.filter { it.size > 1 }
        .forEach { println(it.joinToString(" ")) }
}
