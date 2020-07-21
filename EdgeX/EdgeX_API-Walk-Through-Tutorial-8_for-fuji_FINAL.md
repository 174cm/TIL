EdgeX API Walk Through Tutorial 8 for Fuji FINAL
==

EdgeX API Walk Through Tutorial for Fuji 8 FINAL

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

10. Exporting device data
11. Building own solution

여기서는 __10. Exporting device data과 11. Building own solution__ 를 진행합니다. 

## 10. Exporting device data

이제 카메라 장치에서 보낸 데이터는 Core Data로 전달됩니다. Enterprise system이나 로 데이터를 어떻게 전송할 수 있을까요? 엣지 분석 시스템에서 해당 데이터를 어떻게 사용하여 장치에서 동작시킬 수 있을까요? 센서 / 장치 데이터를 EdgeX에 제공되는대로 수신하려면 `Export` Client로 등록해야 합니다. 

10.1 Export Clients
--

기본적으로 Rules Engine은 Export Client 서비스의 클라이언트로 자동 등록되며 장치에서 보내는 모든 event / reading을 자동으로 수신합니다. 기존의 모든 Export Client를 보려면 ExportClientMicro 서비스에서 목록을 요청할 수 있습니다. 

```
GET to http://localhost:48071/api/v1/registration
```
Export Client의 응답은 등록된 클라이언트 세부 정보의 목록입니다. 이 경우 Rules Engine만 등록됩니다. 

```json
[
    {
        "id": "b8717d65-3ebf-4ccc-b157-5aa1711cc312",
        "created": 1594023456838,
        "modified": 1594023456838,
        "origin": 0,
        "name": "EdgeXRulesEngine",
        "addressable": {
            "id": "161f1f1a-2643-4149-bf9b-c9babf607c12",
            "name": "EdgeXRulesEngineAddressable",
            "protocol": "ZMQ",
            "method": "POST"
        },
        "format": "SERIALIZED",
        "filter": {},
        "encryption": {},
        "enable": true,
        "destination": "ZMQ_TOPIC"
    },
]
```

10.2 Register an Export Client
--

EdgeX 데이터를 수신하기 위해 새 클라이언트를 등록하려면 먼저 HTTP REST 호출을 수신할 수 있는 클라이언트 또는 EdgeX에서 메시지를 수신할 수 있는 MQTT항목을 설정해야 합니다. 이 데모에서는 EdgeX Event/Read 데이터를 수신할 수 있도록 설정된 MQTTTopic 기반의 데이터가 있다고 가정해 보겠습니다. 이 MQTT endpoint를 등록하여 모든 Event / Read 데이터를 JSON 형식으로 수신하지만, 암호화하려면 새 EdgeX 클라이언트를 작성하도록 Export Client를 요청해야 합니다. 

```json
POST to http://localhost:48071/api/v1/registration
```

```json
BODY: {"name":"MyMQTTTopic","addressable":{"name":"MyMQTTBroker","protocol":"TCP","address":"tcp://m10.cloudmqtt.com","port":15421,"publisher":"EdgeXExportPublisher","user":"hukfgtoh","password":"mypass","topic":"EdgeXDataTopic"},"format":"JSON","encryption":{"encryptionAlgorithm":"AES","encryptionKey":"123","initializingVector":"123"},"enable":true,"destination":"MQTT_TOPIC"}
```
- EdgeX Export Client log  
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker_logs_edgex-export-client.PNG)

REST주소에 대한 Addressable은 요청에 의해 기본 제공됩니다.

이제 새 Event가 Core Data에 게시되면 Export Distro 서비스는 암호화된 JSON 형식의 EVENT / READ 데이터를 MQTT 클라이언트에 전송하려고 시도합니다. 실제로 메시지를 받도록 MQTT Topic을 설정하지 않은 경우, Export Distro는 내용을 전달하지 못하고 오류가 발생합니다. 수신 MQTT Topic이 존재하지 않더라도 Export Distro log를 확인하여 시도가 이루어졌고 EdgeX Export service가 제대로 동작하는지 확인할 수 있습니다. 

- MQTT Out bound Service Activator: MQTT Broker로 전송된 메시지
```
Addressable [name=MyMQTTBroker, protocol=TCP, address=tcp://m10.cloudmqtt.com, port=15421, path=null, publisher=EdgeXExportPublisher, user=hukfgtoh, password=mypass, topic=EdgeXDataTopic, toString()=BaseObject [id=null, created=0, modified=0, origin=0]] : 596283c7e4b0011866276e9
```

- EdgeX Export Distro log  
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker_logs_edgex-export-distro.PNG)