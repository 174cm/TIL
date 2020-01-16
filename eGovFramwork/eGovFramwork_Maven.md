> 본 문서는 전자정부 표준프레임워크 QuickStart[(링크)](http://www.yes24.com/Product/Goods/66372749) 책을 공부한 내용을 기술하였습니다.

Chapter 04. Maven
==

Maven?
--
메이븐은 소프트웨어를 개발할 때 반복되는 작업을 자동화하는 빌드 도구로, 자바 프로젝트의 빌드를 자동화 해주는 빌드 툴이다. 쉽게 말해 자바 소스를 컴파일하고 패키지해서 서비스 하는 일을 자동화 해주는 것이다.

![image](https://media.discordapp.net/attachments/633251365434687491/667360850142691329/unknown.png)

> __그림__: Maven logo

Maven의 구성
--
메이븐은 일반적으로 다음과 같은 5개의 흐름으로 구성된다.
- Build
    - 소스 코드를 컴파일
    - 패키지 생성을 위한 바이너리를 생성
- Package
    - 배포 가능한 파일, exe 등을 생성

- Test
    - 단위 테스트(Unit test) 등을 실행
    - 빌드 결과 점검

- Report
    - 빌드/패키지/테스트 결과를 정리하고, 빌드 수행 리포트를 생성
- Release
    - 빌드 후, 생성된 아키팩트(artifact)를 로컬 혹은 원격 저장소에 저장(배포)  

##### *artifact: 산출물의 의미로, 각종 설계 문서, 유스케이스, UML, 소스코드 등을 비롯한 생성된 라이브러리와 실행파일 모두가 여기에 속한다. 

![image](https://t1.daumcdn.net/cfile/tistory/999BF0365A53402124?download)
> __그림__: Maven의 전체 구조

Maven의 특징
--
1. __정형화된 구조와 절차를 제공__  
: 메이븐은 컴파일, 패키징, 테스트 등의 작업 프로세스를 정형화하고 이를 준수하도록 강제한다. 따라서, 모든 프로젝트에 일관된 디렉토리 구조와 빌드 프로세스를 유지할 수 있게 되어 표준에 따른 개발이 가능해진다.

2. __디펜던시 라이브러리 해결을 자동화__  
: 애플리케이션을 실행하기 위해 필요한 라이브러리들과 그 라이브러리들이 필요로하는 라이브러리 등의 의존성 혹은 종속성을 __라이브러리 디펜던시__ 라고 한다. 

3. __라이브러리 관리가 용이__  
: 메이븐에서는 라이브러리 전용 저장소를 제공하므로, 통합 관리가 가능해진다. (일반적으로 프로젝트 진행 시, 사용되는 라이브러리는 형상 관리 도구에서 관리한다.)

4. __라이프 사이클을 가짐__  
: 메이븐은 라이프 사이클을 가지고 있어 라이프 사이클에 따라 연속적으로 단계를 실행한다.

5. __다양한 플러그인을 활용 가능__

Maven 저장소
-- 
메이븐의 저장소는 3가지로 분류할 수 있다.

1. 중앙 저장소
2. 원격 저장소
3. 로컬 저장소
    
- 중앙 저장소: 오픈 소스 라이브러리, 메이븐 플러그인, 메이븐 아키타입을 관리하는 저장소. 메이븐 2.0의 중앙 저장소의 URL은 http://repo1.maven.rog/maven2/이다. 중앙 저장소는 개발자가 임의로 라이브러리를 배포할 수 없다.

- 원격 저장소: 중앙 저장소에 없는 라이브러리를 한 곳에 모아두기 위하여 별도의 메이븐 저장소를 설치해 관리하는 것이 가능한데 이것이 원격 저장소이다. 원격 저장소는 회사내에서만 사용하기 위한 용도로 많이 사용된다.
![image](https://media.discordapp.net/attachments/633251365434687491/667372124289105930/unknown.png)
> __그림__: 원격 저장소의 구조

- 로컬 저장소: 로컬 저장소는 메이븐을 빌드할 때 다운로드하는 라이브러리이다. 플러그인을 관리하는 개발자 PC의 저장소이다. 
![image](https://media.discordapp.net/attachments/633251365434687491/667372288248643597/unknown.png)
> __그림__: 로컬 저장소의 구조

의존성 관리
--

- Pom.xml 파일안에 `<dependencies>`요소를 사용하여 표현
- Pom에 있는 프로젝트의 의존성 정보를 기반으로 의존성을 분석
    - 로컬 저장소에서 의존성 정보를 기반으로 확인
    - 원격 저장소 리스트에서 의존성 확인
    - 의존성 확인 실패시, 에러 보고

Pom.xml
--

Pom.xml 파일은 메이븐 프로젝트 생성 시, 기본으로 생성되는 파일로, 프로젝트 관리 및 빌드에 필요한 환경 설절과 의존성 관리 등, 프로젝트 정보들을 담고 있습니다. 

Pom.xml 파일은 프로젝트의 세부 메타 데이터 정보를 포함하여 크게 10개의 항목으로 구성됩니다.

- General Information: 프로젝트 이름, 설명, 버전 정보 등
- Organization: 프로젝트 조직 정보(이름, 홈페이지, URL 등)
- Project Team and Collaborations tools: 형상관리 서버, 이슈 트래커, 통합 빌드 서버 정보 등
- Build: 인코딩 정보 등 빌드 라이프 사이클 환경 설정 
- Repoting: 리포트 생성 기능 설정
- Dependencies: 프로젝트에서 사용하는 라이브러리를 선언하여 Build Path에 포함
- Repositories: 라이브러리 저장소 위치 설정
- Destribution Management: 배포 환경 설정
- Profiles: 빌드 설정
- Properties: 프로젝트 속성

![image](https://media.discordapp.net/attachments/633251365434687491/667373926241927179/unknown.png?width=756&height=284)

> __그림__: Pom.xml의 구조

dependency
--
개발자는 프로젝트에 사용할 라이브러리를 Pom.xml에 dependency로 정의만 해두면 메이븐이 repository에서 검색하여 자동으로 추가해준다. 심지어 참조하고있는 library까지 모두 찾아서 추가해준다. 이것을 __의존성 전이__ 라고 한다.

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

> __코드__: dependency 예제

### 필수 선언 항목

여기서, 필수 선언 항목이 __groupId__, __artifactId__, __version__ 3가지이다. 

- groupId: 부분적인 프로젝트나 조직에서 라이브러리 집합을 식별하기 위함
- artifactId: 프로젝트의 실제 이름
- version: 선언한 디펜던시 아티팩트의 버전

### Scope

scope는 라이브러리 간의 충돌이 일어나는 경우를 방지하기위해 명시하는 것으로 디펜던시 하위에 포함되는 항목이다. 해당 디펜던시가 포함되는 범위에 대한 타입을 뜻한다.  
compile, provided, runtime, test, system 등이 있다.

- compile: 기본값으로 모든 클래스 패스에서 사용가능
- provided: 컴파일과 유사하나 패키지에는 포함되지 않는다. 
- Runtime: 컴파일러가 아닌 런타임 시에 사용.
- Test: 테스트 시에 사용
- System: provide와 유사하나, 개발자가 직접 JAR 파일(하나의 애플리케이션이 가능하도록 java 파일을 압축하고 지원)을 제공해야 하고, 저장소에서 지정한 dependency를 찾지 않는다.
