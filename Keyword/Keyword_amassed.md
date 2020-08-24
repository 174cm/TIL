Keyword amassed
==
> 본 문서는 IT용어 Keyword들을 모아 공부 및 정리하는 용도의 문서입니다.  
> `ABCDEFGHIJKLMNOPQRSTUVWXYZ`의 알파벳 순으로 정렬하였습니다. 

AI
--

- __NLP(Natural Language Processing)__: 유용한 업무 수행을 위해 자연 언어(사람의 언어)를 컴퓨터가 처리하고 이해할 수 있도록 하는 것을 말한다. 스펠링 및 맞춤법 검사, 키워드 검색, 동의어 발견 등에 사용할 수 있고 웹사이트로부터 정보를 추출하거나 문서를 분류하는 것 등등 많은 부분에서 활용이 가능하다.
- __GPT-3(Generative Pre-Training 3)__: OpenAI에서 공개한 새로운 언어 모델로 이 모델은 4990억개 데이터셋 중에서 가중치 샘플링해서 3000억(300B)개로 구성된 데이터셋으로 사전 학습을 받았으며, 1750억개(175Billion) 매개 변수로 딥러닝의 한계까지 추진돼 미세 조정없이 여러 자연어 처리 벤치마크에서 최첨단 성능을 달성했다. 발표된 내용이라면 단 몇 개 키워드만 넣으면 작문을 작성해주는 혁신적인 AI 언어생성 모델이자 알고리즘이다. 


BigData                
--

- __BigData__: 한대의 컴퓨터로는 저장하거나 연산하기 어려운 규모의 거대 데이터.
- __Hadoop__: 빅데이터의 저장과 분석을 위한 분산 컴퓨팅 솔루션으로 자바 소프트웨어 프레임워크이다. 분산처리 시스템인 구글 파일 시스템을 대체할 수 있는 하둡 분산 파일 시스템(HDFS: Hadoop Distributed File System)과 맵리듀스(MapReduce)를 구현한 것이다.
- __MapReduce__: 구글에서 대용량 데이터 처리를 분산 병렬 컴퓨팅에서 처리하기 위한 목적으로 제작하여 2004년 발표한 소프트웨어 프레임워크. 함수형 프로그래밍에서 일반적으로 사용되는 Map과 Reduce라는 함수 기반으로 주로 구성된다.

Docker
--

- __Docker Container Orchestration__: docker contatiner의 갯수가 꾸준히 늘어나면 필요한 자원 또한 지속적으로 늘어난다. 때문에 서버 또한 여러대로 늘어난다. 많은 서버들을 하나씩 접근하여 관리하기에는 시간과 인력이 소모된다. 이러한 다중 컨테이너 패키지 어플리케이션을 배포하는 동안 사용되는 컨테이너, 리소스의 자동화, 정렬, 조정 및 관리를 하는 작업을 Container Orchestration이라고 한다. 이를 위해서는 Tool이 필요한데 여러가지 Tool이 있다. 큰 예로 Docker Swarm, Kubernetes, ECS 등이 있다.

Embedded
--

- __HOST System__: HOST는 임베디드 환경에서 실제 프로그램을 개발하는 PC를 뜻한다. 타겟 시스템을 위한 어셈블러, 컴파일러, 링커 등 개발도구를 제공한다.

- __Target System__: Target은 Host에서 개발한 소프트웨어가 동작될 환경을 뜻한다. 임베디드 보드, 스마트 폰, PDA 등을 타겟 시스템이라고 부른다. 

- __Toolchain__: 툴체인은 소프트웨어 개발에 사용되는 프로그래밍 도구의 집합. 더 나아가 타겟 시스템에서 동작하는 프로그램 개발에 필요한 호스트 시스템의 소프트웨어 또는 개발환경을 통칭. 여기에는 링커, C 컴파일러, C 라이브러리 등이 있다.

- __Cross compile__: 크로스 컴파일은 개발 PC인 호스트에서 컴파일을 하여 나온 실행파일을 타겟에서 사용하는 것을 말한다.  

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

NetWork
--

- __MQTT__: M2M, IOT를 위한 프로토콜로써, 최소한의 전력과 패킷량으로 통신하는 프로토콜이다. 따라서 IOT와 모바일 어플리케이션 등의 통신에 매우 적합한 프로토콜이다. 일반적인 HTTP, TCP등의 클라이언트 - 서버 통신과는 달리 Broker, Publisher, Subscriber 구조로 이루어진다. 
- __Subnet__: IP 주소에서 네트워크 영역을 부분적으로 나눈 부분망, 부분 네트워크. IPv4의 비효율적인 문제를 해결하기 위하여 IP를 사용하는 네트워크 장치 수에 따라 효율적으로 사용할 수 있도록 만든 부분망.
- __Gateway__: 하나의 네트워크에서 다른 네트워크로 이동하기 위하여 거쳐야 하는 지점을 뜻한다. 게이트 웨이는 서로 다른 네트워크(이기종 네트워크)를 연결해준다.

