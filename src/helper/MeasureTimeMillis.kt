package helper

inline fun <T> measureTimeMillis(
    message: String,
    function: () -> T
): T {

    val startTime = System.currentTimeMillis()
    val result: T = function.invoke()
    println(message + (System.currentTimeMillis() - startTime) + "ms")

    return result
}