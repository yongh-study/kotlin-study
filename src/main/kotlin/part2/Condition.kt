package part2

class Condition {

    /**
     * ✅ if 문
     * 자바와 동일
     */
    fun ifStatement(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException()
        }
    }

    /**
     * ✅ if-else 문
     * 자바에서 if-else는 Statement
     * 코틀린에서 if-else는 Expression
     *
     * 참고)
     * 자바에서는 삼항 연산자가 Expression 역할 (코틀린에는 삼항 연산자 없음)
     * 자바 17부터는 switch 문을 표현식으로 사용 가능
     */
    fun ifElseExpression(score: Int): Int {
        return if (score < 0) {
            throw IllegalArgumentException()
        } else {
            score
        }
    }

    /**
     * ✅ 범위 조건 표현
     * 자바 예시) score >= 0 && score <= 100
     * 코틀린 예시) score in 0..100
     */
    fun rangeCondition(score: Int) {
        if (score in 0..100) {
            println(score)
        }
        throw IllegalArgumentException()
    }

    /**
     * ✅ when 문 (자바의 switch 문 대체)
     * when (값) {
     *   조건부 -> 구문
     *   ...
     *   else -> 구문
     * }
     */
    fun whenExpression(score: Int): String {
        return when (score) {
            in 0..50 -> "bad"
            in 51..70 -> "hmm"
            else -> "good"
        }
    }

    fun whenStatement1(score: Int) {
        when (score) {
            3, 5, 7, 9 -> println("${score}는 내가 좋아하는 숫자")
            else -> println("hmm")
        }
    }

    fun whenStatement2(score: Int) {
        when {
            score < 0 -> throw IllegalArgumentException()
            score % 2 == 0 -> println("짝수")
            else -> println("홀수")
        }
    }
}