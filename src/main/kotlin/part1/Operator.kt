package part1

class Operator {

    /**
     * ✅ 단항, 산술 연산자
     * 자바와 완전히 동일
     */

    /**
     * ✅ 비교 연산자
     * 자바와 사용법은 동일
     * 단. 코틀린에서는 자바와 다르게 비교 연산자를 사용하면 내부적으로 compareTo()가 자동 호출
     */

    /**
     * ✅ 동일성, 동등성
     * 자바에서는 동일성에 ==, 동등성에 equals()를 사용
     * 코틀린에서는 동일성에 ===, 동등성에 ==를 사용 (==는 내부적으로 equals()를 호출)
     */

    /**
     * ✅ 논리 연산자
     * 자바와 완전히 동일
     * 자바와 마찬가지로 Lazy 연산 수행
     */

    /**
     * 자바와 다른 코틀린의 연산자
     *
     * ✅ in / !in
     * 컬렉션이나 범위에 포함되는지 여부 판단
     *
     * ✅ a..b
     * a부터 b까지 포함하는 범위 객체 생성
     *
     * ✅ a[i] / a[i] = b
     * 인덱스를 통한 접근 및 값 할당
     */

    /**
     * ✅ 연산자 오버로딩
     * 자바에서는 연산 메서드를 직접 구현하고 호출해야 함
     * 하지만 코틀린에서는 operator 키워드를 사용하여 연산자 동작을 직접 정의할 수 있음
     */
    fun example() {
        val num1 = Num(1)
        val num2 = Num(2)
        val sum = num1 + num2 // 3
    }

    class Num(val num: Int) {
        operator fun plus(other: Num): Num {
            return Num(num + other.num)
        }
    }
}