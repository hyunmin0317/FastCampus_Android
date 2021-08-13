# chapter 05 안드로이드 Essential - Android

2021.05.10

<br>

## 01. Activity

- 앱의 한 화면이다
- Life Cycle(수명 주기)
- onCreate
    - activity가 만들어질 때 단 한번만 호출 된다
    - activity를 만들때 단 한번만 하면 되는 작업들 여기에서 해준다
- onStart
- onResume
    - 다시 앱으로 돌아올때 무조건 호출 된다
    - activity가 다시 호출될 때 하면 되는 작업들을 여기에서 해준다

- onPause -> 화면의 일부가 가려 졌을 때
- onStop -> 화면 전부가 보이지 않을 때
- onDestroy
- [더 자세한 Life Cycle](https://developer.android.com/guide/components/activities/activity-lifecycle)

<br>

## 02. Listener

* 익명함수/클래스
  * 이름이 없는 함수/클래스
  * 이름을 만들어줄 필요가 없다
  * 한번만 사용한다

<br>

## 03. Intent

- 의도, 요구, 의사 전달, 요청
- Intent 사용
    - Acitivty 와 Activity
    - Android System 과 내 App (전화)
    - 다른 App 과 내 App -> 무작정 사용할수 없다, 상호합의가 있어야 한다


- 요청의 종류
    - 전달만 하는 요청
    - 리턴을 받는 요청

- 인텐트의 종류
    - 명시적 인텐트 -> 정확히 대상에게 요청
    - 암시적 인텐트 -> 할수 있는 대상에 요청

<br>

## 04. Context

- 문맥
- 엑티비티가 가지고 있는 주변 정보

<br>

## 05. Task

`Task -> Activity`

- Stack
  
    - 햄버거처럼 아래에서 위로 쌓이는 것
    - Task가 쌓인다
    
- 예시

            	                                                      A
    A  ---->  B  -----> C  ----->  B  ----> A  ---> B
                  A           B            A           B
                                A                         A

* 켜지는 방법을 자체 속성으로 가지고 있는 경우 -> launchMode

* 켜지는 방법을 지시하는 경우 -> IntentFalg

* LaunchMode에 따른 특성

  |   LaunchMode   |                           다중허용                           |
  | :------------: | :----------------------------------------------------------: |
  |    Standard    |                              O                               |
  |   singleTop    | 조건부 (열려고 하는 엑티비티가 현재 엑티비티 라면 onNewIntent를 호출한다) |
  |   singleTask   |                              X                               |
  | singleInstance |                              X                               |

* 인텐트 플레그
  * FLAG_ACTIVITY_NEW_TASK
  * FLAG_ACTIVTY_SINGLE_TOP
  * FLAG_ACTIVTY_CLEAR_TOP
  * 등등

* [Android Guide](https://developer.android.com/guide/components/activities/tasks-and-back-stack?hl=ko)

<br>

## 06. Fragment

- Activity -> 앱에 보이는 한 화면의 단위

- 엑비티가 가지고 있는 문제
    - ex)
    - 엑티비티가 길어지게 되면 (파트1,2,3,4,5,6) -> 관리 포인트가 많아진다 -> 관리가 어려워진다

- 다양한 디바이스에서 오는 문제
    - ex)
    - 안드로이드 디바이스가 너무 다양하다
    - 안드로이드에는 핸드폰만 있는게 아니다! -> 테블릿이 있다!

* 사용처
  * 엑티비티의 파트를 나누어서 책임진다

* Fragment
  * 라이프 사이클이 존재한다
  * 엑티비티 종속적이다

* 사용방법
  * XML에 ViewComponent로 추가한다
  * 코드로(동적)으로 추가한다

* 데이터 전달 방법
  * Activity -> Fragment : argument 와 bundle
  * Fragment -> Activity : 자체 구현(리스너 구현)

<br>

## 07. NullSafety

* Null Safety
  -> Null에 대해서 안전하다
  -> 코틀린의 특징

* Null vs 0
  -> 0 :휴지를 다 쓰고 휴지심만 남은 상태
  -> Null : 휴지심도 없는 상태, 존재 하지 않는 상태, 모르는 상태

* Null이 안전하지 않은 이유
  -> 0 + 10 = 10
  -> Null + 10 = ? -> 에러
  -> button.setOnClickListener
  -> null.setOnClickListener -> 에러
  -> NullPointExceptionError 발생한다

  ```kotlin
  if(number != null){
      number +10
  }
  
  if(button != null){
      button.setOnClickListener
  }
  ```

