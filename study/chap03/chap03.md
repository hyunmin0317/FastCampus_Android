# Chap 03 **안드로이드 Essential** - Kotlin

2021.04.02

`Kotlin(코틀린): Jetbrains 사에서 개발했고 2016년에 정식 버젼이 발표되었으며 2017년에 안드로이드 공식지원언어로 채택됨`

<br>

## 1. Kotlin의 장점에 대해 적어보자.

* #### 문법이 간결하며, 표현역이 좋다
* #### Null safe 언어이다
* #### 기존 라이브러리와 상호운용성이 좋다 (자바와 100% 호환이 된다)

<br>

## 2. Kotlin의 기본 문법을 정리해보자.

### 01. 변수

* 종류
  * var(Variable): 내 마음대로 원하는 것을 넣을 수 있는 상자

    `var num = 10`

  * val(Value): 한번 넣으면 바꿀 수 없는 상자 

    `val fix = 20`

* 변수 선언하는 방법
  * var/val 변수명(상자) = 값(넣고 싶은 것)

  * 예시

    ```kotlin
    var num = 10
    var hello = "hello"
    var point = 3.4
    val fix = 20
    ```

<br>

### 02. 자료형

* 종류
  * 정수형 -> Long > Int > Short > Byte
  * 실수형 -> Double > Float
  * 문자 -> Char
  * 문자열 -> String
  * 논리형(참True/거짓False) -> Boolean

* 변수 선언하는 방법

  1. var/val 변수명 = 값

     ```kotlin
     var number = 10
     ```

  2. var/val 변수 : 자료형 = 값

     ```kotlin
     var number1: Int = 20
     var hello1: String = "Hello"
     var point1: Double = 3.4
     ```

* Variable or Value??
  * 변하지 않는 값이라면 -> Value
  * 진짜 모르겠다! -> Variable

<br>

### 03. 함수

`어떤 input 을 넣어주면 어떤 output 나오는 것 (y = x + 2)`

* 함수를 선언하는 방법

  ```kotlin
  fun 함수명 (변수명: 타입, 변수명: 타입 ...) : 반환형 {
  	함수 내용
  	return 반환값
  	}
  ```

* 함수 만들기

  1. 디폴트 값을 갖는 함수 만들기

     ```kotlin
     fun plusFive(first: Int, second: Int = 5): Int {
         val result: Int = first + second
         return result
     }
     ```

  2. 반환값이 없는 함수 만들기

     * 기본 (return 값을 Unit으로 설정)

       ```kotlin
       fun printPlus(first: Int, second: Int): Unit {
           val result: Int = first + second
           println(result)
       }
       ```

     * Unit 생략

       ```kotlin
       fun printPlus2(first: Int, second: Int) {
           val result: Int = first + second
           println(result)
       }
       ```

  3. 간단하게 함수를 선언하는 방법

     ```kotlin
     fun plusShort(first: Int, second: Int) = first + second
     ```

  4. 가변 인자를 갖는 함수 선언하기

     ```kotlin
     fun plusMany(vararg numbers: Int) {
         for (number in numbers) {
             println(number)
         }
     }
     ```

* 함수를 호출하는 방법

  1. 기본

     ```kotlin
     val result = plus(5, 10)
     println(result)	# 15
     ```

  2. 인수를 명시적으로 전달하는 방법

     ```kotlin
     val result2 = plus(first = 20, second = 30)
     println(result2)	# 50
     val result3 = plus(second = 100, first = 10)
     println(result3)	# 110
     ```

  3. 디폴트 값을 갖는 함수 호출하기

     ```kotlin
     val result4 = plusFive(10, 20)
     println(result4)	# 30
     val result5 = plusFive(10)
     println(result5)	# 15
     
     println()
     printPlus(10, 20)	# 30
     ```

<br>

### 04. 연산자

* 산술 연산자
  * +, -, *, /(몫만 취함), %(나머지만 취함)

* 대입 연산자
  * 좌변 = 우변 (우변 값이 좌면에 들어간다)
  * a = 5 (o), 5 = a (x)

