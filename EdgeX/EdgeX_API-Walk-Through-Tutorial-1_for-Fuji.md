EdgeX API Walk Through Tutorial for Fuji 1
==

> 본 문서는 Fuji용 EdgeX API Walk through Tutorial을 돕는 문서입니다.   
> version: 1.0

목차
--

1. Setup environment
2. Running EdgeX 
3. Example UseCase
4. Defining Data
5. Defining Device 
6. Register Device Service
7. Provision a Device
8. Calling commands
9. Sending events & reading data
10. Exporting device data
11. Building own solution

여기서는 __3.Exaple UseCase__ 까지 설명합니다. 

## 1. Setup enviroment

docker와 docker-compose 설치는 이전 문서에서 충분히 다루었기에 넘어가고, POSTMAN을 설치하도록 하겠습니다.

- Postman  
: Postman은 개발한 API를 테스트하고, 테스트 결과를 공유하여 API 개발의 생산성을 높여주는 플랫폼입니다. [다운로드 링크](https://www.postman.com/downloads/)

## 2. Running EdgeX

이전의 문서에서 충분히 다루었기에 생략합니다. 

## 3. Example UseCase

EdgeX에 연결하려는 새 장치가 있다고 가정합니다. 이 장치는 카메라로, 사진을 분석하고 사람과 개의 수를 보고하는 온보드 칩을 가지고 있습니다. 

![image](https://fuji-docs.edgexfoundry.org/_images/EdgeX_WalkthroughHumansCanine.png)

카메라는 스캔 깊이를 피트단위로 설정하도록 요청할 수 있습니다. 멀수록 사람과 개의 정확도가 떨어지기 떄문입니다. 

또한, 카메라는 사진을 찍고 결과를 보고하는 빈도도 나타내야 합니다. 실제로 카메라 장치에는 두 가지 작동 명령이 전송될 수 있습니다. 즉, 두 가지 요청이 전송되어 응답하고 무언가를 동작해야 합니다.

![image](https://fuji-docs.edgexfoundry.org/_images/EdgeX_WalkthroughSnapshotDepth.png)

EdgeX에서 카메라는 장치로 표시되어야 하며 각 장치는 Device Service micro service에 의해 관리됩니다. 장치 서비스는 해당 장치에 대해 선택한 프로토콜에서 기본 하드웨어와 통신합니다. Device Service는 관리하는 장치에서 데이터를 수집하여 해당 데이터를 EdgeX로 전달합니다. 또한 Devuce Service는 EdgeX 및 기타 국가의 작동 요청을 물리적 장치가 이해할 수 있는 프로토콜 요청으로 변환하는 역할을 합니다. 이 예에서 Device Service는 Snap shot 간격을 설정하고 Scan depth를 설정하고 해당 요청을 카메라가 이해하는 프로토콜 명령으로 변환하도록 요청합니다. 

Reference
--
- fuji-docs (https://fuji-docs.edgexfoundry.org/index.html)
