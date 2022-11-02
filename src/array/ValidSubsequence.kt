package array

fun validSubsequenceWhileLoop(nums: Array<Int>, subSequence: Array<Int>): Boolean {
    var pointerNums = 0
    var pointerSubSequence = 0

    while (pointerNums < nums.size && pointerSubSequence < subSequence.size) { //not nums.size - 1
        if (nums[pointerNums] == subSequence[pointerSubSequence]) {
            pointerSubSequence++
        }
        pointerNums++
    }
    return pointerSubSequence == subSequence.size
}

fun validSubsequenceForLoop(nums: Array<Int>, subSequence: Array<Int>): Boolean {
    var pointerSubSequence = 0
    for (i in nums.indices) {
        if (pointerSubSequence == subSequence.size) {
            break
        }
        if (subSequence[pointerSubSequence] == nums[i]) {
            pointerSubSequence++
        }
    }
    return pointerSubSequence == subSequence.size
}

fun main() {
    val nums = arrayOf(5, 1, 13, 15, 6, -2, 7, 10)
    val subSequence = arrayOf(5, 13, 15, 6, 7)
    println(validSubsequenceWhileLoop(nums, subSequence))
    println(validSubsequenceForLoop(nums, subSequence))
    //print(twoSumNumberHashTable(nums, target).contentToString())
}