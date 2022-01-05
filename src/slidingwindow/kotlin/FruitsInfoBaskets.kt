package slidingwindow.kotlin

import helper.measureTimeMillis
import kotlin.math.max

/*
* Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
*
* */

fun fruitsIntoBasket(charArray: CharArray): Int {
    var longestLen = Int.MIN_VALUE
    var windowStart = 0
    val hashMap: HashMap<Char, Int> = HashMap()

    for (windowEnd in charArray.indices) {
        val currentEndChar = charArray[windowEnd]
        //insert character to hashmap with its count
        if (hashMap.contains(currentEndChar)) {
            hashMap[currentEndChar]?.let {
                hashMap[currentEndChar] = it + 1
            }
        } else {
            hashMap[currentEndChar] = 1
        }

        //shrink the window from beginning if count distinct char in hashmap > k
        //decrease count of that char if its value > 1
        //remove that char if its value <= 1
        while (hashMap.size > 2) {
            val currentStartChar = charArray[windowStart]
            hashMap[currentStartChar]?.let {
                if (it <= 1) {
                    hashMap.remove(currentStartChar)
                } else {
                    hashMap[currentStartChar] = it - 1
                }
            }
            windowStart++
        }
        //longestLen is tracked by comparing current longestLen with
        //the value of elements in current hashmap
        longestLen = max(longestLen, hashMap.map { it.value }.sum())
    }
    return longestLen
}

fun main() {
    println("expected output = 3")
    println(measureTimeMillis("fruitsIntoBasket took ") {
        "Maximum number of fruits: " +
                fruitsIntoBasket(charArrayOf('A', 'B', 'C', 'A', 'C'))
    })
    println("=================================================================")
    println("expected output = 5")
    println(measureTimeMillis("fruitsIntoBasket took ") {
        "Maximum number of fruits: " +
                fruitsIntoBasket(charArrayOf('A', 'B', 'C', 'B', 'B', 'C'))
    })
}