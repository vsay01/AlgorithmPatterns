package basic.console

fun main() {
    println("Input your first name")
    val firstName = readlnOrNull()
    println("Input your last name")
    val lastName = readlnOrNull()
    println("Hi $firstName $lastName, let us have a quick math test. Enter two numbers separated by space.")
    val (a, b) = readlnOrNull()?.split(' ')?.map(String::toInt) ?: listOf(0, 0)
    println("what is $a + $b ?")
    println("Your answer is ${if (readlnOrNull()?.toInt() == (a + b)) "correct" else "incorrect"}")
    println("Correct answer = ${a + b}")
    println("what is $a * $b ?")
    println("Your answer is ${if (readlnOrNull()?.toInt() == (a * b)) "correct" else "incorrect"}")
    println("Correct answer = ${a * b}")
}
