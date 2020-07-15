Keyword amassed
==
> 본 문서는 IT용어 Keyword들을 모아 공부 및 정리하는 용도의 문서입니다.

HTML
-- 

- nbsp: HTML에서 사용되는 특수 문자 기호입니다. nbsp는 __Non-breaking Space__ 의 약어이며 __공백(Space)__ 을 나타내 주는 것이라 이해하면 쉽습니다. 이 기호를 일반적인 문자 조합과 구분하기 위해 앞에는 &, 뒤에 ;를 넣어 &nbsp;라 표기합니다. 

- lt: lt는 Less than sign의 약자로 부등호를 나타냅니다. 기호로 표기하면 (<)로 표기됩니다. 마찬가지로 앞에는 &, 뒤에는 ;를 넣어 &lt;로 표기합니다. 

- gt: gt는 Greater than sign의 약자로 부등호를 나타냅니다. 기호로 표기하면 (>)로 표기됩니다. 마찬가지로 앞에는 &, 뒤에는 ;를 넣어 &gt;로 표기합니다. 

- MIME-Type: MIME(Multipurpose Internet Mail Extensions) 타입은 다목적 인터넷 메일 확장이란 뜻으로, 전자우편의 데이터 형식을 정의한 표준입니다. 하지만 지금은 웹을 통해 전달되는 다양한 형태의 파일을 표현하기 위해 사용되고 있습니다. 

    - 문법  
        일반적으로 MIME 타입은 '타입/서브타입'의 형태입니다. '/'를 통해 문자로 구분된 두 개의 타입으로 파일의 타입을 명시하며 이 때, 타입 이름으로 공백 문자는 허용하지 않습니다. 대,소문자를 구분하지는 않지만 보통 소문자를 사용합니다.
        ```
        text/plain, image/gif, audio/wav ...
        ```
    - MIME Type 예제
        |타입|설명|서브타입|
        |--|--|--|
        |text|텍스트로 표현되는 모든 문서를 나타내며 인간이 읽을 수 있는 데이터를 의미|text/plian, text/html, text/css, text/javascript...|
        |image|모든 종류의 이미지를 나타냄|image/jpeg, image/png, image/gif...|
        |audio|모든 종류의 오디오 파일들을 나타냄|audio/mpeg, audio/wav, audio/midi...|
        |video|모든 종류의 비디오 파일들을 나타냄|video/ogg, video/webm|
        |appication|모든 종류의 바이너리 데이터를 나타냄|application/xml, application/json, application/xhtml+xml, application/pdf...|

Server 
--
- MQTT Server: M2M, IOT를 위한 프로토콜로써, 최소한의 전력과 패킷량으로 통신하는 프로토콜이다. 따라서 IOT와 모바일 어플리케이션 등의 통신에 매우 적합한 프로토콜이다. 일반적인 HTTP, TCP등의 클라이언트 - 서버 통신과는 달리 Broker, Publisher, Subscriber 구조로 이루어진다. 

- Push Server: 기존의 서버는 대부분 클라이언트에서 서버에 요청하는 (pull)방식이 많이 사용되었다. 하지만 최근 스마트폰, 테블릿이 보급되면서 요청이 많아지면서 클라이언트가 서버에게 요청 > 다시 자료를 받는 방법을 사용하였으나 이 방법은 패킷을 많이 소모하게 되었다. 그래서 나온 방식이 서버에서 새로운 소식이 있을 때 클라이언트로 알려주는 Push방식이 많이 사용되고 있다.

Security
--

- SHA(Secure Hash Algorithm): 해쉬 알고리즘 함수들은 서로 관련된 암호학적 해시 함수들의 모음입니다. 이들 함수는 미국 국가보안국(NSA)이 1993년에 처음 설계하였고 미국 국가 표준으로 지정되었습니다. SHA는 SHA-224, SHA-256, SHA-384, SHA-512등이 존재합니다. 


    - SHA-1 해시값의 예제
    ```
    SHA1("The quick brown fox jumps over the lazy dog")
    = 2fd4e1c67a2d28fced849ee1bb76e7391b93eb12
    ```

    ```
    SHA1("The quick brown fox jumps over the lazy dog.")
    = 408d94384216f890ff7a0c3528e8bed1e0b01621
    ``` 
    산사태 효과(avalanche effect)때문에 점 하나 차이로 값이 달라지는 것을 확인할 수 있습니다. 

BigData
--

- BigData: 한대의 컴퓨터로는 저장하거나 연산하기 어려운 규모의 거대 데이터.
- Hadoop: 빅데이터의 저장과 분석을 위한 분산 컴퓨팅 솔루션으로 자바 소프트웨어 프레임워크이다. 분산처리 시스템인 구글 파일 시스템을 대체할 수 있는 하둡 분산 파일 시스템(HDFS: Hadoop Distributed File System)과 맵리듀스(MapReduce)를 구현한 것이다.
- MapReduce: 구글에서 대용량 데이터 처리를 분산 병렬 컴퓨팅에서 처리하기 위한 목적으로 제작하여 2004년 발표한 소프트웨어 프레임워크. 함수형 프로그래밍에서 일반적으로 사용되는 Map과 Reduce라는 함수 기반으로 주로 구성된다.

Smart Factory
--

- HMI(Human Machine Interface): 기계 제어에 사용되는 데이터를 인간에게 친숙한 형태로 변환하여 보여주는 장치. 이것을 통해 관리자가 해당 공정을 감시하고 제어하게 된다.
- SCADA(Supervisory Control And Data Acquisition): 산업 공정/기반 시설/설비를 바탕으로 한 작업공정을 감시하고 제어하는 컴퓨터 시스템을 말한다.

AI
--

- NLP(Natural Language Processing): 유용한 업무 수행을 위해 자연 언어(사람의 언어)를 컴퓨터가 처리하고 이해할 수 있도록 하는 것을 말한다. 스펠링 및 맞춤법 검사, 키워드 검색, 동의어 발견 등에 사용할 수 있고 웹사이트로부터 정보를 추출하거나 문서를 분류하는 것 등등 많은 부분에서 활용이 가능하다.

Docker
--

- Docker Container Orchestration: docker contatiner의 갯수가 꾸준히 늘어나면 필요한 자원 또한 지속적으로 늘어난다. 때문에 서버 또한 여러대로 늘어난다. 많은 서버들을 하나씩 접근하여 관리하기에는 시간과 인력이 소모된다. 이러한 다중 컨테이너 패키지 어플리케이션을 배포하는 동안 사용되는 컨테이너, 리소스의 자동화, 정렬, 조정 및 관리를 하는 작업을 Container Orchestration이라고 한다. 이를 위해서는 Tool이 필요한데 여러가지 Tool이 있다. 큰 예로 Docker Swarm, Kubernetes, ECS 등이 있다.

Technique
--

- Mob Programming: 이 작업 기법은 페어 프로그래밍의 확장판으로 우리말로 번역하면 __떼 코딩__ 정도가 된다. 몹 프로그래밍은 한명의 드라이버와 여러 명의 프로그래머가 하나의 PC로 코딩 또는 문서화 작업을 진행하는 개발 방식으로 1:1방식인 페어 프로그래밍을 1:N으로 확장시킨 형태이다. 여기서 N은 에자일 개발팀 전체 인원수로 팀 전원이 참여한다는 것이 특징이다.

Reference
--

- Push Server (https://cozyboy.tistory.com/entry/push-server)