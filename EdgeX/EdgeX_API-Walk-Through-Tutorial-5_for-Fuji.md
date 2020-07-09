EdgeX_API-Walk-Through-Tutorial-5_for-Fuji
==

EdgeX API Walk Through Tutorial for Fuji 5

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

7. Provision a Device
8. Calling commands
9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __7. Provision a Device__ 를 진행합니다. 

## 7. Provision a Device

마지막 Setup 작업에서 Devcie Service는 종종 EdgeX에서 찾아서 관리 할 새 장치를 검색하고 Provisioning합니다. "종종"이라는 단어에 주목하여야 합니다. 모든 Device Service가 새로운 장치를 발견하거나 즉시 장치를 Provisioning하지는 않습니다. 장치 유형 및 장치 통신 방식에 따라 장치를 Provisioning하는 방법 / 시기를 결정하는 것은 Device Service에 달려 있습니다. 드문 경우이지만, 모든 것이 제자리에 있고 사람이 장치에 물리적으로 장치에 연결하는데 필요한 정보를 제공할 수 있게되면 사람이 Device Service에 대한 사람의 요청에 따라 Provisioning이 Trigger될 수 있습니다. 

7.1 Adding Device
--

- APIs Core Services Metadata 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml]

예제를 위해서 아래의 Core Metadata에 대한 호출은 Device Service가 이를 감지하고 일부 시작 프로세스의 일부로 장치를 Provisioning 한 것 처럼 사람과 개를 카운트하는 카메라를 Provisioning합니다. 장치를 만드려면, Device Profile (이름이나 ID)이나 Device Service (이름이나 ID)에 연결되어 있어야 합니다. 하나 이상이 포함된 프로토콜의 주소를 정의합니다. 

```
POST to http://localhost:48081/api/v1/device
```
```
BODY:  {"name":"countcamera1","description":"human and dog counting camera #1","adminState":"unlocked","operatingState":"enabled","protocols":{"camera protocol":{"camera address":"camera 1"}},"labels": ["camera","counter"],"location":"","service":{"name":"camera control device service"},"profile":{"name":"camera monitor profile"}}
```

7.2 Setup Test
--

Device Service 및 Device가 EdgeX에서 Setup / Provisioning 되었으므로 몇 가지 Micro Service API를 사용하여 구성이 올바르게 되었는지 확인합니다.

7.2.1 Device Service Check
--

- APIs Core Services Metadata 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml]

시작하려면 Core Meta-data를 통해 Device Service를 사용할 수 있는지 확인해야합니다. 

```
GET to http://localhost:48081/api/v1/deviceservice
```

연결된 Addressable은 Device Service와 함께 반환됩니다. Core Metadata에는 Device Service를 검색하기위한 추가 API가 많이 있습니다. 예를 들면, 레이블로 모든 장치 서비스를 찾는 것입니다. 이 경우 카메라 제어 장치 서비스와 연관된 레이블을 사용합니다.

```
GET to http://localhost:48081/api/v1/deviceservice/label/camera
```

7.2.2 Device Check
--

- APIs Core Services Metadata 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-metadata.raml]

모니터 카메라가 Core Metadata에 알려진 장치 중 하나인지 확인하여야 합니다. 

```
GET to http://localhost:48081/api/v1/device
```
연결된 Deviceprofile, Device Service, Addressable가 반환됩니다. 

아래의 명령어는 device를 찾는 다양한 방식을 보여줍니다. `profile의 name`으로도 찾을 수 있다는 것을 나타냅니다.  
```
GET to http://localhost:48081/api/v1/device/profilename/camera+monitor+profile
```
- return json

