class Variable {

    fun examples() {
        /*
         * ✅ var vs val
         * var : 가변 키워드
         * val : 불변 키워드
         * 컬렉션을 val로 선언해도 요소 추가는 가능
         * 자바에서도 final로 선언된 컬렉션에 요소 추가 가능 (단, Arrays.asList(), List.of() 등으로 생성한 컬렉션에는 불가능)
         */
        var mutable = "hi"
        mutable = "hello"

        /*
         * ✅ 타입 추론
         * 컴파일러가 자동으로 타입을 추론해 주므로 생략 가능
         * 기본적으로는 val을 사용하고 필요한 경우에만 var로 선언하는 것을 권장
         *
         * 참고)
         * 코드상으로는 참조 타입처럼 보이지만 필요에 따라서는 내부에서 원시 타입으로 처리
         * 자바와 달리 박싱/언박싱에 따른 성능 이슈를 자동으로 최적화해 줌
         */
        val num1 = 1L // Long으로 추론
        val num2: Long = 1L // 명시도 가능

        // ✅ 타입 추론이 불가능한 경우에는 타입 명시 필수
        val num3: Int
        num3 = 5;

        // ✅ 변수에 null을 허용하려면 ?를 사용
        var nullableString: String? = null
        nullableString = "not null"

        // ✅ 객체 생성 시 new 키워드 없음
        val ex = Example("test")
    }

    class Example (var name: String)
}