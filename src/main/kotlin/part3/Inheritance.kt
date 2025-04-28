package part3

// 자바와 마찬가지로 추상 클래스는 인스턴스화 불가능
abstract class Animal(
    protected open val species: String, // 프로퍼티 override를 위해서는 open 키워드를 사용
    protected val age: Int
) {

    abstract fun move()
}

class Cat(
    species: String,
    age: Int,
) : Animal(species, age) { // 상위 클래스 생성자 호출

    // override 키워드 사용
    override fun move() {
        println("고양이가 걸어갑니다.")
    }
}

class Dog(
    species: String,
    age: Int,
) : Animal(species, age) {

    private val sound = "멍멍"

    override fun move() {
        println("강아지가 걸어갑니다.")
    }

    // getter override
    override val species: String
        get() = "${super.species}는 ${sound} 소리를 냅니다." // 무한 루프 방지를 위해 super 키워드 사용
}

interface Swimmable {

    // backing field가 없는 프로퍼티를 인터페이스에 생성 가능
    val ability: Int

    // default 메서드
    fun act() {
        println("첨벙")
    }

    // 추상 메서드
    // fun swim()
}

interface Flyable {

    fun act() {
        println("파닥")
    }
}

class Penguin(
    species: String,
    age: Int,
) : Animal(species, age), Swimmable, Flyable {

    override fun move() {
        println("펭귄이 걸어갑니다.")
    }

    // 인터페이스의 프로퍼티 구현
    override val ability: Int
        get() = 3

    /**
     * In 자바
     * Swimmable.super.act();
     * Flyable.super.act();
     */
    override fun act() {
        super<Swimmable>.act()
        super<Flyable>.act()
    }
}

// 기본 클래스끼리의 상속에는 open 키워드를 사용해야 함
open class Base(
    open val number: Int = 100
) {
    init {
        println("first")

        /**
         * Derived 초기화
         * 1. Base의 init이 먼저 호출
         * 2. 해당 number는 하위 클래스의 값을 가져오는데, 아직 초기화되지 않은 상태이므로 값은 0이 됨
         *    (정확히는 하위 클래스에서 override하는 프로퍼티)
         *
         * 따라서 상위 클래스를 설계할 때 생성자나 init 블록에 사용되는 프로퍼티는 open을 피해야 함
         */
        println(number)
    }
}

class Derived(
    override val number: Int,
) : Base(number) {
    init {
        println("second")
    }
}