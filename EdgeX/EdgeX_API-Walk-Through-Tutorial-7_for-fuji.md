EdgeX_API-Walk-Through-Tutorial-7_for-Fuji
==

EdgeX API Walk Through Tutorial for Fuji 7

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __9. Sending events & reading data__ 를 진행합니다. 

## 9. Sending events & reading data

사람과 개의 수를 세는 카메라는 사진을 찍고 숫자를 세어 데이터를 EdgeX로 보내기 시작합니다. 우리는 이 활동을 시뮬레이션할 것입니다. 이 섹션에서는 카메라의 장치 및 장치 서비스 인 것처럼 Core Data API를 호출합니다. 

9.1 Send an Event/Reading
--

데이터는 이벤트로서 Core Data에 보내집니다. 이벤트는 특정 시점에 Device(ID or Name으로 장치에 연결되어 있는)에서 센서 판독 값을 모은 것입니다. 이벤트의 읽기는 장치가 감지하고 읽기에 대한 컨텍스트를 제공하기 위해 __Value Descriptor(by name)__ 와 연관된 특정 값입니다. 따라서, 사람과 개의 수를 세는 카메라는 현재 모니터링중인 공간에 현재 5명과 3마리의 사람과 개가 있다고 판단할 수 있습니다. EdgeX vernacular(언어)에서 디바이스 서비스는 디바이스에서 이러한 감지된 값을 수신하면 두 개의 판독 값으로 이벤트를 작성합니다. 하나의 판독 값에는 Key / Value 쌍의 Human count가 포함되고 다른 하나의 판독 값에는 Key / Value 쌍의 Canine count가 포함됩니다. 

Device Service는 이벤트를 생성할 때 REST호출을 통해 이 정보를 핵심 데이터로 전송합니다. 

```json
POST to http://localhost:48080/api/v1/event
```

```json
BODY: {"device":"countcamera1","readings":[{"name":"humancount","value":"5"},{"name":"caninecount","value":"3"}]}
```

필요한 경우, Device Service는 데이터가 기록/수집된 시간(Epochtime /stamp/ milliseconds 형식)을 제안하기 위해 이벤트 또는 판독에 __origin 속성__ 을 제공할 수 있습니다. origin이 제공되지 않으면 Event 또는 Reading에 대해 origin이 설정되지 않습니다. 모든 Event 및 Reading은 데이터에 Time context를 제공하기 위해 데이터베이스에 Created & modified time stamp를 제공합니다. 

```json
BODY: {"device":"countcamera1","origin":1471806386919, "readings":[{"name":"humancount","value":"1","origin":1471806386919},{"name":"caninecount","value":"0","origin":1471806386919}]}
```
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/send_an_eventreading_origintime.png)

- Origin Time Stamp 권장 사항

스마트 장치는 종종 센서 데이터의 타임 스탬프를 기록하며 이 타임 스탬프를 오리진 타임 스탬프로 사용할 수 있습니다. 센서/장치가 타임 스탬프를 제공할 수 없는 경우 장치 서비스에서 장치의 원본 타임 스탬프로 적용되는 센서 데이터에 대한 타임 스탬프를 생성하는 것이 좋습니다. 

9.2 Reading data
--

이제 Core data에 Event와 관련 판독 값이 전송되었으므로, Core Data API를 사용하여 MongoDB에 저장된 데이터를 탐색할 수 있습니다. 

텍스트 설정 섹션에서 리콜하여 Core Data에 아직 저장된 데이터가 없음을 확인하여야 합니다. 동일한 호출을 하고 이번에는 2개의 이벤트 기록이 반환된 카운트가 되어야 합니다. 

```json
GET to http://localhost:48080/api/v1/event/count
```
![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/data_reading.png)

countcamera1 장치와 관련된 이벤트 10개를 검색합니다. 

![iamge](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/get_countcamera1_10.png)
```json
GET to http://localhost:48080/api/v1/event/device/countcamera1/10
```

