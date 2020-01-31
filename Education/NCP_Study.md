Naver Cloud Platform
==

> 2020.01.31일에 네이버 파트너스퀘어 부산에서 진행한 네이버 클라우드 플랫폼 핸즈-온 교육을 정리한 내용입니다.

Naver Cloud Platform?
--

네이버 비즈니스 플랫폼(NBP)은 네이버와 계열사들의 IT 인프라를 지원하는 네이버의 자회사로, 네이버를 비롯한 수많은 서비스들을 대상으로 한 신속하고 안정적인 IT 인프라 운영 경험을 바탕으로 고품질의 '네이버 클라우드 플랫폼' 서비스를 제공합니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/672615718134480897/unknown.png)

![image](https://media.discordapp.net/attachments/633251365434687491/672614705549803540/unknown.png?width=1101&height=310)
> __그림__: 네이버 클라우드 플랫폼 

Why Cloud?
--

- 효율에 대한 비용절감 효과
    - 데브옵스를 통한 인건비 절감
    - 오토 스케일링 서비스 통한 인프라 비용 최적화
    - SaaS, PaaS, 다양한 부가상품 활용을 통한 개발 비용 절감

- 빠른 Deploy
    - 기존 레거시 인프라에 비해 빠른 Deployment

- 글로벌 시장 진출 용이
    - Global 리전을 활용한 손쉬운 글로벌 서비스 가능

- 보안
    - 인프라에 대한 보안은 CSP (Cloud Service Provider)에 위임
    - 서비스 레벨에 대한 보안만 신경쓰면 됨.

네이버 클라우드 플랫폼 장점
--

- __24시간 365일__ 고객 센터 운영 (타사 글로벌 밴더는 미운영)
- __매달 신제품 출시 및 기존 상품에 대한 업데이트__ 진행
- 반응형 웹 기반의 사용하기 __쉬운 UX/UI__ 
- 까다로운 __공공 클라우드 인증 통과__ 
- 각 리전 간 __전용선을 바탕으로 안정적으로 통신하는 글로벌 리전__ 제공

네이버 클라우드 플랫폼 라인업
--
라인업 사진 필요


네이버 클라우드 플랫폼 Compute 상품
--

- 기본적인 서버를 생성하고 관리하는 상품
    - 서비스 규모와 사용목적에 적합한 성능의 서버를 선택할 수 있도록 다양한 서버 타입 제공
    - 일반적인 2vCPU 상품부터 High Memory 서버, VDS(Virtual Dedicated Server), HPC(High Performance Computing ), GPU 등 다양한 상품 라인업이 준비
    - 네이버 클라우드 플랫폼 체험용 서버인 마이크로 서버 제공

- 요금 구성
    - 컴퓨팅(CPU, 메모리), 네트워크(outbound), 스토리지 요금이 발생
    - 서버 정지 시 컴퓨팅, 네트웍 요금은 발생하지 않으나 스토리지 비용 발생 (Micro, Compact, Standard)
    - 서버 정지시 표준 요금이 적용되는 서버 (High Memory서버, VDS, GPU 서버)

- SSD, HDD 디스크 타입 제공
    - IO 퍼포먼스 차별화
    - SSD 사용 시 최대 IOPS (Input/Output Operations Per Second) 보장

준비 사항
--

클라우드 서비스를 진행하기 전, 

네이버 클라우드 플랫폼 Compute
--

### 1. ACG, Anti-Virus

- ACG(Access Control Group)
    - 서버 방화벽 역할, 네이버 클라우드 플랫폼은 Inbound에 대해서만 룰 설정 가능 (default rule은 Inbound deny, Outbound Allow)
    - Default ACG와 Custom ACG로 구분
    - 프로토콜은 TCP, ICMP 중 선택, 접근 소스는 IP (CIDR), ACG Group 설정 가능
    - 단일 서버는 최대 5개의 ACG를 적용할 수 있음. 단일 ACG는 최대 100개의 rule 설정 가능
    - ACG에 대한 un-mapping 불가

- Anti-Virus
    - windows OS에 한하여 Office Scan 무료 제공
    - 리눅스의 경우, 별도 비용 발생

- 기타 보안/관리 사항
    - Security Monitoring (IDS, IPS, WAF, DDos) 이용 추가 보안 및 사용자가 설정한 임계치 기반 모니터링 시스템 구성 가능 

### 2. 추가 스토리지 구성

- OS 영역인 50GB에 추가로 더 큰 로컬 스토리지 용량이 필요할 경우 사용
    - 스토리지 당 10GB에서 2TB까지 생성할 수 있음
- 스토리지 추가 개수 제한
    - 단일 서버에 최대 16개의 추가 스토리지를 추가할 수 있음
- 스토리지 볼륨을 2TB 이상 사용하고자 하는 경우
    - Linux는 LVM, Windows는 동적 디스크 할당을 통해 여러 개의 디스크를 하나의 볼륨으로 묶을 수 있음
- 스토리지 Detach / Attach 기능 제공
    - 서버에 연결된 디스크를 다른 서버로 옮길 수 있다.
- 디스크 크기 변경 기능 적용
    - 사용 중인 디스크의 크기가 부족할 경우 필요한 크기로 확장

### 3. Auto scaling

- 클라우드의 장점 중 하나는 유연한 인프라 확장
    - 인프라 확장의 높은 자유도를 이용하여 인프라 비용을 최적화하고 이벤트에 대응
    - 사용자가 정의한 주기(스케줄링), 사용자가 설정한 메트릭(모니터링), 사용자 요청(온디맨드)에 따라 서버를 자동 생성, 삭제 진행

- Autoscaling 설정
    - 1. Launch Configuration
        - 1.1 이름으로 구분되므로 한 계정 내 유일
        - 1.2 액션의 대상이 되는 서버의 기본 템플릿 (이미지, 서버타입, ACG등)
        - 1.3 베이스 이미지는 퍼블릭 이미지, 커스텀 이미지인 내 서버 이미지 사용 가능
    - 2. Autoscaling Server Group
        - 2.1 Scaling, Management 액션을 위한 논리적 그룹
        - 2.2 minSize <= desiredCapacity <= maxSize 대소 관계 유지
    - 3. Group Event Setting
        - 3.1 액션의 기준이 되는 모니터링 매트릭 설정
    
### 4. Kubernetes Service

- 완전 관리형 Kubernetes Cluster 제공
    - 컨테니어의 배포(scheduling), 운영(HA, Failover), 확장(Scaling)을 자동화하기 위한 플랫폼
    - Control Plane 설치, 운영에 대한 고민 없이, 사용자는 Container가 구동되는 Worker Node에 대한 관리만 하면 됨
    - Container Registry, Load Balancer 등 네이버 클라우드 플렛폼 다른 서비스와 통합하여 사용 가능

Lab 1
--

- 서버 생성
    - 서버 생성
    - 서버 생성시 스크립트를 통해 웹서버 설치 자동화 구현
    - 10GB 디스크 추가
- 공인 ip 부여
- 내 서버 이미지로 서버 추가

Lab 1: 서버 생성 및 접속
--

`All Product > Server > ACG 선택 > +ACG 생성 선택` 


네이버 클라우드 플랫폼 Networking
--

- 외부와의 통로, 내부와의 통로 뿐만 아니라 DNS, CDN과 같은 다양한 서비스를 제공
    - 유입되는 네트워크 트래픽을 백엔드 서버로 분기하기 위한 Load Balancer
    - 네임서버 제공하는 DNS
    - 요청 사용자에 가장 가까운 엣지(edge) 서버에서 케싱 된 파일을 제공하여 원본 부하를 낮출 수 있는 CDN 상품
    - Site-to-Site 연결을 위한 IPSEC VPN 상품
    - 비공인IP를 가진 다수의 서버에게 단일 공인IP를 이용한 외부 접속을 제공하는 NAT Gateway 제공
    - 글로벌 네트워크 트래픽을 백엔드 서버로 분기하기 위한 Global Route Manager

### Load Balancer

- Load Balancer란?
    - 부하 분산을 위해 서버 앞단에서 트래픽을 분산
    - 소프트웨어 방식인 HAProxy를 이용하여 로드밸런싱
    - 기본적으로 로드밸런서 하나를 생성하면 HAProxy 서버 2개가 도메인에 바인딩 되어 제공
    - 로드밸런서는 최대 6만 TPS(Transaction Per Second)까지 보장

- 연결 방식
    - Proxy 방식
    - 따라서, 서버에서는 클라이언트 IP를 확인하고자 할 때 별도의 설정이 필요
    - 클라이언트 IP를 확인하고자 할 때, SSL/TCP 일 경우에는 Proxy protocol 사용 HTTP/HTTPS일 경우 X-Forwarder 사용

- 로드밸런싱 알고리즘
    - Round Robin : 클라이언트에서 요청이 오면 서버에 1개씩 분배하는 방식
    - Least Connection : 클라이언트 연결이 제일 적은 서버에게 새로운 커넥션을 분배하는 방식
    - Source IP Hash : 클라이언트 IP에 대한 해시테이블을 가지고 클라이언트 IP에 매핑되는 서버에 새로운 커넥션을 분배하는 방식

- 생성 후 설정 가능 내용
    - HTTP Keep Alive On / Off (Default: Off)
        - 웹서버의 기본 로직은 서버에 URL 리퀘스트를 던지면 Reply를 전송하고 서버에서 커넥션을 끊어버림
        - 따라서 Reply를 던진 후, 커넥션을 얼마동안 끊지 않을 지에 대한 설정을 가능하게 하는 옵션

    - Connection idle Time (Default: 60Sec)