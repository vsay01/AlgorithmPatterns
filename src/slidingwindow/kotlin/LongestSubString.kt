package slidingwindow.kotlin

import helper.measureTimeMillis
import kotlin.math.max

/*
Given a string, find the length of the longest substring in it
with no more than K distinct characters.

Example:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
*/

/*
* Slide Window
* Time complexity: O(N); N: number of elements in the input array
* Space complexity: O(K)
* */
fun longestSubStringWithNoMoreThanK(str: String, k: Int): Int {
    var longestLen = Int.MIN_VALUE
    var windowStart = 0
    val hashMap: HashMap<Char, Int> = HashMap()

    for (windowEnd in str.indices) {
        val currentEndChar = str[windowEnd]
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
        val currentStartChar = str[windowStart]
        if (hashMap.size > k) {
            hashMap[currentStartChar]?.let {
                if (it <= 1) {
                    hashMap.remove(currentStartChar)
                } else {
                    hashMap[currentStartChar] = it - 1
                }
            }
            windowStart++
        } else {
            //longestLen is tracked by comparing current longestLen with
            //the value of elements in current hashmap
            longestLen = max(longestLen, hashMap.map { it.value }.sum())
        }
    }
    return longestLen
}

//kotlin references
//https://www.geeksforgeeks.org/kotlin-hashmap/
//https://www.bezkoder.com/kotlin-sum-sumby-sumbydouble-bigdecimal-list-map-example/
fun main() {
    //expected output = 4
    println(measureTimeMillis("longestSubStringWithNoMoreThanK took ") {
        longestSubStringWithNoMoreThanK("araaci", 2)
    })
    //expected output = 2
    println(measureTimeMillis("longestSubStringWithNoMoreThanK took ") {
        longestSubStringWithNoMoreThanK("araaci", 1)
    })
    //expected output = 5
    println(measureTimeMillis("longestSubStringWithNoMoreThanK took ") {
        longestSubStringWithNoMoreThanK("cbbebi", 3)
    })
}