```json
[
    {
        "id": "368a3051-c356-40cc-bb42-d7de7165b619",
        "device": "countcamera1",
        "created": 1595230984645,
        "modified": 1595230984645,
        "origin": 1471806386919,
        "readings": [
            {
                "id": "811fd2a4-ae38-44f0-bf7e-7d48ac0df23e",
                "created": 1595230984643,
                "origin": 1471806386919,
                "modified": 1595230984643,
                "device": "countcamera1",
                "name": "humancount",
                "value": "1"
            },
            {
                "id": "c9a47918-8728-48b9-a4b4-6bbd353eb34e",
                "created": 1595230984643,
                "origin": 1471806386919,
                "modified": 1595230984643,
                "device": "countcamera1",
                "name": "caninecount",
                "value": "0"
            }
        ]
    },
    {
        "id": "4c6ee8f4-07af-4688-a2ed-5960f630808a",
        "device": "countcamera1",
        "created": 1595230975200,
        "modified": 1595230975200,
        "readings": [
            {
                "id": "85fe5d64-6497-420e-bd22-20636e1bcba0",
                "created": 1595230975186,
                "modified": 1595230975186,
                "device": "countcamera1",
                "name": "humancount",
                "value": "5"
            },
            {
                "id": "4851150b-df7e-4cb5-a686-68dc62ba5a22",
                "created": 1595230975186,
                "modified": 1595230975186,
                "device": "countcamera1",
                "name": "caninecount",
                "value": "3"
            }
        ]
    },
    {
        "id": "09b7e7ac-edbe-41f8-9029-c66b75fc4d83",
        "device": "countcamera1",
        "created": 1595230961250,
        "modified": 1595230961250,
        "origin": 1471806386919,
        "readings": [
            {
                "id": "a1b489cc-b33a-4a2c-9b15-ad68913e288b",
                "created": 1595230961233,
                "origin": 1471806386919,
                "modified": 1595230961233,
                "device": "countcamera1",
                "name": "humancount",
                "value": "1"
            },
            {
                "id": "4c9ffa08-cc7f-40ed-ae56-21b38597bde4",
                "created": 1595230961233,
                "origin": 1471806386919,
                "modified": 1595230961233,
                "device": "countcamera1",
                "name": "caninecount",
                "value": "0"
            }
        ]
    },
    {
        "id": "a0c7c048-41f0-4044-a69f-b34b16aa359a",
        "device": "countcamera1",
        "created": 1595230927489,
        "modified": 1595230927489,
        "readings": [
            {
                "id": "0ca04e22-599f-4899-9a69-328a51943526",
                "created": 1595230927446,
                "modified": 1595230927446,
                "device": "countcamera1",
                "name": "humancount",
                "value": "5"
            },
            {
                "id": "00f2a236-fe90-4bee-b4e1-035a49656abd",
                "created": 1595230927446,
                "modified": 1595230927446,
                "device": "countcamera1",
                "name": "caninecount",
                "value": "3"
            }
        ]
    }
]
```

countcamera1 장치와 관련된 Human count 판독 값 10개를 검색합니다. (ex: Value Descriptor로 판독 값 가져 오기.)

```json
GET to http://localhost:48080/api/v1/reading/name/humancount/10
```

```json
[
    {
        "id": "811fd2a4-ae38-44f0-bf7e-7d48ac0df23e",
        "created": 1595230984643,
        "origin": 1471806386919,
        "modified": 1595230984643,
        "device": "countcamera1",
        "name": "humancount",
        "value": "1"
    },
    {
        "id": "85fe5d64-6497-420e-bd22-20636e1bcba0",
        "created": 1595230975186,
        "modified": 1595230975186,
        "device": "countcamera1",
        "name": "humancount",
        "value": "5"
    },
    {
        "id": "a1b489cc-b33a-4a2c-9b15-ad68913e288b",
        "created": 1595230961233,
        "origin": 1471806386919,
        "modified": 1595230961233,
        "device": "countcamera1",
        "name": "humancount",
        "value": "1"
    },
    {
        "id": "0ca04e22-599f-4899-9a69-328a51943526",
        "created": 1595230927446,
        "modified": 1595230927446,
        "device": "countcamera1",
        "name": "humancount",
        "value": "5"
    }
]
```

Reference
--

- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)