* 복합 대입 연산자
  * +=, -=, *=, /=, %=
  * a += 10 -> a = a + 10

* 증감 연산자
  * ++, --
  * a++, a--

* 비교 연산자
  * `>`, >=, <, <=, ==, !=
  * True == True -> True
  * True == False -> False
  * True != Ture -> False
  * True != False -> True

* 논리 연산자
  * &&, ||, !
  * True && True -> True
  * True || False -> True
  * !True -> False
  * !False -> True

<br>

### 05. 제어 흐름 (분기문)

* if문 사용 방법

  1. 방법 (1)

     ```kotlin
     if (a > b) {
         println("a 가 b 보다 크다")
     } else {
         println("a 가 b 보다 작다")
     }
     ```

  2. 방법 (2)

     ```kotlin
     if (a > b) {
         println("a 가 b 보다 크다")
     }
     ```

  3. 방법 (3)

     ```kotlin
     if (a > b) {
             println("a 가 b 보다 크다")
         } else if (a < b) {
             println("a 가 b 보다 작다")
         } else if (a == b) {
             println("a 와 b는 같다")
         } else {
     
         }
     ```

* 값을 리턴하는 if 사용 방법

  1. 방법 (1)

     ```kotlin
     val max = if (a > b) {
             a //5
         } else {
             b //10
         }
     ```

  2. 방법 (2)

     ```kotlin
     val max1 = if (a > b) a else b
     ```

* when 사용 방법

  ```kotlin
  when (value) {
      1 -> println("value is 1")
      2 -> println("value is 2")
      3 -> println("value is 3")
      else -> println("I do not know value")
  }
  ```

* 값을 리턴하는 when 사용 방법

  ```kotlin
  val value2 = when (value) {
      1 -> 10
      2 -> 20
      3 -> 30
      else -> 100
  }
  ```

<br>

### 06. 배열

`그룹(모음집)이 필요할 때 배열을 사용함`

* Index 란?
  * 순서(번째)로 0부터 시작함
  * 예시: [1, 2, 3, 4, 5] - index 0 -> 1, index 1 -> 2

* 배열을 생성하는 방법

  1. 방법 (1)

     ```kotlin
     var number: Int = 10
     var group1 = arrayOf<Int>(1, 2, 3, 4, 5)
     ```

  2. 방법 (2)

     ```kotlin
     var number1 = 10
     var group2 = arrayOf(1, 2, 3.5, "Hello")
     ```

* 배열의 값을 꺼내는 방법

  1. 방법 (1)

     ```kotlin
     val test1 = group1.get(0)
     val test2 = group1.get(4)
     ```

  2. 방법 (2)

     ```kotlin
     val test3 = group1[0]
     ```

<br>

* 배열의 값을 바꾸는 방법

  1. 방법 (1)

     ```kotlin
     group1.set(0, 100)
     ```

  2. 방법 (2)

     ```kotlin
     group1[0] = 200
     ```

<br>

### 07. Collection

* Immutable Collections (변경 불가능)
  * List: 중복을 허용함

    ```kotlin
    val numberList = listOf<Int>(1, 2, 3, 3)
    ```

  * Set: 중복을 허용하지 않고 순서가 없음

    ```kotlin
    val numberSet = setOf<Int>(1, 2, 3, 3, 3)
    ```

  * Map: Key, value 방식으로 관리한다

    ```kotlin
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    ```

* Mutable Collection (변경가능)

  ```kotlin
  val mNumberList = mutableListOf<Int>(1, 2, 3)
  ```

<br>

### 08. 반복문

`val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)`

<br>

