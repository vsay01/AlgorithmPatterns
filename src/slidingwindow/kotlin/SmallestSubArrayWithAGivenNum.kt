package slidingwindow.kotlin

import helper.measureTimeMillis
import kotlin.math.min

/*
* Problem: Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous
* subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
*
* Ex1: Input: [2, 1, 5, 2, 3, 2], S=7
* Output: 2
* Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
*
* */

/*
* Time complexity:
* for = O(N)
* while = process each element only once
* so it's O(N + N) = O(N)
*
* Space: O(1)
* */
fun smallestSubArrayWithGivenNumber(arr: IntArray, s: Int): Int {
    var windowSum = 0
    var minLen = Int.MAX_VALUE
    var windowStart = 0
    for (windowEnd in arr.indices) {
        windowSum += arr[windowEnd]

        //make window as small as possible until windowSum < s
        while (windowSum >= s) {
            minLen = min(minLen, (windowEnd - windowStart + 1))
            windowSum -= arr[windowStart]
            windowStart++
        }
    }
    return if (minLen == Int.MIN_VALUE) 0 else minLen
}

fun main() {
    println(measureTimeMillis("smallestSubArrayWithGivenNumber took ") {
        smallestSubArrayWithGivenNumber(intArrayOf(2, 1, 5, 2, 3, 2), 7)
    })

    println(measureTimeMillis("smallestSubArrayWithGivenNumber took ") {
        smallestSubArrayWithGivenNumber(intArrayOf(2, 1, 5, 2, 8), 7)
    })

    println(measureTimeMillis("smallestSubArrayWithGivenNumber took ") {
        smallestSubArrayWithGivenNumber(intArrayOf(3, 4, 1, 1, 6), 8)
    })
}