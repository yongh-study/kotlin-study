package part2

import java.io.BufferedReader
import java.io.FileReader

class Exception {

    /**
     * ✅ Checked, Unchecked Exception
     * 코틀린에서는 둘을 구분하기 않고 모두 Unchecked Exception으로 간주 (throws 필요 x)
     */

    // ✅ try-catch-finally
    fun tryCatchFinallyV1(str: String): Int {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        } finally {
            println("finished")
        }
    }

    // Expression으로 사용
    fun tryCatchFinallyV2(str: String): Int? {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        } finally {
            println("finished")
        }
    }

    /**
     * ✅ try-with-resources
     * 코틀린에는 try-with-resources가 없음
     * 대신 use라는 inline 확장 함수를 사용
     */
    fun tryWithResources(path: String) {
        BufferedReader(FileReader(path)).use { br ->
            println(br.readLine())
        }
    }
}