* 코틀린이 Null Safety하기 위해서 사용하는 문버
  -> ? : Null이 아니라면 이하 구문 실행
  -> !! : Null이 아님을 개발자 보장한다

* 사용방법

  ```kotlin
  button?.setOnClickLinstener
  button!!.setOnClickLinstener
  ```

* Null이 될수 있는 타입
  * Int, Double, Float, Class  -> Null이 될 수 없는 타입
  * Int?, Double?, Float?, Class? -> Null이 될 수 있는 타입

<br>

## 08. Lateinit

- init -> 초기값 셋팅
- late -> 늦게 나중에

-> 초기값을 나중에 셋팅 해주겠다
-> 초기값이 셋팅 되지 않았을 때 호출을 하면 에러가 발생한다

<br>

## 09. Context 

* 역할 -> ActivityManagerService(개발하기 편하도록 미리 구현 해놓은 기능)에 접근 하도록 해주는 역할
  -> 주변정보

* 안드로이드는 이미 많은 부분들이 만들어져 있다 -> 이런것들 사용하기 위해서는 Context가 필요한 경우가 많다

* 종류
  * acitivty의 context(주변정보) -> Activity의 주변 정보
  * application의 context(주변정도) -> Application의 주변 정보
  * ApplicationContext > ActivityContext

<br>

## 10. Thread

- 작업 흐름

  앱실행 -----> launcher Activity -----> ----> ------> 작업흐름

* 안드로이드의 쓰레드
  -> MainThread
  -------------------------------------------------------------->
      -> launcher Activity
                           -> Activity B
                                          -> 영상 재생
                                                      -> 기타등등

* 할일 : 더하기, 빼기, 곱하기, 나누기
  MainThread만 있는 경우
  -------------------------------------------------------------->
  ---------> 더하기  ---------> 빼기 ---------> 곱하기 ---------> 나누기

* 다른 쓰레드가 있는 경우  -> 여러가지 일을 한번에 할 수 있다
  -------------------------------------------------------------->
                빼기
                ------------------>
                          곱하기
                          ------------------->
       더하기
       ------------------------------------------------------>
                                                    나누기
                                                    -------------->

* 안드로이드 MainThread의 특징
  * UI(User Interface) Thread
      - 사용자의 input을 받는 쓰레드
  * 절대 정지시킬수 없다!!(하면 안된다!)
      - 왜냐하면, 정지 시키거나 종료 시키면 더 이상 사용자의 input을 받을수 없기 때문!

<br>

## 11. Library

* Framework
  * 안드로이드 스튜디오
  * 개발을 하기위해 지켜하는 틀

* Library (외부의 도움)
  * 개발을 하기 위해 필요한 도구들이 미리 구현되어 있는 것
  * 함수나, 클래스로 구현이 되어 있습니다
  * 프레임워크에 없다!

  * 특징
      - 프레임워크에서 하기 힘든 것들을 쉽게 사용할수 있도록 만들어 놨다!
      - 프레임워크에서 제공하지 않는 기능을 사용할 수 있도록 만들어 놨다!

<br>

## 12. Addview

* 리스트뷰
  * 유사하게 반복되는 뷰를 그리기 위한 도구

* 리스트뷰를 그리는 방법
  * addView
    -> 실제로 리스트뷰를 그리기위해서 잘 사용되지 않는다
    -> Item을 담을 xml을 만들어 준다
    -> 그 xml에 내용을 채워준다
    -> Container view에 더해준다
    -> 반복한다

* Listview  -> 예전에 많이 사용되었다
* RecycleView -> 최근에 가장 많이 사용이 되고 있고 가장 효율이 높다

<br>

## 13. ListView

1. 리스트로 만들고 싶은 아이템의 리스트를 준비한다
2. 인플레이터를 준비한다
3. 인플레이터로 아이템 하나에 해당하는 뷰를 만들어 준다
4. 위에서 만든 뷰를 컨터이너 뷰에 붙여준다

* ListView
  1. 리스트로 만들고 싶은 아템의 리스트를 준비한다
  2. Adapter를 이용한다

* Addview와 ListView의 차이점
  1. 만드는 방식이 다르다
  2. 그리는 방식이 다르다
     * Addview -> 리스트의 갯수와 상관없이 한번에 다 그린다
     * ListView -> 보여지는 부분 + 알파만 한번에 그리고 필요한 경우에 더 그린다

<br>

## 14. RecyclerView

- 장점
    - ListView의 개선판
        - ViewHolder 포함

    - 유연하다
        - LayoutManager
            - Linear
            - Grid
            - StaggeredGrid

<br>

## 15. TabLayout, Pager

* Pager
  * 종이 넘기듯이 화면을 넘겨는 역할

