package basic.readwritefile

import java.io.File

fun main() {
    writeFileWithWriteText("src/basic/readwritefile/writeFile.txt", "Write line")
    appendTextToExistingFile("src/basic/readwritefile/writeFile.txt", "\nNew Write line")
}

fun writeFileWithWriteText(fileName: String, text: String) {
    File(fileName).writeText(text)
}

fun appendTextToExistingFile(fileName: String, text: String) {
    File(fileName).appendText(text)
}
