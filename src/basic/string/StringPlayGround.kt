package basic.string

fun main() {
    val str = "This is a string."
    println("length: " + str.length) // length is a property
    println("=========ForEach==============")
    str.forEach {
        println(it)
    }
    println("=========Split==============")
    str.split(" ").forEach {
        println(it)
    }
}
