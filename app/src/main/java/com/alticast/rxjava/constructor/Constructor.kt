package com.alticast.rxjava.constructor

/**
 * val or var로 선언 하였기 때문에 class 변수로 사용 가능 하면 변수를 초기화 할 수도 있다
 */
class Constructor1 constructor(
    private val name: String,
    private val age: String = "20"
) {
    fun print() {
        println("name $name age $age")
    }
}

/**
 * 위에 내용과 동일 하나 constructor 만 생략함
 */
class Constructor2(
    private val name: String,
    private val age: String = "20"
) {
    fun print() {
        println("name $name age $age")
    }
}

/**
 * constructor를 class 안에서 정의해서 써보자 다만 내생각엔 필요 없다고 봄 default 설정을 할 수 있기때문에 생성자를 여러개 선언 하는 효과가 있기 때문에....
 * secondary constructor var / val 를 선언 할 수 없으므로 primary secondary 에서 선언되었거나, 클래스 변수만 사용 가능함.
 * 무식하게 코딩해보자
 */
class Constructor3() {
    private lateinit var name: String
    private lateinit var age: String
    private lateinit var address: String

    constructor(name: String) : this() {
        this.name = name
    }

    constructor(name: String, age: String) : this() {
        this.name = name
        this.age = age
    }

    /**
     * 요런식으로 정의된 constructor를 상속받아서 name / age를 초기화 하는 코드를 안넣어도 되겠지
     */
    constructor(name: String, age: String, address: String) : this(name, age) {
            this.address = address
    }

    fun print() {
        println("name $name age $age")
    }
}

/**
 * 만약 java 코드랑 같이 쓸려고 하면 코딩 할려고 하면 overloading을 할 수 없기 때문에 constructor 어쩔 수 없이 쓸수 밖에 없음.
 * 그냥 kotlin만 하면 걍 Constructor2 번만 있으면 될거 같음
 * 위에 Constructor3 처럼 코딩 해도 되는데 먼가 좀 촌스럽고 복잡함....
 * ConstructorTestJava 파일에서 아래 처럼 한 이유를 알 수 있음 확인요
 */
class Constructor4(
    private var  name: String ="kjjeon",
    private var age: String = "20",
    private var address: String = "seoul"
) {
    constructor(name: String, age: String) : this(name, age, "seoul")
    constructor(name: String) : this(name, "20", "seoul")
}

/**
 * 어짜피 코틀린 코드가 자바에서 쓸일이 있을까?? 개인적으론 걍 아래 처럼 쓰는걸 추천함
 */
class Constructor5(
    private val name: String,
    private var age: String,
    private var address: String
) {
    init {
        println("Constructor2 name = $name, age = $age , address =$address")
    }
}