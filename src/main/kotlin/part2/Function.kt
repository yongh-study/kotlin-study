package part2

class Function {

    /**
     * 접근 제어자는 public이 기본값
     * 반환 타입은 Unit이 기본값
     */
    fun maxReturnV1(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    /**
     * 함수가 하나의 결괏값이면 '{}' 대신 '=' 사용 가능
     * '='을 사용하면 반환 타입 생략 가능
     */
    fun maxReturnV2(a: Int, b: Int) =
        if (a > b) {
            a
        } else {
            b
        }

    fun maxReturnV3(a: Int, b: Int) = if (a > b) a else b

    /**
     * ✅ 오버로딩
     * 자바에서는 오버로딩을 통해 필요한 파라미터 설정 (메서드 개수가 많아짐)
     * 코틀린에도 오버로딩이 존재하지만 default parameter를 사용하여 더 간단하게 표현 가능
     *
     * ✅ named argument
     * builder 사용 효과
     * 자바의 메서드를 가져다 사용할 때는 사용 불가능
     *
     * ✅ 가변 인자 함수
     */
    fun examples() {
        repeat("hi", 5, true)
        repeat("hi")
        repeat("hi", bool = true) // named argument


        printAll("hi", "hello")

        val arr = arrayOf("hi", "hello")
        printAll(*arr) // spread 연산자 사용
    }

    fun repeat(
        str: String,
        num: Int = 3,
        bool: Boolean = false,
    ) {
        for (i in 1..num) {
            if (bool) {
                println(str + "true")
            } else {
                println(str)
            }
        }
    }

    // vararg 키워드 사용
    fun printAll(vararg strs: String) {
        for (str in strs) {
            println(str)
        }
    }
}