> 본 문서는 전자정부 표준프레임워크 QuickStart[(링크)](http://www.yes24.com/Product/Goods/66372749) 책을 공부한 내용을 기술하였습니다.

Chapter 02. 전자정부 표준프레임워크 설치
===

이번장에서는 전자정부 표준프레임워크를 설치하는 것을 살펴보겠습니다.

Section 2. 개발 환경 구축
--

개발 환경은 개발자 통합 개발 환경과 경량 개발 환경 두 가지 방법으로 설치가 가능합니다.

### 1. 개발자 통합 개발 환경

개발자 통합 개발 환경은 기능들을 모두 설치하는 방법입니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665558807325311006/unknown.png)

>__그림__: 통합 개발 환경 구조

### 2. 개발자 경량 개발 환경

개발자 경량 개발 환경은 필수 환경만 설치하는 경량화 방법입니다. (추가적으로 선택설치도 가능)

![image](https://media.discordapp.net/attachments/633251365434687491/665558978499182612/unknown.png)

>__그림__: 경량 개발 환경 구조

Section 3. 다운로드
--

### 1. 개발자 경량 개발 환경 설치

`다운로드 > 표준프레임워크 통합 다운로드`를 설치하게 되면 표준프레임워크 통합다운로드라고 되어있지만, __경량 개발 환경으로 설치__ 가 되니 통합 개발을 다운받기 위해서는 이 것을 다운받으면 안됩니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665560183321395200/unknown.png?width=759&height=314)

![image](https://media.discordapp.net/attachments/633251365434687491/665560258596438106/unknown.png)

>__그림__: 개발자 경량 개발 환경 설치 과정

### 2. 개발자 통합 개발 환경 설치

`개발자 교육 > 교육자료`에 있는 `표준프레임워크 개발자 교육 고지 및 실습`을 다운받으면 통합 개발 환경 설치가 가능합니다.
또한, 설치는 무조건 `C:\`에 설치하여야 eGovFrame이 정상적으로 동작합니다. 용량이 9GB정도로 꽤 크므로 15분가량 기다려야 합니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/665561007707521025/unknown.png)

![image](https://media.discordapp.net/attachments/633251365434687491/665561266152276000/unknown.png)

>__그림__: 개발자 통합 개발 환경 설치 과정

다운로드가 완료되면, 다음과 같이 이클립스가 들어있는데, 실행시키면 eGovFrame이라고 뜨면서 이클립스가 실행됩니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665561986888892436/unknown.png)

![image](https://media.discordapp.net/attachments/633251365434687491/665562064923787283/unknown.png)

>__그림__: eGovFrame 실행

### 3. 서버 개발 환경 구축

서버 개발 환경은 통합 환경을 다운로드 받으면 포함되어 따로 설치할 필요는 없습니다. 다만 따로 설치가 필요할 경우, `개발환경 다운로드 > 서버용 개발환경 Version 3.8 or Version 3.5`를 수동으로 다운로드할 수 있습니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/665562662385614869/unknown.png)

>__그림__: 서버 개발 환경 다운로드 

### 4. Visual SVN Server 설치 및 설정

Visual SVN, SVN은 Subversion의 줄임말로 보통 형상관리 툴을 의미합니다. svn의 사용목적은 여러명이서 작업하는 프로젝트의 경우, 버전관리나 각자 만든 소스를 어떻게 통합시킬것인가 에 대한 이슈를 해결하기 위해 저장소를 만들어 저장소에 소스를 저장시켜 중복이나 여러 이슈를 해결하기 위한 소프트웨어입니다.   
`https://www.visualsvn.com/server/download/`해당 경로에서 다운로드 할 수 있으며 Server 포트만 잘 맞추어주면 됩니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665563959889494037/unknown.png)

>__그림__: 설치가 완료된 Visual SVN 

### 5. Oracle 설치 및 설정

통합 개발 환경을 설치할 때, MySQL이 설치가 되지만 주로 현업에서는 오라클 데이터베이스를 많이 사용하기에 해당 책에서는 오라클을 사용합니다. 여기서는 `Oracle 11g` 버전을 사용합니다.
`Oracle 홈페이지 > 다운로드 > 데이터베이스 > Database 11g Enterprise`를 선택해 다운로드 합니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/665564603085881364/unknown.png?width=752&height=448)

![image](https://media.discordapp.net/attachments/633251365434687491/665564708333420545/unknown.png)

>__그림__: Oracle Database 11g ver 다운로드

설치 후, 권한을 설정해줍니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665565385118187521/unknown.png)

다음, Eclipse를 실행하여 오라클과 연결합니다.

![image](https://media.discordapp.net/attachments/633251365434687491/665565617964711947/unknown.png)

Reference
--

- http://maven.egovframe.kr/publist/HDD1/public/edu/textbook/02%EA%B0%95_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD%20%EC%86%8C%EA%B0%9C%20%EB%B0%8F%20%EA%B5%AC%ED%98%84%EB%8F%84%EA%B5%AC%2C%20%EA%B0%9C%EC%9D%B8%EB%B9%8C%EB%93%9C.pdf
