MQTT 
==
> 본 문서는 MQTT를 조사하고 공부한 내용을 담은 문서입니다. EdgeX와 Docker에 연관이 되어 있습니다.   
> Version:0.7

MQTT?
-- 
MQTT는 M2M, IOT를 위한 프로토콜로써, 최소한의 전력과 패킷량으로 통신하는 프로토콜이다. 따라서 IOT와 모바일 어플리케이션 등의 통신에 매우 적합한 프로토콜이다. 가장 대표적으로 FB Messagenger(Facebook)가 MQTT를 사용 중이다. 국내 통신사 PUSH 서버에도 사용 중이다. 

MQTT의 특징
--

- IBM에서 만들었다. 
- __저전력__ 으로 운용 (중요!)
- XMPP에 비해 훨씬 경량 (XMPP는 XML, MQTT는 byte로 전송하지만, 2byte부터 시작)
- MQTT Server를 라즈베리와 같은 임베디드 서버에도 넣을 수 있다. (즉, IoT용으로 Things가 서버가 될 수 있음)
- 대부분 사용자 인증만 제공 (user ID/passWD 방식) 이것도 대부분 서버들이 파일에 저장. (IDM, KMS와 연계가 필요함)
- TLS/SSL을 지원, X.509 인증서를 이용한 양방향 인증도 지원

MQTT의 구조
--

MQTT는 HTTP, TCP등의 통신과 같이 클라이언트-서버 구조로 이루어지는 것이 아닌 __Broker, Publisher, Subscriber__ 의 구조로 이루어진다. 
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/MQTT/MQTT_Server_structure.png)

Publicsher는 Topic을 발행(publish)하고, Subscriber는 Topic에 구독(subscribe)한다. Broker는 이들을 중계하는 역할을 하며, 단일 Topic에 여러 Subscriber가 구독할 수 있기에, 1:N 통신 구축에도 매우 유용함. (ROS 시스템의 구독, 발행자 노드 시스템과 거의 동일)

MQTT Broker 
--

MQTT 프로토콜을 구현하는 브로커들은 많은 종류가 있다. 

- Mosquitto
- HiveMQ
- mosca
- ActiveMQ
- RabbitMQ (plug-in 형태로 지원)

Mosquitto Broker
--
- Facebook이 현재 사용중인 Broker, C 기반으로 작성되었고 간편하지만 클러스터링(군집화)이 되지 않는다. 
- 일정 시간 패킷이 오지 않으면, 하트비트 메시지를 보내기 시작하고 메시지가 오지 않으면 끊어 버린다.

HiveMQ (저가 상용)
--

- 클러스터링이 동작함(Infinispan을 사용)
- JMX 모니터링을 사용 > JAVA 사용
- MultiCast로 클러스터링을 하지만, TCP로 Fixed Size 클러스터나 AWS EC2 클러스터 지원이 가능
- AWS/Azure 모두 지원
- 독일 SI회사가 운용 중

RabbitMQ
--

- Shared memory 구조가 없어서 어떻게 하는가 궁금하기는 하지만, 
- MQTT 3.1 지원
- QoS 0, 1만 지원 (QoS 2는 미지원)
- SSL 지원
- Session stickiness 지원

ActuveMQ
--

- Apache ActiveMQ는 가장 대중적이며 강력한 오픈 소스 메세징, 통합 패턴 서버
- 빠르며, 다양한 언어간의 클라이언트 및 프로토콜을 지원
- 사용하기 쉬운 엔터프라이즈 통합 패턴 및 많은 고급 기능을 제공하면서 JMS 1.1 및 J2EE 1.4를 완벽하게 지원
- MOM(Message-Oriented Middleware, 메시지 지향 미들웨어)이다.
- JMS(Java Message Service)를 지원하는 클라이언트를 포함하는 브로커, 자바 뿐만 아니라 다양한 언어를 이용하는 시스템간의 통신을 할 수 있게 도움을 준다. 또한 클러스터링 기능 및 DB 그리고 파일시스템을 통해 각 시스템간의 일관성 및 지속성을 유지시킨다.

Reference
--

- MQTT 서버 간단 공부 노트 (https://bcho.tistory.com/864)
- MQTT란? (https://medium.com/@jspark141515/mqtt%EB%9E%80-314472c246ee)
- ActiveMQ란? (https://swiftymind.tistory.com/9)
