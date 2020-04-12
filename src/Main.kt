// https://www.hackerrank.com/challenges/two-characters/problem

fun hasDuplicate(s: String, c: Char): Boolean = "$c{2,}".toRegex().containsMatchIn(s)

fun alternate(s: String): Int {
    var maxLength = 0
    val distinctChars = s.toCharArray().distinct()

    for (chr in distinctChars) {
        for (chr2 in distinctChars) {
            if (chr != chr2) {
                var tempStr = s

                for (chr3 in distinctChars) {
                    if (chr3 != chr && chr3 != chr2) {
                        tempStr = tempStr.replace(chr3.toString(), "")
                    }
                }

                var ok = true
                for (c in tempStr.toCharArray().distinct()) {
                    if (hasDuplicate(tempStr, c)) {
                        ok = false
                        break
                    }
                }

                if (ok) {
                    val length = tempStr.length

                    if (length > maxLength)
                        maxLength = length
                }
            }
        }
    }

    return maxLength
}

fun main() {
    println(alternate("beabeefeab"))
    println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"))
}