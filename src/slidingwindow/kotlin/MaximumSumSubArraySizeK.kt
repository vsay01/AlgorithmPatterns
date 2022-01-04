package slidingwindow.kotlin

import helper.measureTimeMillis
import kotlin.math.max

/*
* Problem: Given an array of positive numbers and a positive number ‘k’,
* find the maximum sum of any contiguous subarray of size ‘k’.
*
* Input: Array: [2, 1, 5, 1, 3, 2], k=3
* Output: 9
* */
/*
* Brute force
* Time complexity: O(N * K); N: number of elements in the input array
* */
fun maximumSumSubArrayBruteForce(arr: IntArray, k: Int): Int {
    var maxSum = 0
    for (i in 0 until (arr.size - k)) {
        var winSum = 0
        for (j in i until (i + k)) {
            winSum += arr[j]
        }
        maxSum = max(maxSum, winSum)
    }
    return maxSum
}

/*
* Slide Window
* Time complexity: O(N); N: number of elements in the input array
* */
fun maximumSumSubArraySlideWindow(arr: IntArray, k: Int): Int {
    var maxSum = 0
    var windowSum = 0
    var windowStart = 0
    for (windowEnd in arr.indices) {
        windowSum += arr[windowEnd]

        if (windowEnd >= k - 1) {
            maxSum = max(maxSum, windowSum)
            windowSum -= arr[windowStart]
            windowStart++
        }
    }
    return maxSum
}

fun main() {
    println(measureTimeMillis("maximumSumSubArrayBruteForce took ") {
        maximumSumSubArrayBruteForce(intArrayOf(2, 1, 5, 1, 3, 2), 3)
    })
    println(measureTimeMillis("maximumSumSubArrayBruteForce took ") {
        maximumSumSubArrayBruteForce(intArrayOf(2, 3, 4, 1, 5), 2)
    })

    println(measureTimeMillis("maximumSumSubArraySlideWindow took ") {
        maximumSumSubArraySlideWindow(intArrayOf(2, 1, 5, 1, 3, 2), 3)
    })
    println(measureTimeMillis("maximumSumSubArraySlideWindow took ") {
        maximumSumSubArraySlideWindow(intArrayOf(2, 3, 4, 1, 5), 2)
    })
}