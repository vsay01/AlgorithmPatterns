package array

fun twoSumNumberBruteForce(nums: Array<Int>, target: Int): Array<Int> {
    for (i in nums.indices) {
        val firstNumber = nums[i]
        for (j in i until nums.size - 1) {
            val secondNumber = nums[j]
            if (firstNumber + secondNumber == target) {
                return arrayOf(firstNumber, secondNumber)
            }
        }
    }
    return arrayOf()
}

/*
*
* n: target number
* x: current number
* y: number needed to sum up to the target value
* Formula: x + y = n => y = n - x
*
* */
fun twoSumNumberHashTable(nums: Array<Int>, target: Int): Array<Int> {
    val hashMap = HashMap<Int, Int>()
    for (i in nums.indices) {
        val lookingTargetY = target - nums[i]
        if (hashMap.containsValue(lookingTargetY)) {
            return arrayOf(lookingTargetY, nums[i])
        } else {
            hashMap[i] = nums[i]
        }
    }
    return arrayOf()
}

fun twoSumNumberSortTwoPointers(nums: Array<Int>, target: Int): Array<Int> {
    nums.sort()
    var lp = 0    //lp = left pointer
    var rp = nums.size - 1    //rp = right pointer

    while (lp < rp) {
        val currentSum = nums[lp] + nums[rp]
        if (currentSum == target) {
            return arrayOf(nums[lp], nums[rp])
        } else if (currentSum < target) {
            lp++
        } else if (currentSum > target) {
            rp--
        }
    }

    return arrayOf()
}

fun main() {
    val nums = arrayOf(1, 7, 3, 2, -15, 11)
    val target = 9
    print(twoSumNumberSortTwoPointers(nums, target).contentToString())
    //print(twoSumNumberBruteForce(nums, target).contentToString())
    //print(twoSumNumberHashTable(nums, target).contentToString())
}