* 반복하는 방법 (1)

  1. 방법 (1)

     ```kotlin
     for (item in a) {
         if (item == 5) {
             println("item is Five")
         } else {
             println("item is not Five")
         }
     }
     ```

  2. 방법 (2)

     ```kotlin
     for ((index, item) in a.withIndex()) {
         println("index : " + index + " value : " + item)
         // 문자열 + Int(정수) = 문자열
         // 문자열 + 아무거나  = 문자열
     }
     ```

  3. 방법 (3)

     ```kotlin
     a.forEach {
         println(it)
     }
     ```

  4. 방법 (4)

     ```kotlin
     a.forEach { item ->
         println(item)
     }
     ```

  5. 방법 (5)

     ```kotlin
     a.forEachIndexed { index, item ->
         println("index : " + index + " value : " + item)
     }
     ```

  6. 방법 (6)

     ```kotlin
     for (i in 0 until a.size) {
         // until은 마지막을 포함 하지 않는다
         // 0 부터 8까지 이다
         println(a.get(i))
     }
     ```

     <br>

  7. 방법 (7)

     ```kotlin
     for (i in 0 until a.size step (2)) {
         println(a.get(i))
     }
     ```

  8. 방법 (8)

     ```kotlin
     for (i in a.size - 1 downTo (0)) {
         // 8 부터 0 까지 반복
         println(a.get(i))
     }
     ```

  9. 방법 (9)

     ```kotlin
     for (i in a.size - 1 downTo (0) step (2)) {
         println(a.get(i))
     }
     ```

  10. 방법 (10)

      ```kotlin
      for (i in 0..a.size) {
          // .. -> 마지막을 포함한다
          println(i)
      }
      ```

  11. 방법 (11)

      ```kotlin
      var b: Int = 0 // -> 1 -> 2 -> 3 -> 4
      var c: Int = 4
      
      while (b < c) {
          b++ // while문을 정지 시키시키기 위한 코드
          println("b")
      }
      ```

  12. 방법 (12)

      ```kotlin
      var d: Int = 0
      var e: Int = 4
      
      do {
          println("hello")
          d++
      } while (d < e)
      ```

<br>

### 09. Class

`객체: 이름이 있는 모든 것, OOP -> Object Oriented Programing (객체지향 프로그래밍)`

* 프로그래밍 문제 해결 방법
  * 절차지향 프로그래밍 문제 해결 방법: 코드를 위에서 부터 아래로 실행을 하면 문제가 해결됨

  * 객체지향 프로그래밍 문제 해결 방법: 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결함

    * 축구 게임 -> 선수, 심판, 경기장, 관중

    `객체를 만드는 방법: 설명서가 있어야 함`

* 오버라이딩과 오버로딩
  * 오버라이딩(재정의): 이름과 파라미터가 같은 함수를 함수의 내용을 재정의
  * 오버로딩(중복정의): 이름이 같지만 받는 파라미터가 다른 함수로 같은 이름의 함수를 중복 정의

* 클래스(설명서) 만드는 방법

  1. 방법(1)

     ```kotlin
     class Car constructor(var engine: String, var body: String) {
     
     }
     ```

  2. 방법(2)

     ```kotlin
     class SuperCar {
         var engine: String
         var body: String
         var door: String
     
         constructor(engine: String, body: String, door: String) {
             this.engine = engine
             this.body = body
             this.door = door
         }
     }
     ```

  3. 방법(3)

     ```kotlin
     class Car1 constructor(engine: String, body: String) {
         var door: String = ""
     
         //생성자
         constructor(engine: String, body: String, door: String) : this(engine, body) {
             this.door = door
         }
     }
     ```

  4. 방법(4)

     ```kotlin
     class Car2 {
         var engine: String = ""
         var body: String = ""
         var door: String = ""
     
         constructor(engine: String, body: String) {
             this.engine = engine
             this.body = body
         }
     
         constructor(engine: String, body: String, door: String) {
             this.engine = engine
             this.body = body
             this.door = door
         }
     }
     ```

<br>

* 클래스(설명서)를 통해서 실체를 만드는 방법 - 인스턴스화 -> 인스턴스(객체)

  ```kotlin
  Car("v8 engine", "big")
  val bigCar = Car("v8 engine", "big")
  ```

* 우리가 만든 클래스(설명서)는 자료형이 된다

  ```kotlin
  val bigCar1: Car = Car("v8 engine", "big")
  val superCar: SuperCar = SuperCar("good engine", "big", "white")
  ```

