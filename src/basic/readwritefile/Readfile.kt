import java.io.File

fun main() {
    readFileUsingForEachLine("src/basic/readwritefile/file.txt")
}

fun readFileUsingForEachLine(filename: String) {
    File(filename).forEachLine {
        print(it)
    }
}

fun readFileUsingLines(fileName: String): List<String> {
    return File(fileName).useLines {
        it.toList()
    }
}

fun readFileAsLines(fileName: String): List<String> {
    return File(fileName).readLines()
}
