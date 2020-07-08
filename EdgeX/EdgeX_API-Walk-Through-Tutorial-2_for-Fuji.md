EdgeX API Walk Through Tutorial for Fuji 2
==

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

4. Defining Device Service
5. Register Device Service
6. Provision a Device
7. Calling commands
8. Sending events & reading data
9. Exporting device data
10. Building own solution

여기서는 __4. Defining Device Service__ 를 진행합니다. 

## 4. Defining Device Service

EdgeX에서 새 장치의 서비스를 시작하면 아직 EdgeX에 알려지지 않은 하나 이상의 장치 및 장치 서비스를 관리하기 위해 수행해야 할 작업이 있습니다. 

- 장치 서비스 및 장치에 대한 __참조 정보__ 설정
- 장치 서비스 자체를 나머지 EdgeX에게 알림
- 장치 서비스가 EdgeX로 관리할 장치를 *__프로비저닝(Provisioning)__

참조 정보에는 1. 장치 및 장치 서비스의 주소 (__Addressable__) 2. 장치에서 사용하는 새 측정 단위(__Value Descriptor__) 설정과 같은 항목이 포함됩니다. 

##### *프로비저닝: 사용자의 요구에 맞게 시스템 자원을 할당, 배치, 배포해 두었다가 필요 시 시스템을 즉시 사용할 수 있는 상태로 미리 준비해 두는 것을 말합니다. 

4.1  참조 정보 생성 
--

EdgeX는 장치에서 데이터 수집을 시작하거나 작동 명령을 장치로 보내기 전, 장치 및 장치 서비스에 대해 알아야 할 많은 배경정보가 있습니다. 예를 들어, 카메라 장치는 사람과 개의 수를 보고하려 합니다. EdgeX로 번호를 보내면 EdgeX는 해당 번호가 무엇을 나타내는지 또 어디에서 왔는지 전혀 알 수 없습니다. 또한, 누군가 무언가가 카메라에 명령을 보내려 한다면, 카메라가 네트워크상의 위치와 같은 추가 정보없이 카메라에 도달하는 방법을 알 수 없습니다. 
이 참조 정보는 장치 서비스가 처음 나타날 때 EdgeX에서 정의해야하는 정보입니다. 

4.2 Addressables
--

* Core Matadata API RAML 참조: [APIs Core Services Matadata](https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml)

장치 서비스는 종종 Core Matadata Micro Service로 적어도 두 개의 Addressable object를 설정합니다. Addressable은 물리적 주소를 지정하는 유연한 EdgeX 객체입니다. 이 경우 장치 서비스와 장치 (카메라)의 물리적 주소입니다. 

명명된 MQTT 파이프 도는 다른 프로토콜의 엔드 포인트에 대해 Addressable을 작성할 수 있지만, 다음의 예제는 Device Service와 Device 모두 HTTP REST 호출을 통해 도달할 수 있다고 가정합니다. 

- Core Metadata를 두 번 호출
    
    ```
    POST to http://localhost:48081/api/v1/addressable
    ```

    ```
    BODY: {"name":"camera control","protocol":"HTTP","address":"172.17.0.1","port":49977,"path":"/cameracontrol","publisher":"none","user":"none","password":"none","topic":"none"}
    ```

- Device Addressable (Camera)

    ```
    POST to http://localhost:48081/api/v1/addressable
    ```
    ```
    BODY: {"name":"camera1 address","protocol":"HTTP","address":"172.17.0.1","port":49999,"path":"/camera1","publisher":"none","user":"none","password":"none","topic":"none"}
    ```

Addressable의 경우 고유 이름을 제공해야 합니다. 

- How to use?

이제 우리는 Tutorial 1에서 설치한 POSTMAN을 이용합니다. 

1. POST 방식으로 설정
2. URL 입력
3. Body로 이동
4. raw 클릭
5. Body의 내용 입력

![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/Tutorial/Tutorial2/Addressable.png)

- API 호출 결과

    ```
    9dee5c7d-320b-4ce5-af30-1f9c9a5bcaad
    ```

4.3 Value Descriptors
--

* Core Core-Data API RAML 참조: [APIs Core Services Core Data](https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml)

Device Service는 장치를 대신하여 전송할 데이터 유형에 대해 EdgeX에게 알려야합니다. 숫자 5가 주어진다면 이것은 어떤 의미인지 알 수 있어야 합니다. 이것이 사람의 수인지, 개의 수인지, 스캔 깊이인지 알 수 없습니다. EdgeX에서 Value Descriptor는 장치와 주고받는 모든 데이터에 대한 컨텍스트 및 측정 단위를 제공합니다. 측정 단위, 최소값 및 최대값 값을 화면에 표시할 때 표시하는 방법 등의 값을 설명합니다. 

이 데모에서는 사람의 수, 개의 수, 스캔의 깊이, 스냅 샷 지속 시간의 4가지 Value Descriptor가 필요합니다. 

__주의!__ Addressable은 Core-Metadata Service(48081 port)와 다르게 여기서는 Core-Data (__48080 port__)를 사용합니다. 

- 사람의 수
    ```
    POST to http://localhost:48080/api/v1/valuedescriptor
    ```
    ```
    BODY:  {"name":"humancount","description":"people count", "min":"0","max":"100","type":"I","uomLabel":"count","defaultValue":"0","formatting":"%s","labels":["count","humans"]}
    ```
- 개의 수
    ```
    POST to http://localhost:48080/api/v1/valuedescriptor
    ```
    ```
    BODY:  {"name":"caninecount","description":"dog count", "min":"0","max":"100","type":"I","uomLabel":"count","defaultValue":"0","formatting":"%s","labels":["count","canines"]}
    ```
- 스캔 깊이
    ```
    POST to http://localhost:48080/api/v1/valuedescriptor
    ```
    ```
    BODY:  {"name":"depth","description":"scan distance", "min":"1","max":"10","type":"I","uomLabel":"feet","defaultValue":"1","formatting":"%s","labels":["scan","distance"]}
    ```
- 지속 시간
    ```
    POST to http://localhost:48080/api/v1/valuedescriptor
    ```
    ```
    BODY:  {"name":"duration","description":"time between events", "min":"10","max":"180","type":"I","uomLabel":"seconds","defaultValue":"10","formatting":"%s","labels":["duration","time"]}
    ```

카메라와 통신할 때 오류가 발생할 수 있습니다. 이 경우를 대비해 다섯번째 Value Descriptor가 작성됩니다. 

- 카메라 에러
    ```
    POST to http://localhost:48080/api/v1/valuedescriptor
    ```
    ```
    BODY:  {"name":"cameraerror","description":"error response message from a camera", "min":"","max":"","type":"S","uomLabel":"","defaultValue":"error","formatting":"%s","labels":["error","message"]}
    ```

Addressable과 마찬가지로 Value Descriptor 또한 고유의 이름을 가져야 합니다. 

-  현재 정의된 모든 Value Descriptor 확인
    ```
    GET to http://localhost:48080/api/v1/valuedescriptor 
    ```

    ![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/Tutorial/Tutorial2/GetValueDescriptor.png)

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)