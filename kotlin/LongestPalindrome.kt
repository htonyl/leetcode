class Solution {
    var s = ""
    var len = 0
    var maxLen = 0
    var maxI = 0
    var maxJ = 0

    fun longestPalindrome(s: String): String {
        this.s = s
        this.len = s.length
        if (len == 0)
            return ""

        val midpoint = len/2
        find(midpoint)
        var i = 1
        while (true) {
            val lower = midpoint - i
            val upper = midpoint + i
            if (lower < 0 && upper >= len) {
                return s.substring(maxI, maxJ + 1)
            }
            find(lower)
            find(upper)
            i++
        }
    }

    private fun find(mid: Int) {
        if (maxLen > 1 && min(mid + 1,  len - mid) * 2 + 1 <= maxLen) {
            return
        }
        if (mid >= 0 && mid + 1 <= len - 1 && s[mid] == s[mid + 1]) {
            expandFrom(mid, mid + 1)
        }
        if (mid >= 1 && mid <= len - 2) {
            expandFrom(mid - 1, mid + 1)
        }
    }

    private fun expandFrom(a: Int, b: Int) {
        var i = a
        var j = b
        while (j < len && i >= 0 && s[i] == s[j]) {
            i--
            j++
        }
        val start = i + 1
        val end = j - 1
        if (end - start + 1 > maxLen) {
            maxLen = end - start + 1
            maxI = start
            maxJ = end
        }
    }
}

