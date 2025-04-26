package part3

fun main() {
    val user = UserV2("yong", 50)

    // 코틀린에서 자바 클래스의 getter, setter를 사용할 때도 같은 방식 (getName() x)
    println(user.name)
    user.age = 60

    val user2 = UserV3("yong", 50)
    user2.isAdultMethod()
    user2.isAdultProperty
}

/**
 * 코틀린에서는 필드를 선언하면 getter와 setter를 자동으로 만들어 줌
 * 때문에 이를 '프로퍼티'라고 부름
 */
class UserV1 constructor(name: String, age: Int) {

    val name = name
    var age = age
}

class UserV2(
    val name: String,
    var age: Int
)

/**
 * 생성자 검증
 * init 블록은 생성자 호출 시점에 실행
 * 주 생성자는 반드시 존재해야 함 (파라미터가 하나도 없다면 생략 가능)
 */
class UserV3(
    val name: String,
    var age: Int
) {

    init {
        if (age <= 0) {
            throw IllegalArgumentException()
        }
    }

    /**
     * 부 생성자 추가
     * 코틀린에서는 부 생성자보다 default parameter 사용을 권장
     * 타입 변환이 필요한 경우에도 부 생성자보다 정적 팩토리 메서드 사용을 권장
     */
    constructor(name: String) : this(name, 1) {
        println("Secondary constructor") // body 작성 가능
    }

    fun isAdultMethod(): Boolean {
        return this.age >= 20
    }

    // 함수 대신 프로퍼티로도 표현 가능
    val isAdultProperty: Boolean
        /*get() {
            return this.age >= 20
        }*/
        get() = this.age >= 20
}

class UserV4(
    name: String,
    var age: Int
) {

    /**
     * getter, setter 커스텀
     * 무한 루프 방지를 위해 field 키워드(backing field) 사용 (name으로 작성하면 getter가 재호출되어 무한 반복 발생)
     * 자바에서 setter의 사용을 지양하듯 코틀린에서도 커스텀 setter는 잘 사용하지 않음
     */
    var name = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    // 보통 이런 식의 읽기 전용 프로퍼티로 많이 사용
    val uppercaseName: String
        get() = this.name.uppercase()
}