* 인스턴스가 가지고 있는 기능을 사용하는 방법

  ```kotlin
  val runableCar: RunableCar = RunableCar("simple engine", "short body")
  runableCar.ride()
  runableCar.navi("부산")
  runableCar.drive()
  ```

* 인스턴스의 멤버 변수에 접근하는 방법

  ```kotlin
  val runableCar2: RunableCar2 = RunableCar2("nice engine", "long body")
  println(runableCar2.body)
  println(runableCar2.engine)
  ```

<br>

### 10.변수의 접근 범위

* 변수의 종류
  1. 전역 변수: 어떤 변수 영역 내에서도 접근할 수 있는 변수
  2. 지역 변수: 지역 변수 영역이 주어진 변수

* 예시

  ```kotlin
  var number100: Int = 10	// 전역 변수
  
  fun main(args: Array<String>) {
      println(number100)
  
      val test = Test("홍길동")	// 지역 변수
      test.testFun()
      test.name
      println(number100)
  }
  ```

<br>

### 11. 접근 제어자

* 접근 제어자 종류
  * public(기본값): 클래스 외부에서 늘 접근 가능
  * private: 클래스 내부에서만 접근 가능
  * protected: 클래스 자신과 상속받은 클래스에서 접근 가능

* 접근 제어자 예시

  ```kotlin
  class RunningCar() {
      fun runFast() {
          run()
      }
      private fun run() {
  
      }
  }
  
  fun main(array: Array<String>) {
      val runningCar: RunningCar = RunningCar()
      runningCar.runFast()
  //  runningCar.run()	Pirvate  키워드 때문에 외부에서 더 이상 사용할수 없다.
  }
  ```

<br>

### 12. 상속

`부모로부터 설명서를 물려받음`

* 상속의 특징
  * 자식 클래스는 부모 클래스의 타입이지만 부모 클래스는 자식 클래의 타입이 아님
  * 자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행되서 인스턴스화 되어야 함

* 상속 예시

  ```kotlin
  open class Car100() {	// 부모 클래스
      open fun drive(): String {
          return "달린다"
      }
      fun stop() {
  
      }
  }
  
  class SuperCar100() : Car100() {	// 자식 클래스
      override fun drive(): String {
          val run = super.drive()
          return "빨리 $run"
      }
  }
  ```

<br>

### 13.Interface

* 인터페이스
  * 인터페이스는 약속 ! -> 니가 이것을 구현하면 너도 이 타입이다!

  * 지침서 -> 니가 이것을 구현하고 싶다면 받듯이 아래 기능을 구현해라!

  * 생성자가 없고 인스턴스화 시킬수 없으며 설명서가 아님

* 인터페이스의 특징
  * 자식 클래스는 부모 클래스의 타입이지만 부모 클래스는 자식 클래의 타입이 아님

* 상속과 다른점
  * 상속은 조상을 찾아가는 느낌이면 인터페이스는 종의 특징을 나타내는 느낌

* 인터페이스 예시

  ```kotlin
  interface Person_ {
      fun eat()
      fun sleep()
  }
  
  class Student_ : Person_ {
      override fun eat() {
  
      }
  
      override fun sleep() {
  
      }
  }
  ```

<br>

### 14. 제네릭

`Generic: 타입을 체크하는 기능`

* 제네릭을 사용하는 경우 - 타입이 안전함

  ```kotlin
  val list2 = listOf<String>("a", "b", "c")
  val c: String = list2[2] // String 이라는 것을 보장 받는다
  ```

* 제네릭을 사용하지 않은 경우
  * 형 변환을 해줘야 한다

    ```kotlin
    val list1 = listOf(1, 2, 3, "가")
    val b: String = list1[2].toString() // 형변환(타입 변환)
    ```

  * 부모: Any, 자식: String, Int, Float

    ```kotlin
    val list5 = listOf<Any>(1, 2, 3, "가") // -> Any
    ```


* 강한 타입을 체크 할 수 있음

  ```kotlin
  val list3 = listOf(1, 2, 3, 4, "가", "나", 3.0)
  val list4 = listOf<Int>(1, 2, 3, "가")	// 강한 타입 체크
  ```