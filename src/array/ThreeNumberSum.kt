package array

fun threeSumNumberSortTwoPointers(nums: Array<Int>, target: Int): ArrayList<Array<Int>> {
    nums.sort()
    val result = arrayListOf<Array<Int>>()
    for (i in 0 until nums.size - 2) {
        var lp = i + 1
        var rp = nums.size - 1
        while (lp < rp) {
            val currentSum = nums[i] + nums[lp] + nums[rp]
            if (currentSum == target) {
                result.add(arrayOf(nums[i], nums[lp], nums[rp]))
                lp++
                rp--
            } else if (currentSum < target) {
                lp++
            } else { //(currentSum > target)
                rp--
            }
        }
    }
    return result
}

fun main() {
    val nums = arrayOf(12, 3, 1, 2, -6, 5, -8, 6)
    val target = 0
    val nums2 = arrayOf(15, -6, 2, 1, 6, 7, 3, -8)
    val target2 = 1
    var res = threeSumNumberSortTwoPointers(nums2, target2)
    for (i in 0 until res.size) {
        for (j in 0 until res[i].size) {
            println(res[i][j])
        }
        println("------")
    }
    //print(twoSumNumberBruteForce(nums, target).contentToString())
    //print(twoSumNumberHashTable(nums, target).contentToString())
}