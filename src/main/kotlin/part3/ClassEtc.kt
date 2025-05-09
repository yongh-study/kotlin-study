package part3

/**
 * ✅ Data Class (DTO)
 * 필드
 * 생성자
 * getter
 * equals, hashCode
 * toString
 *
 * data 키워드를 사용하면 자동으로 equals, hashCode, toString을 만들어 줌
 * 자바에서는 record를 사용하여 DTO 클래스 구현 가능
 */
data class UserDto(
    val name: String,
    val age: Int,
)

/**
 * ✅ Enum Class
 */
enum class Food(
    private val m: String
) {
    KIMCHI("김치"),
    PIZZA("피자");
}

/**
 * when 절로 편리하게 분기처리 가능
 * 컴파일러가 Enum의 모든 타입을 알고 있어 else가 필요 없음
 * Enum에 변화가 있으면 IDE단에서 알려줌
 */
fun handleEnum(food: Food) {
    when (food) {
        Food.KIMCHI -> TODO()
        Food.PIZZA -> TODO()
    }
}

/**
 * ✅ Sealed Class, Interface
 * 컴파일 타임에 하위 클래스의 타입을 모두 기억하므로 런타임에 클래스 타입이 추가될 수 없음 (하위 클래스는 같은 패키지에 있어야 함)
 * 따라서 Enum과 마찬가지로 When 절 사용 시 else가 필요 없음
 */