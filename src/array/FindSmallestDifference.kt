package array

import java.lang.Integer.MAX_VALUE

/*
* sortedNumsOne = -1, 3, 5, 10, 20, 28
* sortedNumsTwo = 15, 17, 26, 134, 135
*
* lp = 0; rp = 0; currentMin = 0
* lp < 6 && rp < 5
*   -1 < 15
*       15 - (-1) = 16
*       currentMin = 16; outputArray = [-1,15]
*       lp++ // 1
* lp < 6 && rp < 5
*   3 < 15
*       15 - 3 = 12
*       currentMin = 12; outputArray = [3,15]
*       lp++ // 2
* lp < 6 && rp < 5
*   5 < 15
*       15 - 5 = 10
*       currentMin = 10; outputArray = [5, 15]
*       lp++ // 3
* lp < 6 && rp < 5
*   10 < 15
*       15 - 10 = 5
*       currentMin 5; outputArray = [10, 15]
*       lp++ // 4
* lp < 6 && rp < 5
*   20 > 15
*       20 - 15 = 5
*       rp++ // 1
* lp < 6 && rp < 5
*   20 > 17
*       20 - 17 = 3
*       currentMin = 3; outputArray = [20, 17]
*       rp++ // 2
* lp < 6 && rp < 5
*   20 < 26
*       26 - 20 = 6
*       lp++ // 5
* lp < 6 && rp < 5
*   28 > 26
*       28 - 26 = 2
*       currentMin = 2; outputArray = [28,26]
*       rp++ // 3
* lp < 6 && rp < 5
*   28 < 134
*       134 - 28 = 106
*       lp++ = 6
* lp < 6 && rp < 5 failed so stop while loop
*
* Time complexity = O(Nlog(N) + Mlog(M))
* Space complexity = O(1)
* */
fun findSmallestDifference(numsOne: Array<Int>, numsTwo: Array<Int>): Array<Int> {
    numsOne.sort() //sort in-place; sortedArray() return sorted array
    numsTwo.sort()

    var lp = 0
    var rp = 0

    val outputArray = Array(2) { 0 }
    var currentMin = MAX_VALUE

    while (lp < numsOne.size && rp < numsTwo.size) {
        if (numsOne[lp] == numsTwo[rp]) return arrayOf(numsOne[lp], numsTwo[lp])
        else if (numsOne[lp] < numsTwo[rp]) {
            val diff = numsTwo[rp] - numsOne[lp]
            if (diff < currentMin) {
                currentMin = diff
                outputArray[0] = numsOne[lp]
                outputArray[1] = numsTwo[rp]
            }
            lp++
        } else { // numsOne[lp] > numsTwo[rp]
            val diff = numsOne[lp] - numsTwo[rp]
            if (diff < currentMin) {
                currentMin = diff
                outputArray[0] = numsOne[lp]
                outputArray[1] = numsTwo[rp]
            }
            rp++
        }
    }
    return outputArray
}

fun main() {
    val numsOne = arrayOf(-1, 5, 10, 20, 28, 3)
    val numsTwo = arrayOf(26, 134, 135, 15, 17)
    print(findSmallestDifference(numsOne, numsTwo).contentToString())
}