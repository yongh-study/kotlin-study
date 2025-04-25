package part1

class NullSafetyGuide {

    // ✅ 자바 스타일의 null 체크
    fun javaStyleLengthOrThrow(str: String?): Int {
        if (str == null) {
            throw IllegalArgumentException()
        }
        return str.length
    }

    fun javaStyleLengthOrNull(str: String?): Int? {
        if (str == null) {
            return null
        }
        return str.length
    }

    fun javaStyleLengthOrZero(str: String?): Int {
        if (str == null) {
            return 0
        }
        return str.length
    }

    // ✅ Safe Call, Elvis 연산자
    fun examples() {
        val str: String? = "test"
        val len1 = str?.length // Safe Call -> 값이 null이면 결과도 null
        val len2 = str?.length ?: 0 // Evlis -> 앞의 결과가 null이면 뒤의 값을 사용
    }

    // ✅ 코틀린 스타일로 변환
    fun lengthOrThrow(str: String?): Int {
        return str?.length
            ?: throw IllegalArgumentException()
    }

    fun lengthOrNull(str: String?): Int? {
        return str?.length
    }

    fun lengthOrZero(str: String?): Int {
        return str?.length
            ?: 0
    }

    /**
     * ✅ !! 연산자
     * nullable type이지만 null이 아님을 단정할 때 사용
     * null이면 NPE가 발생하므로 주의
     */
    fun length1(str: String?): Int {
        return str!!.length
    }

    /**
     * ✅ 코틀린에서 자바 코드 호출 시의 null 처리
     * 코틀린은 자바의 null 관련 어노테이션을 인식
     * 만약 @Nullable이 적용된 값을 코틀린에서 바로 받으면 에러 발생
     * => Safe Call을 사용해야 함
     */
    fun callJavaCode() {
        val example = Example("test")
        length2(example.name)
    }

    fun length2(str: String): Int {
        return str.length
    }
}