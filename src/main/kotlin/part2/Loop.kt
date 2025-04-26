package part2

class Loop {

    // ✅ for-each 문
    fun forEachStatement() {
        val nums = listOf(1, 2, 3)
        for (num in nums) {
            println(num)
        }
    }

    // ✅ for 문
    fun forStatement1() {
        for (i in 1..5) {
            println(i)
        }
    }

    fun forStatement2() {
        for (i in 5 downTo 1) {
            println(i)
        }
    }

    fun forStatement3() {
        for (i in 1..5 step 2) {
            println(i)
        }
    }

    // ✅ while 문
    fun whileStatement() {
        var i = 1
        while (i <= 10) {
            println(i)
            i++
        }
    }
}