* TabLaout
  * tab을 담당하는 역할

* Adapter
  * Tablayout 과 pager를 연결해주는 역할

<br>

## 16. Database

* 데이터 베이스
  * 데이터를 저장하기 위함

* 데이터 저장 방식
  * RDB (Relational Database)
      - 관계형 데이터 베이스
      - 엑셀 처럼 생겼다
          이름  학번  학교  성벌
          홍길동 1   서울   남
          김개똥 2    전북  여
          김개똥 2    전북  여
          김개똥 2    전북  여
          김개똥 2    전북  여

  * Key-Value
      - 쌍으로 저장하는 방식 (키,벨류)

  * RDBMS
      - Relataional Database Management system
      - RDB를 관리 하기 위한 툴
      - MySQL
      - Oracle
      - PostgreSQL
  * SQL
      - RDBMS를 위한 언어이다

  * NoSQL
      - SQL말고 다르게 해보자!

* 안드로이드 데이터베이스
  * SQLiteDatabase
  * SharedPreference
      - Key-value 방식
      - 목적 : 공유된 사용자의 기호 방식
      - 하드하게 데이터베이스 시스템이 구축할 수 없다!

<br>

## 17. Async

* 종류
  * 동기 방식 -> Sync
    * 작업을 순서대로 진행한다
    * A -> B -> C -> D
    * 위에서부터 아래로 실행
  * 비동기 방식 -> Async
       * 쓰레드를 만들어서 작업을 따로 처리한다

* 안드로이드에서 Async 다루는 방법
     * AsyncTask상속받는다
          -> onPreExcute      : 쓰레드 출발하기전에 할 작업
          -> doIntBackground  : 쓰레드가 할 작업
          -> onPregressUpdate : 중간중간에 MainThread로 온다
          -> onPostExcute     : 작업을 다 마친후 MainThread

* Async의 장점
  * Main Thread를 기다리게 할 필요가 없다
  * 네트워크 작업

* Async의 단점
  * 재사용이 불가능 하다
  * 구현된 Activity가 종료될경우 따라서 종료 되지 않는다
  * AsyncTask는 하나만 실행될수 있다(병렬처리가 안된다)

<br>

## 18. Network

* 네트워크 -> 통신

* 통신 과정

  DataBase <-----> Server <------> Client(app,web,...)
       글                               					  A
       댓글                               				  B

* Local DataBase 의 한계
  * 동기화가 어렵다
  * 상호작용이 불가능 하다

* 서버와 통신하는 방법
  * 해당 url로 요청한다
  * 인증정보를 보낸다
  * JSON 형식을 사용해서 data를 보낸다
  * JavaScript Object Notation -> Javascript에서 객체를 만들 때 사용하는 표현식 이다

* JSON 형식
  * [] -> List
  * {} -> 객체
          -> "" -> 문자열
          -> ""없으면 -> 숫자

* Json Response

  ```json
  [
      {
          "id": 1,                -> 문서에 써있다
          "name": "홍길동",
          "age": 20,
          "intro": "나는 홍길동이다!"
      },
      {
          "id": 2,
          "name": "김아무개",
          "age": 10,
          "intro": "난 김아무개 입니다 :)"
      }
  ]
  ```

* Json Parsing -> Json을 코틀린이나 자바가 이해할수 있게 변형 하는 과정

* Serializable (직렬화)
  ----------------------->
    id, name, age, intro

* 코틀린이나/ 자바가 이해할수 있는 틀

  ```kotlin
  class Person(
      var id : Int? = null
      var name : String? = null
      var age : Int? = null
      var intro : String? = null
  )
  
  Person(1,"김아무개", 20, "안녕하세요")
  ```

* Request Type과 Status Code

  | Request Type |      설명      | Status Code |
  | :----------: | :------------: | :---------: |
  |     GET      |   정보 요청    |   200 OK    |
  |     POST     | 정보 추가 요청 | 201 Created |
  |    DELETE    | 정보 삭제 요청 |             |
  |     PUT      | 정보 수정 요청 |             |

* Status Code
  * 200번대 -> 처리가 잘 됬다

* Library
  * Volly
  * Retrofit

<br>

## 19. Permission (권한)

- 일반 권한
    - 인터넷 사용 권한,
    - Manifest에 등록만 하면 바로 사용 할 수 있다

- 위험 권한
    - 카메라, 연락처
      -> 사용자게 획득을 요청 해야 한다

* 권한을 얻는 타이밍
  * 설치하자 마자 필요한 권한을 묻는 경우
  * 특정기능을 사용하려고 할때 묻는 경우 -> Best Practice
