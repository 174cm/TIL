EdgeX Quick Starter Guide
==
> 본 문서는 EdgeX를 빠르게 시작할 수 있도록 돕는 메뉴얼 문서입니다.  
> version: 0.8  
> OS: Windows10 Education  

1.1 Setup
--
EdgeX를 실행하는 가장 빠른 방법은 사전에 빌드 된 Docker 이미지를 사용하는 것입니다.   
도커를 사용하는 방법은 [여기](https://luckygg.tistory.com/165) 에서 상세하게 찾을 수 있습니다. 

1.2 EdgeX run
--

Docker 및 Docker Compose가 설치되면 EdgeX Foundry Docker 컨테이너를 다운로드 하고 실행하기 위한 구성 파일이 필요합니다. 여기에서 먼저 막힐 수 있는데, 이 때 필요한 것이 __git bash__ 입니다. git bash 설치 내용은 [여기](https://gabii.tistory.com/entry/Git-Git-Bash-219-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0) 에서 찾을 수 있습니다. 

1. 우선, yaml 파일을 다운로드 하여 docker-compose.yml 파일로 이름을 바꿔줍니다. [다운로드](https://raw.githubusercontent.com/edgexfoundry/developer-scripts/master/releases/fuji/compose-files/docker-compose-fuji.yml)

2. 로컬 디렉토리를 하나 잡은 후, git bash here 명령으로 git bash를 엽니다. 
3. 저장한 yml파일을 통해 EdgeX Foundry Docker 이미지를 다운로드 합니다.
    ```
    docker-compose pull
    ```
    ![imgae](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker-compose_pull.PNG)
4. 모든 EdgeXx Foundry 마이크로 서비스를 시작합니다. 
    ```
    docker-compose up -d
    ```
    ![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker-compose_up.PNG)
5. EdgeX 컨테이너가 모두 시작되었는지 확인합니다.
    ```
    docker-compose ps
    ```
    ![image](https://github.com/174cm/TIL/blob/master/EdgeX/img/QuickStarterGuide/docker-compose_ps.PNG)

1.3 장치 연결
--

EdgeX Foundry는 테스트에 유용한 난수 장치 서비스를 제공하며 구성 가능한 범위 내에서 난수를 반환합니다. 이 서비스를 실행하기 위한 구성은 시작 부분에 다운로드한 docker-compose.yml 파일에 포함되어 있지만 기본적으로 비 활성화되어 있어  활성화 하여야 합니다. 

1. 코드 주석 해제
    ```
    device-random:
    image: edgexfoundry/docker-device-random-go:1.1.0
    ports:
        - "49988:49988"
    container_name: edgex-device-random
    hostname: edgex-device-random
    networks:
        - edgex-network
    volumes:
        - db-data:/data/db
        - log-data:/edgex/logs
        - consul-config:/consul/config
        - consul-data:/consul/data
    depends_on:
        - data
        - command
    ```
    
    해당 부분은 주석으로 처리되어 있음으로 VS CODE를 통해 주석을 풀어줍니다. (Ctrl+/)

2. 임의 장치 서비스를 시작

    ```
    docker-compose up -d device-random
    ```
    장치 서비스는 __Random-Integer-Generator01__ 이라는 장치를 자동으로 등록하여 임의의 숫자 판독 값을 EdgeX로 보냅니다. 

    EdgeX logging 서비스를 쿼리하여 해당 판독 값이 전송되고 있는지 확인할 수 있습니다. 

3. 판독 값 전송 확인
    ```
    curl http://localhost:48080/api/v1/event/device/Random-Integer-Generator01/10
    ```

1.4 어플리케이션 연결
--

해당 부분은 아직 검토 중입니다. 내보내기 클라이언트로 등록하려고 소스코드를 쳤으나, 제대로 동작하지 않았습니다. 아직까지 모드는 HiveMQ Broker를 사용하여 그런 듯 합니다. 

1.5 장치 제어 
-- 

EdgeX는 장치에서 데이터를 읽을 수 있을 뿐만 아니라, 장치를 제어할 수도 있습니다. 장치가 EdgeX 서비스에 등록되면 해당 장치에서 사용 가능한 데이터 판독 값과 장치를 제어하기 위해 호출 할 수 있는 명령을 모두 설명하는 장치 프로 파일을 제공합니다. 


1. 장치에서 직접 명령을 호출하지 않고 대신 EdgeX 명령 서비스를 이용하여 사용합니다. 명령 서비스를 요청하여 호출 할 수 있는 명령을 확인합니다. 

    ```
    curl http://localhost:48082/api/v1/device/name/Random-Integer-Generator01
    ```

2. 실행 된 JSON file 확인
    ```
        {
        "created":1544456741615,
        "modified":0,
        "origin":0,
        "id":"5c0e8a259f8fc20001a5d22b",
        "name":"GenerateRandomValue_Int8",
        "get":{
            "path":"/api/v1/device/{deviceId}/GenerateRandomValue_Int8",
            "responses":[
                {
                    "code":"200",
                    "description":null,
                    "expectedValues":[
                    "RandomValue_Int8"
                    ]
                },
                {
                    "code":"503",
                    "description":"service unavailable",
                    "expectedValues":[

                    ]
                }
            ],
            "url":"http://edgex-core-command:48082/api/v1/device/5c0e8a259f8fc20001a5d230/command/5c0e8a259f8fc20001a5d22b"
        },
        "put":{
            "path":"/api/v1/device/{deviceId}/GenerateRandomValue_Int8",
            "responses":[
                {
                    "code":"200",
                    "description":null,
                    "expectedValues":[

                    ]
                },
                {
                    "code":"503",
                    "description":"service unavailable",
                    "expectedValues":[

                    ]
                }
            ],
            "parameterNames":[
                "Min_Int8",
                "Max_Int8"
            ],
            "url":"http://edgex-core-command:48082/api/v1/device/5c0e8a259f8fc20001a5d230/command/5c0e8a259f8fc20001a5d22b"
        }
    }
    ```
3. 제공된 get URL을 사용하여 수동으로 호출 (해당 부분은 장치마다 고유ID가 다르기 때문에 URL이 정확하게 일치하지 않습니다. 우리가 보아야 할 부분은 __48082/api/v1/device/5c0e8a259f8fc20001a5d230/command/5c0e8a259f8fc20001a5d22b__ 여기이며 본인의 고유ID를 넣으면 됩니다.)

    ```
    curl http://localhost:48082/api/v1/device/5c0e8a259f8fc20001a5d230/command/5c0e8a259f8fc20001a5d22b
    ```

4. JSON 결과 확인

    ```
    {
        "id":"",
        "pushed":0,
        "device":"Random-Integer-Generator01",
        "created":0,
        "modified":0,
        "origin":1544457033233,
        "schedule":null,
        "event":null,
        "readings":[
            {
                "id":"",
                "pushed":0,
                "created":0,
                "origin":1544457033233,
                "modified":0,
                "device":"Random-Integer-Generator01",
                "name":"RandomValue_Int8",
                "value":"-92"
            }
        ]
    }
```
    해당 판독 값의 기본 범위는 -128에서 127까지 입니다. 새 최소값 및 최대 값을 이용하여 PUT 메소들 명령을 호출하여 0에서 100사이의 양수 값으로만 제한 할 수 있습니다. 

5. 양수 값으로 제한

    ```
    curl -X PUT -d '[
    {"Min_Int8": "0", "Max_Int8": "100"}
]' http://localhost:48082/api/v1/device/5c0e8a259f8fc20001a5d230/command/5c0e8a259f8fc20001a5d22b
    ```

Reference
--

- EdgeX Quick Starter Guide (https://fuji-docs.edgexfoundry.org/Ch-QuickStart.html)
- git bash install (https://gabii.tistory.com/entry/Git-Git-Bash-219-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0)
- Windows10 Docker install (https://luckygg.tistory.com/165)
