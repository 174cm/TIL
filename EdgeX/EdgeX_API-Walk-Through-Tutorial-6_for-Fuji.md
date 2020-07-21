EdgeX API Walk Through Tutorial-6 for Fuji
==

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

8. Calling commands
9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __8. Calling commands__ 를 진행합니다. 

## 8. Calling Commands

장치 프로파일 (카메라 모니터 프로파일)에는 해당 유형의 모든 장치에서 정보를 가져오고 입력하기위한 많은 명령이 포함되어 있습니다. 또한, 장치를 프로비저닝 할 때 장치 (여기서는 countcamera1)가 장치 프로파일 (카메라 모니터 프로파일)과 연관되어 있음을 알고 있어야 합니다. 

8.1 List the Commands
--

~~- APIs Core Services Command 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/core/command/raml/core-command.raml]~~ (해당 루트가 삭제되었습니다.)

모든 설정이 완료되면 디바이스(countcamera1)와 관련된 명령 목록에 대한 Core Command micro service를 요청할 수 있습니다. 

```
GET to http://localhost:48082/api/v1/device/name/countcamera1
```

8.2 Check the Value Descriptors
--

- APIs Core Services Core Data 참조: [https://github.com/edgexfoundry/edgex-go/blob/master/api/raml/core-data.raml]

Value Descritor가 CoreData에 있는지 확인합니다. CoreData에는 총 5개의 Value Descriptor가 있어야 합니다. Value Descriptor는 CoreData에 저장되지만 MetaData에 참조됩니다. 이는 장치에서 나오는 데이터가 CoreData로 전송될 때 CoreData가 관련된 ValueDescriptor Parameter(예:min, max 등)에 대해 들어오는 값을 검증해야 하지만, 검증을 수행하기 위해 CoreMetadata로 이동할 필요가 없기 때문입니다. 데이터를 CoreData로 가져오는 것은 EdgeX의 핵심 기능이며 REST를 추가로 요청할 필요 없이 가능한 빨리 완료해야 합니다. 

```
GET to http://localhost:48080/api/v1/valuedescriptor
```

작업을 진행하는 동안 아직 CoreData로 전송된 데이터가 없는지 확인합니다. DeviceService 및 Device는 사용자에 의해 전적으로 수동으로 구동되는 이 데모에 포함되므로 센서 데이터가 아직 수집되지 않은 상태여야 합니다. CoreData의 이벤트 수를 요청하여 이 이론을 테스트할 수 있습니다. 

```
GET to http://localhost:48080/api/v1/event/count
```

8.3 Execute a Command
--

이 과정에서 실제로 장치 또는 장치서비스가 없지만 EdgeX는 이를 감지할 수 없습니다. 따라서, 수행한 모든 구성 및 설정을 사용하여 EdgeX에 검색 깊이를 설정하거나 카메라ㅔ 스냅 샷 기간을 설정하도록 요청할 수 있으며 EdgeX가 작업을 수행하려 시도합니다. 장치나 장치서비스가 없어서 결론적으로는 EdgeX가 오류로 응답합니다. 그러나 log file을 통해 Core Command micro service로 이루어진 명령을 볼 수 있으며, 가상 카메라를 관리하는 가상 장치 서비스의 해당 명령을 호출하려고 시도합니다. 

예를 들어, countcamera1의 scan depth를 설정하는 명령을 실행합니다. scan depth를 설정하기 위한 요청을 시작하는 첫번쨰 작업은 명령어의 URL을 `PUT`으로 가져오거나 장치에 새 scan depth를 설정하는 것입니다. 
다음의 API를 사용해 장치 이름별로 명령 목록을 요청합니다. 

``` 
GET to http://localhost:48082/api/v1/device/name/countcamera1
```
JSON 결과를 확인합니다. 여기서 우리는 `PUT`명령을 사용하여야 하기에 PUT URL을 찾습니다. 

``` JSON
{
    "id": "1665b5c8-86e6-4af9-8e28-994295d8a453",
    "name": "countcamera1",
    "adminState": "UNLOCKED",
    "operatingState": "ENABLED",
    "lastConnected": 0,
    "lastReported": 0,
    "labels": [
        "camera",
        "counter"
    ],
    "location": "",
    "commands": [
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
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/8188aab0-80f2-4b1f-8774-0af4f6f68b5e"
            },
            "put": {
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/8188aab0-80f2-4b1f-8774-0af4f6f68b5e"
            }
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
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/44645d73-8f75-4f6e-808c-b24ddd12fff2"
            },
            "put": {
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/44645d73-8f75-4f6e-808c-b24ddd12fff2"
            }
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
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/b233ef4d-79ad-4023-8f77-27992ae8cedc"
            },
            "put": {
                "path": "/api/v1/devices/{deviceId}/scandepth",
                "parameterNames": [
                    "depth"
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/b233ef4d-79ad-4023-8f77-27992ae8cedc"
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
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/9c025b6d-d498-405a-9c28-a8e174e1be0e"
            },
            "put": {
                "path": "/api/v1/devices/{deviceId}/SnapshotDuration",
                "parameterNames": [
                    "duration"
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/9c025b6d-d498-405a-9c28-a8e174e1be0e"
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
                ],
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/f7195074-bd98-4183-82ee-d6ef089520e7"
            },
            "put": {
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/f7195074-bd98-4183-82ee-d6ef089520e7"
            }
        }
    ]
}
```

우리가 찾은 PUT URL은 다음과 같습니다. 

``` JSON
   "put": {
                "url": "http://edgex-core-command:48082/api/v1/device/1665b5c8-86e6-4af9-8e28-994295d8a453/command/8188aab0-80f2-4b1f-8774-0af4f6f68b5e"
            }
```

이 URL을 POSTMAN에 복사하고 PUT 명령을 입력합니다. 해당 요청의 Parameter로 새 depth를 사용하여 core command에서 해당 URL에 PUT을 지정합니다.

```
PUT to http://localhost:48082/api/v1/device/<system specific device id>/command/<system specific command id>
```

```
BODY:  {"depth":"9"}
```

다시 말하지만, 실제로 장치나 장치서비스가 없기 때문에 CoreCommand는 `HTTP 502 Bad Gateway` 오류로 응답합니다. 하지만, log 출력을 확인하면 Core Command micro service가 요청을 수신하고 존재하지 않는 장치서비스를 호출하여 작동 명령을 발행하려 했음을 증명합니다.

```
docker logs edgex-core-command
```
- 명령을 사용하기 전
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker_logs_edgex-core-command_1.PNG)

- 명령을 사용한 후
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker_logs_edgex-core-command.PNG)

명령을 사용한 후, INFO와 ERROR가 추가된 것을 확인할 수 있습니다. 

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)


