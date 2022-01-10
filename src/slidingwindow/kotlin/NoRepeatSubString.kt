package slidingwindow.kotlin

import helper.measureTimeMillis

/*
* Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
* */

fun noRepeatSubString(str: String): Int {
    var noRepeatSubStringLen = 0
    val hashMap = HashMap<Char, Int>()
    for (windowEnd in str.indices) {
        val curWeVal = str[windowEnd]
        if (!hashMap.containsKey(curWeVal)) {
            hashMap[curWeVal] = 1
        } else {
            noRepeatSubStringLen = hashMap.size
            hashMap.clear()
        }
    }
    return noRepeatSubStringLen
}

fun main() {
    println("expected output = 3")
    println(measureTimeMillis("noRepeatSubString took ") {
        "output = " + noRepeatSubString("aabccb")
    })
    println("==========================================")
    println("expected output = 2")
    println(measureTimeMillis("noRepeatSubString took ") {
        "output = " + noRepeatSubString("abbbb")
    })
    println("==========================================")
    println("expected output = 3")
    println(measureTimeMillis("noRepeatSubString took ") {
        "output = " + noRepeatSubString("abccde")
    })
}