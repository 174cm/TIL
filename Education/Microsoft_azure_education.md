Microsoft Azure Education 
==
> 본 문서는 2020.2.17~ 2.18 창원대학교에서 진행한 `클라우드 서비스 기반의 쉬운 인프라 구축과 모바일 앱 개발` 오프라인 교육 내용입니다. 

Azure에서 많이 사용하는 기능들
--

- Resourece groups: 우리가 생성한 리소스를 그룹 단위로 생성하여 관리를 진행 (과거에는 그냥 만들었으나, 현재는 무조건 리소스 그룹을 생성하여 관리를 진행)
- Cosmos DB: 실행속도가 매우 빠른 No SQL 형식의 DB
- Virtual machines: 일반적인 가상 머신으로 운영체제를 설치하여 구동하는 형태
- Storage accounts: 자동으로 세 군대에 저장하여 HDD나 SSD가 문제가 발생하더라도 어디서든 받아올 수 있는 저장소로 다음의 4가지 서비스를 포함한다.
    - Azure Blob
    - Azure Files
    - Azure queue
    - Azure Table

- Logic Apps: 코딩을 전혀 하지 않아도 로직을 통해 앱을 생성할 수 있는 기능

Step 1. 리소스 그룹 생성
--

1. 홈(Azure Potal이라고 부름) > 리소스 그룹을 클릭 > 리소스 추가 클릭 
2. 리소스 그룹 이름은 대,소문자를 가리지 않음
3. 리소스 세부 정보 영역: 리소스가 많은 미국 동부를 선택하는 것이 바람직함. (*주의: 클라우드는 아웃바운드일 때 요금이 산정됨.)
4. 만들기로 생성
5. Go to Resoure Group으로 생성한 리소스 그룹 확인 가능 

Step 2. Virtual Machine 생성
--

1. 리소스 그룹 > 추가 
2. Windows Server 2016 Datacenter 클릭
3. 가상 머신 이름 생성, 관리자 계정 생성
4. 디스크 SSD가 기본적으로 생성되어 있음
5. 네트워킹에서 RDP포트가 기본적으로 열려있음 
6. 검토 + 만들기로 생성 (5분정도 소요됨)
7. 배포가 완료됨을 확인
8. 리소스 그룹에서 만든 리소스를 다시 확인하면 6개의 리소스가 생성된 것을 확인할 수 있음

Step 3. Virtual Machine Connect
--

1. 홈 > 가상 머신으로 접속
2. 생성한 가상 머신 클릭
3. `연결`을 눌러 RDP로 접속
4. RDP 파일 다운로드 
5. 연결창에서 VM을 생성할 때 생성한 관리자 계정으로 로그인
6. 연결된 VM을 통해 확인 가능

Step 4. Storage Account
--

1. Storage Account 생성
2. 스토리지 계정 이름 생성 (DNS이름이기 때문에 소문자로만 생성하여야 함.)
3. 성능: 스탠다드, 계정 종류: v2
4. 복제: 기본적으로 3가지로 복제가 된다고 했었는데, 여기서 옵션을 줄 수 있음. 우리는 LRS로 선택
5. 액세스 계층: cool은 반응속도가 느리고 hot은 반응속도가 빠름 
6. 검토 및 만들기
7. Azure Storage Explorer 설치
8. Azure Storage Explorer login
9. Storage Account > user > Blob Container
10. Blob Container 우클릭 > 컨테이너 생성 (소문자로 생성)

Step 5. Logic App
--

1. 생성했던 리소스 그룹 > 추가 클릭
2. logic app 검색 > 만들기 
3. logic app 이름 생성 (소문자로 생성하여야 함.)
4. 검토 및 만들기 (조금의 시간 소요)
5. 로직 앱 디자이너 클릭 > 템플릿 > 비어 있는 논리 앱 클릭
6. BLOB 검색 
7. BLOB 컨테이너(폴더의 개념) 추가
8. 간격은 1분으로 조정
9. Next step 클릭 (여기까지 트리거 설정. )
10. Gmail 검색
11. send mail 클릭 
12. 제목과 본문에 적당한 것을 클릭.

Step 6. Function App  
--
Serverless service로 Function App이 문제가 생겨도 server에는 영향을 끼치지 않는 서비스 (마이크로 서비스)
1. 리소스 그룹 > 추가 > Function App 클릭
2. 함수 앱 만들기 
3. 함수 앱 이름 생성(DNS이기 때문에 소문자로 생성.)
4. 런타임 스택: `Node.js` 선택 
    - .NET Core: linux, Mac, Windows에서 모두 사용 가능하여 최근 클라우드를 만들 때 속도도 좋아 인기가 좋음. 
    - Node.js: NoSQL과 궁합이 좋아 사용.
5. 지역: East US 선택
6. `호스팅` 탭 클릭 
7. 스토리지 계정을 이전에 만들어 놓은 것으로 변경
8. 플랜: `소비`로 선택
    - 소비: 동적 확장 및 주문형 실행(첫 100만번은 무료, 이후 100만번 당 0.2$ 요금 발생)
    - 앱 서비스 플랜: 서버를 하나 생성하여 고정 비용이 나옴.
9. 검토 및 만들기 > 만들기
10. 생성된 FunctionApp에서 함수 앱 설정 클릭 
11. 런타임 버전을 1 버전으로 변경(예전 템플릿이 많아 사용)
    - 바인딩: 연동이 편하다.
12. 함수에서 + 클릭 
13. Custom function 클릭 
14. `post`를 검색하여 HTTP POST를 선택 
15. HTTP POST는 언어: javascript, 이름: poster, 권한 수준: Anonymous, 테이블 이름: person(없으면 자동으로 생성), 저장소 계정 연결: AzureWebJobsStorage 선택
16. 만들기 
17. 
```java  
module.exports = function (context, req) {
    var statusCode = 400; //
    var responseBody = "Invalid request object";

    if (typeof req.body != 'undefined' && typeof req.body == 'object') {
        statusCode = 201; //문제가 없으면 201 respown
        context.bindings.outTable = req.body; //중요한 코드: function.json과 연동 
                                              //function.json에는 3개의 객체가 있는데 3객체에는 direction이 존재함. 
                                              //1. direction:in, 2. direction:out, 3. direction:out
                                              //direction:in은 인바운드로 들어오는 것을 나타냄
                                              //direction:out은 http 형식으로 내보내는 것
                                              //direction:out은 
        responseBody = "Table Storage Created";
    }

    context.res = {
        status: statusCode,
        body: responseBody
    };

    context.done();
};
```
18. 오른쪽에 `테스트` 클릭 
19. 실행 클릭하여 `"Table Storage Created"` 메시지 확인
20. Storage Explorer > Table 에서 확인 가능
21. Postman을 설치하여 REST api를 테스트 진행
22. Google 계정으로 연동하여 로그인
23. Postman에서 메인화면에 있는 + 버튼을 클릭
24. Post로 변경하고 URL은 포탈의 index.js 옆에 있는 함수URL 가져오기를 클릭하여 copy
25. 다시 Postman으로 돌아와 `Body` 탭 클릭 > raw 클릭 > 우측의 text 형식에서 `json`형식으로 변경
26. 포탈에 있는 json을 복사하여 붙여넣음
27. Send로 결과값 확인 

Step 7. CLI 사용 
--

az group show create delete 등 명령어가 존재
   
