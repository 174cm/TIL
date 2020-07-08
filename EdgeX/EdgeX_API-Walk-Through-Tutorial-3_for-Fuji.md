EdgeX API Walk Through Tutorial for Fuji 3
==

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 0.7

목차
--

4. Defining Data
5. Defining Device 
6. Register Device Service
7. Provision a Device
8. Calling commands
9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __5. Register Device__ 를 진행합니다. 

## 5. Defining Device 

장치 프로파일은 템플릿 또는 장치의 유형 또는 분류로 생각할 수 있습니다. 장치 유형, 장치가 제공하는 데이터 및 명령 방법에 대한 일반적인 특성은 모두 장치 프로파일에 제공됩니다. 다음의 링크는 장치 프로파일 및 그 목적에 대한 자세한 정보를 제공합니다.

5.1 Adding Device Profile
--

* Core Matadata API RAML 참조: [APIs Core Services Matadata](https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml) 

가상의 장치 서비스는 사람 / 개의 숫자만 카운팅하므로 모니터링 카메라 장치 프로파일을 만들기 위해 POST 요청을 한 번만하면 됩니다. 장치 프로파일은 종종 YAML로 표시되므로 아래의 장치 프로파일 파일로 multi-part form-data POST를 작성하여 카메라 모니터 프로파일을 작성하여야 합니다. 

```
POST to http://localhost:48081/api/v1/deviceprofile/uploadfile
```
- 헤더: 없음
- 양식 데이터:  
    - key: "file"
    - value: [EdgeX_CameraMonitorProfile](https://fuji-docs.edgexfoundry.org/_downloads/EdgeX_CameraMonitorProfile.yml) 

이 단계에서는 Postman에서 "File" 유형의 "file"이라는 Key와 함께 form-data POST 형식을 사용하여야 합니다. 이를 위해 __EdgeX_CameraMonitorProfile__ 을 다운로드하여 사용하여야 합니다. 사용 방법은 다음과 같습니다. 

![image](https://fuji-docs.edgexfoundry.org/_images/EdgeX_WalkthroughPostmanFile.png)

각 프로파일에는 설명, 제조업체, 모델 및 레이블 모음과 함께 고유이름이 있어 특정 프로파일에 대한 쿼리를 지원합니다. 이들은 비교적 간단한 속성입니다. 

5.2  Understanding Command
-- 

장치 프로파일은 프로파일을 준수하는 모든 장치와 통신하는 방법을 정의합니다. 특히, 장치 서비스를 통해 장치로 보낼 수 있는 명령을 정의합니다. 명령의 이름은 get (장치에서 데이터를 검색하기 위해) 또는 put (장치로 데이터를 보내기 위해) 또는 둘 다를 갖습니다. 각 명령은 단일 get 및 단일 put을 가질 수 있습니다. get과 put은 모두 선택 사항이지만 적어도 하나의 get 또는 적어도 하나의 put 없이 Command를 갖는 것은 의미가 없습니다. 명령의 이름은 해당 프로필에 대해 고유해야 합니다. 다음은 EdgeX_CameraMonitorProfile의 일부입니다. 

```
  - 
    name: ScanDepth
    get:
        path: "/api/v1/devices/{deviceId}/scandepth"
        responses:
          -
            code: "200"
            description: "Get the scan depth"
            expectedValues: ["depth"]
          -
            code: "503"
            description: "service unavailable"
            expectedValues: ["cameraerror"]    
    put:
        path: "/api/v1/devices/{deviceId}/scandepth"
        parameterNames: ["depth"]
        responses:
          - 
            code: "204"
            description: "Set the scan depth."
            expectedValues: []
          -
            code: "503"
            description: "service unavailable"
            expectedValues: ["cameraerror"]

  - 
    name: Counts
    get:
        path: "/api/v1/devices/{deviceId}/counts"
        responses:
          -
            code: "200"
            description: "Get the people and human counts"
            expectedValues: ["count","count"]
          -
            code: "503"
            description: "service unavailable"
            expectedValues: []
```

다음과 같이 ScanDepth Command는 get, put의 통신 방법을 정의하고 있으며 Counts Command처럼 get 통신 방법만 정의할 수도 있습니다. 

5.3 Understanding Command Gets and Puts
--

get 및 put은 각각 EdgeX에서 특정 명령을 get을 통해 호출하거나 서비스에 제공된 URL 주소를 호출하는데 사용되는 경로를 갖습니다. 예로 장치 서비스의 주소가 'http://abc:9999'이고 get 명령의 경로가 'foo'인 경우 EdgeX는 내부적으로 'http://abc:9999/foo'를 사용하는 것으로 인식합니다. 그런 다음 response ojbects(응답 객체)(또는, array response object 배열 응답 객체)를 가져와 넣습니다. __Get__ 에는 하나 이상의 응답 객체가 있어야 합니다. __Put__ 은 최소한 하나의 "good"응답을 가져야 하지만 Device Service가 응답해야하는 문제 또는 문제에 따라 여러 가지 오류 응답이 있을 수 있습니다. 각 응답은 Code (좋은 응답인지 오류 응답인지를 판단), description (응답에 있는 내용에 대한 사람이 읽을 수 있는 정보), expectedValues array로 구성됩니다. 실제적인 목적으로 이 Code는 일반적으로 200, 404 또는 503과 같은 HTTP 상태 코드입니다. 위 설명을 토대로 나타내면 다음과 같습니다.

```
responses:
          -
            code: "200"
            description: "Get the people and human counts"
            expectedValues: ["count","count"]
          -
            code: "503"
            description: "service unavailable"
            expectedValues: []
```

다음과 같이 code, description, expectedValues로 나타냅니다. 

responses에서 expectedValues은 expectedValues의 array입니다. get 명령에 대한 호출이 사람 및 개의 수의 데이터를 다시 리턴할 것으로 예상되면 응답의 예상 값은 [humancount, caninecount]입니다. Device Service에 대한 실제 호출이 이루어지면 서비스로부터의 response body는 Value Descriptor 이름이 key로 사용되는 맵에서 각 예상 값에 대한 값을 리턴해야합니다. 

```
{
  humancount: 5,
  caninecount: 2
}
```

사람과 개의 수를 예로 들어 사용하여 예상 값이 [humancount, caninecount]인 경우 서비스의 양호한 response body에는 위와 같은 맵이 포함됩니다. 

5.4 Understanding Command Parameters
--

Command는 Device에서 데이터를 가져오는 데 사용되는 만큼, Device Service를 통해 Device로 데이터를 보내는데 사용됩니다. 따라서, 모든 Command에는 해당 호출과 관련된 Parameter set이 있을 수 있습니다. Parameter data는 Parameter Call의 body에 추가됩니다. Parameter는 `parameterNames`Command array를 통해 정의됩니다. 

여기서도 array는 Value Descriptor name의 array일 뿐입니다. 각 Value Descriptor는 Command call의 Parameter로 제공할 정보의 이름과 유형을 정의합니다. 예를 들어, Command에 parameterNames array가 있는 경우, receiving command (수신 명령)는 Value Descriptor와 일치하는 값을 예상합니다. 

```
    name: Counts
    get:
        path: "/api/v1/devices/{deviceId}/counts"
        responses:
          -
            code: "200"
            description: "Get the people and human counts"
            expectedValues: ["count","count"]
          -
            code: "503"
            description: "service unavailable"
            expectedValues: []
```

다음의 예를 통해 parameter를 예상할 수 있습니다. 

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)