package part1

class Type {

    /**
     * 자바와 다른 코틀린의 타입
     *
     * ✅ Any
     * 자바의 Object 역할 (모든 객체의 최상위 타입)
     * nullable은 Any?로 표현
     * equals(), hashCode(), toString() 메서드 존재
     *
     * ✅ Unit
     * 자바의 void와 동일한 역할
     * void와 다르게 Unit은 자체로 객체이며 타입 인자로도 사용 가능
     *
     * ✅ Nothing
     * 함수가 정상적으로 끝나지 않았다는 사실을 표현
     * ex) 무조건 예외를 던지는 함수, 무한 루프 함수 등
     */

    /**
     * 자바에서 기본 타입간의 변환은 암시적으로 이루어질 수 있음
     * ex) int num1 = 1; long num2 = num1;
     * 코틀린에서는 명시적으로 변환 메서드를 사용하지 않으면 컴파일 에러 발생
     */
    fun convert() {
        val num1 = 1
        val num2: Long = num1.toLong()

        val num3: Int? = 3
        val num4: Long = num3?.toLong() ?: 4 // nullable 처리 시 Elvis 연산자 사용
    }

    /**
     * 자바에서는 instanceof로 타입 확인 후 캐스팅
     * ex) if (obj instanceof Example) Example ex = (Example) obj;
     * 코틀린에서는 is 키워드로 타입 확인 후, as 또는 스마트 캐스트로 캐스팅
     */
    fun cast1(obj: Any) {
        if (obj is Example) { // 반대는 !is
            val ex = obj as Example
            println(ex.name)
        }
    }

    fun cast2(obj: Any) {
        if (obj is Example) {
            println(obj.name) // 스마트 캐스트
        }
    }

    fun cast3(obj: Any?) {
        if (obj is Example) {
            val ex = obj as? Example // nullable 처리
            println(ex?.name)
        }
    }

    /*
     * ✅ 문자열 템플릿
     * 자바에서는 String.format()이나 StringBuilder를 주로 사용
     * 코틀린에서는 ${변수} 혹은 $변수 로 간단하게 문자열 삽입 가능
     *
     * ✅ 문자열 인덱싱
     * 자바에서는 str.charAt(0)
     * 코틀린에서는 str[0]
     */
    fun stringTemplatesAndIndexing() {
        val ex = Example("test")
        val content1 = "이름은 ${ex.name}입니다."

        val name = ex.name
        val content2 = "이름은 $name 입니다."

        // 텍스트 블록
        val content3 =
            """
            이름은
            $name
            입니다.
            """.trimIndent()

        val str = "STRING"
        val ch = str[0]
    }

    class Example(var name: String)
}