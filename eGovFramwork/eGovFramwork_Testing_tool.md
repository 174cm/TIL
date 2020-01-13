> 본 문서는 전자정부 표준프레임워크 QuickStart[(링크)](http://www.yes24.com/Product/Goods/66372749) 책을 공부한 내용을 기술하였습니다.

Chapter 3. 테스팅 도구
===

3장에서는 테스팅도구를 소개합니다. 

JUnit  
--  
단위 테스트에 가장 많이 사용되는 툴은 JUnit입니다. Junit은 자바 기반 오픈소스 테스트 프레임워크입니다. TDD(Test Driven Development) 개념을 정립하고, 애자일(agile) 방법론의 한 형태인 XP(eXtream Programming)을 만든 켄트 백과 GoF 디자인패턴을 집대성한 에릭 감마가 개발하였습니다.

Junit은 기댓값과 결괏값을 비교 및 검증할 수 있는 __assertion__ 기능을 제공하며, 테스트 케이스와 테스트 스위트(suite)로 구성되어 테스트 코드를 하나의 독립적인 클래스 단위로 작성할 수 있습니다. 

JUnit의 장점
 --
 1. 자동화된 단위 테스트의 구현
 2. 빌드 도구(Ant, Maven, Gradle)와 연계하여 빌드 시, 자동 테스트를 구현   
 3. 테스트 케이스 작성을 위한 다양한 api 제공
 4. 뛰어난 확장성 제공(Junittee, Cactus, HttpUnit, JUnitPerf)
 5. 대부분의 자바 IDE에서 지원

 JUnit 라이브러리의 사용
 --
JUnit을 사용하기 위해서는 3가지의 방법이 있습니다. 여기서는, __2. 이클립스에서 라이브러리를 추가__ 하여 사용하는 방법을 사용합니다.

1. 클래스 패스 추가
2. 이클립스에서 라이브러리 추가
3. 메이븐의 디펜던시 설정

JUnit life cycle
--

JUnit 4.X 버전에서는 어노테이션(Annotation, @)을 사용하며, 라이프 사이클은 다음과 같습니다. 

1. @BeforeClass(해당 테스트 클래스가 실행되기 이전의 수행할 코드 구현)  
                 ↓  
2. @Before(테스트 작성 전에 수행할 코드 구현)  
 ↓  
3. @Test(테스트 코드 구현)  
    assertXXX 메소드를 사용하여 테스트 로직을 구현함  
     ↓
4. @After(테스트 종료 전에 수행할 코드 구현)  
 ↓  
5. @AfterClass(해당 테스트 클래스가 실행된 이후에 수행할 작업 구현)

JUnit Test method
--

JUnit에서 주로 사용되는 메소드들은 다음과 같습니다.

- assertEqulas(java.lang.Object expected, java.lang.Object actual)
: 기댓값과 실젯값이 같다는 것을 의미
- assertEqulas(java.lang.String message, java.lang.Object expected, java.lang.Object actual)
: 기댓값과 실젯값이 같은지를 의미하며, 같지 않았을 경우 메시지를 삽입하여 각각의 판단을 구별할 수 있게 함.
- assertNotNull(java.lang.Object object)
: 해당 객체가 Null이 아닌지 판단함.
- assertNotSame(java.lang.Object expected, java.lang.Object actual)
: 기댓값과 실젯값이 같지 않다는 것을 판단함.
- assertNull(java.lang.Object object)
: 해당 객체가 Null인지 판단함.
- aseertSame(java.lang.Object expected, java.lang.Object actual)
: 기댓값과 실젯값이 같은지 판단함.
- assertTrue(Boolean condition)
: 해당 조건이 ture인지 판단함.