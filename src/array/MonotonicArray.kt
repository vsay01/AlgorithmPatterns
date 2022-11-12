package array

/*
* Monotonic function If and only if it is either entirely non-decreasing OR entirely non-increasing
* */

/*
O(n) time
O(1) space
*/
fun isMonotonicArray(nums: Array<Int>): Boolean {
    var isNonDecreasing = true
    var isNonIncreasing = true
    for (i in 1 until nums.size) {
        //if current value is smaller than previous value
        //we are decreasing; no longer non-decreasing
        if (nums[i] < nums[i - 1]) {
            isNonDecreasing = false
        }
        //if current value is bigger than previous value
        //we are increasing; no longer non-increasing
        if (nums[i] > nums[i - 1])
            isNonIncreasing = false
    }
    return isNonDecreasing || isNonIncreasing
}

fun main() {
    val nums = arrayOf(-1, -5, -11, -100, -100, -402, -900)
    println(isMonotonicArray(nums))
}