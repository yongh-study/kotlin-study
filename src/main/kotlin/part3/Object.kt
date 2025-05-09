package part3

class User private constructor(
    var name: String,
    var grade: String
) {

    /**
     * ✅ companion object
     * 자바의 static 대신 사용
     * 이름 설정 가능 (지정하지 않으면 Companion)
     *
     * 자바에서 호출
     * User.Companion.newUser("new") // 이름 설정 시 해당 이름으로 호출
     * User.newUser("new") // @JvmStatic 사용 시
     */
    companion object {
        /**
         * const를 사용하면 컴파일 시에 할당 (val만 사용하면 런타임 시에 할당)
         * const는 기본 타입과 String에만 사용 가능
         */
        private const val DEFAULT_GRADE = "NORMAL"

        @JvmStatic
        fun newUser(name: String): User {
            return User(name, DEFAULT_GRADE)
        }
    }
}

fun main() {
    Singleton.num
}

// ✅ 싱글톤 클래스
object Singleton {
    var num: Int = 0
}

/**
 * ✅ 익명 클래스
 * 자바 : new Example() {}
 * 코틀린 : object : Example {}
 */