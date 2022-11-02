package array

fun sortedSquaredArraySolution1(nums: Array<Int>): IntArray {
    val outputArray = IntArray(nums.size) { 0 }
    for (i in nums.indices) {
        outputArray[i] = nums[i] * nums[i]
    }
    return outputArray.sortedArray()
}

fun sortedSquaredArraySolution2(nums: Array<Int>): IntArray {
    val outputArray = IntArray(nums.size) { 0 }
    var lp = 0
    var rp = nums.size - 1
    var indexOutputArray = outputArray.size - 1
    while (indexOutputArray >= 0) {
        if (Math.abs(nums[lp]) >= Math.abs(nums[rp])) {
            outputArray[indexOutputArray] = nums[lp] * nums[lp]
            indexOutputArray--
            lp++
        } else {
            outputArray[indexOutputArray] = nums[rp] * nums[rp]
            indexOutputArray--
            rp--
        }
    }
    return outputArray
}

fun main() {
    val nums = arrayOf(-7, -5, -4, 3, 6, 8, 9)
    println(sortedSquaredArraySolution1(nums).contentToString())
    println(sortedSquaredArraySolution2(nums).contentToString())
}