- __Beamforming__: 빔포밍은 스마트 안테나의 한 방식으로 안테나에서 신호를 사방으로 유포하는 것이 아닌 특정 수신 기기에 집중시키는 기술. spotlight로 생각하면 쉽게 이해가 가능하다.  
- __DHCP(Dynamic Host Configuration Protocol)__: Host의 IP주소와 각종 TCP/IP Protocol의 기본 설정을 클라이언트에게 자동적으로 제공해주는 Protocol을 뜻한다. 쉽게 말해서, PC나 스마트폰에서 IP설정을 __자동__ 으로 했을 때 IP가 잡히도록 해주는 기능이다.

=======


Server 
--

- __Push Server__: 기존의 서버는 대부분 클라이언트에서 서버에 요청하는 (pull)방식이 많이 사용되었다. 하지만 최근 스마트폰, 테블릿이 보급되면서 요청이 많아지면서 클라이언트가 서버에게 요청 > 다시 자료를 받는 방법을 사용하였으나 이 방법은 패킷을 많이 소모하게 되었다. 그래서 나온 방식이 서버에서 새로운 소식이 있을 때 클라이언트로 알려주는 Push방식이 많이 사용되고 있다.

Security
--

- __SHA(Secure Hash Algorithm)__: 해쉬 알고리즘 함수들은 서로 관련된 암호학적 해시 함수들의 모음입니다. 이들 함수는 미국 국가보안국(NSA)이 1993년에 처음 설계하였고 미국 국가 표준으로 지정되었습니다. SHA는 SHA-224, SHA-256, SHA-384, SHA-512등이 존재합니다. 


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

- __FailOver__: 컴퓨터 서버, 시스템, 네트워크 등에서 이상이 생겼을 때 __시스템 대체 작동__ 또는 __장애 극복__ 을 위하여 __예비 시스템으로 자동 전환__ 되는 기능을 말한다. 사람이 수동으로 전환을 실시하는 것을 __스위치 오버__ 라고 말한다. 

Smart Factory
--

- __OPC-UA(Open Platform Communication Unified Architecture)__: OPC는 다양한 제조업체의 장치를 통합하기 위한 국제 산업 자동화 표준 규격이며, OPC-UA는 OPC에서 더 발전한 산업용 표준 프로토콜을 뜻합니다. 
- __IIoT (Industrial Internet of Things)__: 기존의 IoT에서 산업용에 특화된 사물인터넷 기술을 의미한다. 
- __HMI(Human Machine Interface)__: 기계 제어에 사용되는 데이터를 인간에게 친숙한 형태로 변환하여 보여주는 장치. 이것을 통해 관리자가 해당 공정을 감시하고 제어하게 된다.
- __SCADA(Supervisory Control And Data Acquisition)__: 산업 공정/기반 시설/설비를 바탕으로 한 작업공정을 감시하고 제어하는 컴퓨터 시스템을 말한다.
- __MACHBASE__: 마크베이스는 스마트팩토리의 설비 센서데이터 처리에 최적화된 데이터베이스이다. 반도체, 제철, 제지, 제약, 등 제조업의 생산 설비에서 발생하는 센서 데이터를 수집, 저장, 조회, 분석하는 다양한 활용사례가 있다. 
- __TSN(Time Sensitive Networking)__: 표준 이더넷 네트워크에서 확정적 메시지 전송을 구현하기 위한 일련의 표준. '확정적'이란 말은 네트워크 정보 송수신에 대한 예외 없이 무조건적인 완수가 이루어진다는 의미이며, TSN에서 이는 반드시 목표한 시간 내에 이뤄저야 한다. 
- __UMATI(Universal MAchine Tool Interface)__: UMATI는 범용 공작기계 인터페이스의 약자로 AIT 플랫폼 연결을 위해 특정 인터페이스를 표준화한 것이다. UMATI는 OPC-UA 기반 구조로 이루어져 있다. 
 
Technique
--

- __Mob Programming__: 이 작업 기법은 페어 프로그래밍의 확장판으로 우리말로 번역하면 __떼 코딩__ 정도가 된다. 몹 프로그래밍은 한명의 드라이버와 여러 명의 프로그래머가 하나의 PC로 코딩 또는 문서화 작업을 진행하는 개발 방식으로 1:1방식인 페어 프로그래밍을 1:N으로 확장시킨 형태이다. 여기서 N은 에자일 개발팀 전체 인원수로 팀 전원이 참여한다는 것이 특징이다.

Reference
--

- Push Server (https://cozyboy.tistory.com/entry/push-server)