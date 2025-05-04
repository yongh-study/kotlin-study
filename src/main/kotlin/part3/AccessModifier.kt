package part3

/**
 * ✅ 기본적인 접근 제어자
 * public, private : 자바와 동일
 * protected : 하위 클래스에서만 접근 가능
 * internal : 같은 모듈에서만 접근 가능
 *
 * 코틀린은 패키지를 접근 제어가 아닌 네임스페이스 용도로만 사용
 * 코틀린에서는 기본 접근 제어자가 public (default는 없음)
 */

/**
 * ✅ 자바와 코틀린 혼용 시 주의점
 * internal은 바이트코드 상 public이므로 자바 코드에서 접근 가능
 * 자바에서는 같은 패키지의 코틀린 protected 멤버에 접근 가능
 */

/**
 * ✅ 파일의 접근 제어자
 * public, internal : 기본과 동일
 * private : 같은 파일 내에서만 접근 가능
 * protected : 상속 관계가 없으므로 파일 최상단에는 사용 불가능
 */

/**
 * ✅ 생성자의 접근 제어자
 * 생성자에 접근 제어자를 사용하려면 constructor 키워드 명시 필요
 */
class Tem private constructor() {}

/**
 * ✅ 프로퍼티의 접근 제어자
 * 생성자 매개변수에 접근 제어자 설정 가능
 * getter, setter 개별 제어 가능
 */
class Member(
    internal val name: String, // getter, setter 모두 internal
    ageTem: Int
) {
    var age = ageTem
        private set // setter만 private
}

/**
 * ✅ 유틸 함수 정의 방식
 * 자바에서는 유틸 클래스의 객체 생성을 막기 위해 생성자에 private 설정
 * 코틀린에서는 파일 최상단에 유틸 함수를 선언하는 것이 편리 (클래스 없이)
 * => 디컴파일 시 final 클래스 + static 메서드로 변환됨
 */
fun toUppercase(word: String): String {
    return word.uppercase()
}