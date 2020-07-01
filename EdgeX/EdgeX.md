EdgeX Foundry
==
Edge?
--
Edge는 데이터 소스와 더 가까운 물리적인 위치를 지칭하는 말로, 바로 그 위치에서 컴퓨팅이 가능하다. 
엣지 컴퓨팅은 (데이터 소스가 되는) 기계와 더 가까운 위치에서 데이터를 분석하고 통찰력을 얻을 수 있게 해주며, 이는 네트워크 가장자리에 위치한 기기에서 컴퓨팅을 지원하는 것이다. 

EdgeX foundry Architectural Tenets
--
EdgeX는 전체 아키텍처를 다음과 같은 원칙으로 고안했다.

- EdgeX는 다음과 관련하여 플랫폼에 독립적이어야 한다.
    - 하드웨어 (x86, ARM)
    - OS (MAC, Linux, Windows)
    - 배포 (Edge, Gateway, fog, cloud, etc.)
        - Fog Computing: 하늘에 떠 있는 구름(Cloude)과 대비되는 언어로 데이터를 하늘처럼 멀리 있는 클라우드까지 보낼 필요 없이, 가까이에 있는 __지상의 안개(Fog)__ 에서 해결하자는 비유적인 의미.
        - Edge Computing: 중앙의 클라우드 데이터센터보다 물리적으로 가까운 곳에 위치한 __가장자리(Edge)__ 에서 데이터를 처리, 수집, 분석하는 것. 클라우드 컴퓨팅의 진화로 생각해도 무방함.
        - Cloudlet: 클라우드와 작은 것을 의미하는 접미사 let의 합성어로, 엣지 컴퓨팅을 클라우드렛이라고 부르기도 함.
    - 배포 / 오케스트레이션
        - Docker, Snaps, K8s, roll-your-own, ...)
            - Docker: 컨테이너 기반의 오픈소스 가상화 플랫폼
                - 컨테이너: __격리된 공간에서 프로세스가 동작하는 기술__, 이미지를 실행한 상태라고 볼 수 있고 추가되거나 변하는 값은 컨테이너에 저장됨.
                - 이미지: __컨테이너 실행에 필요한 파일과 설정값 등을 포함하고 있는 것__, 상태값을 가지지 않고 변하지 않음.
            - K8s(kubernetes): 쿠버네티스는 컨테이너화 된 워크로드와 서비스를 관리하기 위한 이식할 수 있고 확장 가능한 오픈소스 플랫폼으로 선언적 구성과 자동화를 모두 지원함. 
        ###### 오케스트레이션(Orchestration): 컴퓨터 시스템과 애플리케이션, 서비스의 자동화된 설정, 관리 조정을 의미, 복잡한 태스크와 워크플로우를 보다 쉽게 관리할 수 있도록 도움.
- EdgeX는 매우 유연해야한다.
    - 플랫폼의 모든 부분은 다른 마이크로 서비스 또는 소프트웨어 구성 요소로 업그레이드, 교체 또는 확장 될 수 있다.
    - 장치 기능 및 사용 사례에 따라 서비스 확장 및 축소 허용
- EdgeX는 저장 및 전달 기능을 제공해야 한다.
    - 분리 / 원격 에지 시스템을 지원
    - 간헐적인 연결을 처리 및 지원
- EdgeX는 "지능"을 지원하고 촉진하여 가장자리에 더 가까이 이동해야 한다.
    - 작동 지연 문제
    - 대역폭 및 저장 문제
    - 원격 관심사 운영
- EdgeX는 갈색 및 녹색 장치, 센서 필드 배치를 지원해야 한다.
- EdgeX는 안전하고 쉽게 관리해야 한다. 

Apache 2 License
--
EdgeX는 Apache Foundation의 지원을 받는 Apache 2 라이센스에 따라 배포된다. 

- EdgeX에서 사용하는 language는 __Golang__ 을 사용.
    - Golang: 구글에서 개발한 프로그래밍언어로, C++의 복잡함이 싫어서 개발함. 
        - 장점: 
         1. 컴파일 언어지만, 컴파일러의 컴파일 속도가 매우 빨라 인터프리터 언어처럼 쓸 수 있음. 
         2. 접근하기 쉽고, 코드가 간결하며, 높은 성능을 낼 수 있음.
         3. 풍부한 라이브러리에 막강한 기능을 쉽게 구현 가능

EdgeX Quick Starter
--
- 1. 목표: 가능한 간단하게 장치에서 클라우드까지 작동하는 IoT Edge Stack을 얻는 것.
    - 1.1 설정: Docker 이미지를 사용하여야 하므로 다음을 설치하여야 한다. 
        - docker (https://docs.docker.com/get-docker/)
        - docker compose (https://docs.docker.com/compose/install/)
            - docker 설치하려고 봤더니, Windows10 x64 Pro, Enterprise 또는 Education (build 15063 이상)이 필요하다. (나는 Windows10 Home > 포맷 필요)
            - CPU 가상화 기능이 활성화되어 있어야 한다.
            - Microsoft Hyper-V가 필요하다.




Reference
--
- EdgeX docs (https://docs.edgexfoundry.org/1.2/)
- Edge computing (https://www.gereports.kr/edge-computing-door-iot-data-kingdom/)
- 오케스트레이션 (https://www.redhat.com/ko/topics/automation/what-is-orchestration)
- Golang wiki (https://namu.wiki/w/Go(%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EC%96%B8%EC%96%B4)?from=golang)
- 스마트팩토리 Cloud Edge (https://blog.lgcns.com/2028)
- 쿠버네티스 (https://kubernetes.io/ko/docs/concepts/overview/what-is-kubernetes/)
- 도커 (https://subicura.com/2017/01/19/docker-guide-for-beginners-1.html)
- EdgeX Quick Starter (https://fuji-docs.edgexfoundry.org/Ch-QuickStart.html)
- 도커 설치 (https://luckygg.tistory.com/165)