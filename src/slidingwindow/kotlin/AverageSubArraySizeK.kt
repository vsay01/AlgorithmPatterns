package slidingwindow.kotlin

import helper.measureTimeMillis

/*
* Problem: Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
*
* Input: Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
* Output: [2.2, 2.8, 2.4, 3.6, 2.8]
* */
/*
* Brute force
* Time complexity: O(N * K); N: number of elements in the input array
* */
fun averageSubArrayBruteForce(arr: IntArray, k: Int): DoubleArray {
    val result = DoubleArray(arr.size - k + 1)
    for (i in 0..(arr.size - k)) {
        var sum = 0.0
        for (j in i until i + k) {
            sum += arr[j]
        }
        result[i] = sum / k
    }
    return result
}

/*
* Slide window
* Time complexity: O(N); N: number of elements in the input array
* */
fun averageSubArraySlideWindow(arr: IntArray, k: Int): DoubleArray {
    val result = DoubleArray(arr.size - k + 1)
    var windowSum = 0.0
    var windowStart = 0

    for (windowEnd in arr.indices) {
        windowSum += arr[windowEnd]
        if (windowEnd >= k - 1) {
            result[windowStart] = windowSum / k
            windowSum -= arr[windowStart]
            windowStart++
        }
    }
    return result
}

/*
* Basic Type: https://kotlinlang.org/docs/basic-types.html#primitive-type-arrays
* Control flow: https://kotlinlang.org/docs/control-flow.html#for-loops
* Rang = https://kotlinlang.org/docs/ranges.html#range
* */
fun main() {
    println(measureTimeMillis("averageSubArrayBruteForce took ") {
        averageSubArrayBruteForce(intArrayOf(1, 3, 2, 6, -1, 4, 1, 8, 2), 5)
    }.contentToString())

    println(measureTimeMillis("averageSubArraySlideWindow took ") {
        averageSubArraySlideWindow(intArrayOf(1, 3, 2, 6, -1, 4, 1, 8, 2), 5)
    }.contentToString())
}