```json
[
    {
        "description": "",
        "id": "1665b5c8-86e6-4af9-8e28-994295d8a453",
        "name": "countcamera1",
        "adminState": "UNLOCKED",
        "operatingState": "ENABLED",
        "protocols": {
            "camera protocol": {
                "camera address": "camera 1"
            }
        },
        "labels": [
            "camera",
            "counter"
        ],
        "location": "",
        "service": {
            "created": 1594089713408,
            "modified": 1594089713408,
            "description": "Manage human and dog counting cameras",
            "id": "e98a3365-2fab-4a4a-86c2-3646862d34c2",
            "name": "camera control device service",
            "lastConnected": 0,
            "lastReported": 0,
            "operatingState": "ENABLED",
            "labels": [
                "camera",
                "counter"
            ],
            "addressable": {
                "created": 1594085467345,
                "modified": 1594085467345,
                "id": "5dc40b97-cf21-4000-adb0-f08bbcd94d48",
                "name": "camera control",
                "protocol": "HTTP",
                "address": "172.17.0.1",
                "port": 49977,
                "path": "/cameracontrol",
                "publisher": "none",
                "user": "none",
                "password": "none",
                "topic": "none",
                "baseURL": "HTTP://172.17.0.1:49977",
                "url": "HTTP://172.17.0.1:49977/cameracontrol"
            },
            "adminState": "UNLOCKED"
        },
        "profile": {
            "created": 1594086940289,
            "modified": 1594086940289,
            "description": "Human and canine camera monitor profile",
            "id": "57302932-d46d-4c8d-a3ae-c15eb53454a4",
            "name": "camera monitor profile",
            "manufacturer": "Dell",
            "model": "Cam12345",
            "labels": [
                "camera"
            ],
            "coreCommands": [
                {
                    "created": 1594086940248,
                    "modified": 1594086940248,
                    "id": "8188aab0-80f2-4b1f-8774-0af4f6f68b5e",
                    "name": "People",
                    "get": {
                        "path": "/api/v1/devices/{deviceId}/peoplecount",
                        "responses": [
                            {
                                "code": "200",
                                "description": "Number of people on camera",
                                "expectedValues": [
                                    "humancount"
                                ]
                            },
                            {
                                "code": "503",
                                "description": "service unavailable",
                                "expectedValues": [
                                    "cameraerror"
                                ]
                            }
                        ]
                    },
                    "put": {}
                },
                {
                    "created": 1594086940272,
                    "modified": 1594086940272,
                    "id": "44645d73-8f75-4f6e-808c-b24ddd12fff2",
                    "name": "Dogs",
                    "get": {
                        "path": "/api/v1/devices/{deviceId}/dogcount",
                        "responses": [
                            {
                                "code": "200",
                                "description": "Number of dogs on camera",
                                "expectedValues": [
                                    "caninecount"
                                ]
                            },
                            {
                                "code": "503",
                                "description": "service unavailable",
                                "expectedValues": [
                                    "cameraerror"
                                ]
                            }
                        ]
                    },
                    "put": {}
                },
                {
                    "created": 1594086940279,
                    "modified": 1594086940279,
                    "id": "b233ef4d-79ad-4023-8f77-27992ae8cedc",
                    "name": "ScanDepth",
                    "get": {
                        "path": "/api/v1/devices/{deviceId}/scandepth",
                        "responses": [
                            {
                                "code": "503",
                                "description": "service unavailable",
                                "expectedValues": [
                                    "cameraerror"
                                ]
                            }
                        ]
                    },
                    "put": {
                        "path": "/api/v1/devices/{deviceId}/scandepth",
                        "parameterNames": [
                            "depth"
                        ]
                    }
                },
                {
                    "created": 1594086940280,
                    "modified": 1594086940280,
                    "id": "9c025b6d-d498-405a-9c28-a8e174e1be0e",
                    "name": "SnapshotDuration",
                    "get": {
                        "path": "/api/v1/devices/{deviceId}/snapshotduration",
                        "responses": [
                            {
                                "code": "503",
                                "description": "service unavailable",
                                "expectedValues": [
                                    "cameraerror"
                                ]
                            }
                        ]
                    },
                    "put": {
                        "path": "/api/v1/devices/{deviceId}/SnapshotDuration",
                        "parameterNames": [
                            "duration"
                        ]
                    }
                },
                {
                    "created": 1594086940281,
                    "modified": 1594086940281,
                    "id": "f7195074-bd98-4183-82ee-d6ef089520e7",
                    "name": "Counts",
                    "get": {
                        "path": "/api/v1/devices/{deviceId}/counts",
                        "responses": [
                            {
                                "code": "200",
                                "description": "Get the people and human counts",
                                "expectedValues": [
                                    "count",
                                    "count"
                                ]
                            },
                            {
                                "code": "503",
                                "description": "service unavailable"
                            }
                        ]
                    },
                    "put": {}
                }
            ]
        }
    }
]
```

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)