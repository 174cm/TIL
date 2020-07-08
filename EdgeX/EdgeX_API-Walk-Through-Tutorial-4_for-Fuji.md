EdgeX API Walk Through Tutorial for Fuji 2
==

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

6. Register Device Service
7. Provision a Device
8. Calling commands
9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __6. Register Device Service__ 를 진행합니다. 

## 6. Register Device Service

Core data 및 metadata에서 Device Service에 의해 참조 정보가 설정되면 Device Service는 EdgeX에서 자신을 등록하거나 정의할 수 있습니다. 

6.1 Register with Core Configuration and Registration
--

- APIs Core Services Configuration and Registry 참조: [https://fuji-docs.edgexfoundry.org/Ch-Configuration.html]

Device Service의 등록 과정 중 실제로 EdgeX 마이크로 서비스는 Core Configuration 및 Registration 입니다. 이 프로세스에서 마이크로 서비스는 해당 위치를 Config / Regist 마이크로 서비스에 제공하고 이 Center Service에서 New / latest 구성 정보를 선택합니다. 이 데모에서는 실제 장치가 없어서 마이크로 서비스 교환은 다루지 않습니다.

6.2 Create the Device Service
--

- APIs Core Services Metadata 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml]

Device Service는 Core metadata에서 자체 인스턴스를 작성해야 합니다. 이 등록에서 Device Service는 이미 Core metadata인 Device Service의 Addressable과 연관됩니다. 다음의 POST방식을 통해 Core metadata를 가지고 Device Service를 만듭니다. 

```
POST to http://localhost:48081/api/v1/deviceservice
```
```
BODY: {"name":"camera control device service","description":"Manage human and dog counting cameras","labels":["camera","counter"],"adminState":"unlocked","operatingState":"enabled","addressable":
{"name":"camera control"}}
```

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)