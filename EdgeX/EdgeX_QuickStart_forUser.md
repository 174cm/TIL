EdgeX Quick Start for User
==
> 본 문서는 EdgeX Getting Started with Docker의 문서를 참고하여 작성한 문서입니다. 
> version: 0.8
EdgeX 문서는 User용과 Developer로 나뉘며 여기서는 User용을 설명합니다. 본 문서는 앞에 소개한 Quick Start Guide와 비슷 혹은 동일합니다. 순서는 다음과 같습니다. 

1. docker setup
2. edgeX foundrt compose file download
3. run edgeX using compose commands 

EdgeX 권장 사양
--

- 메모리: 최소 1GB
- HDD: 최소 3GB의 여유공간
- OS: Windows7-10, ubuntu14-16, macOS X 10

현재 저는 AWS EC2 ubuntu 20.04 ver.과 Windows10 Education에서 동작중이지만 아직까지 큰 문제는 없었습니다. 참고로 Windows10에서 사용할 예정이라면 __Home 이상의 버전이 필요__ 합니다. (Pro 또는 Education)

1과 2인 docker setup과 compose file download 및 run은 다음의 문서를 따라주시면 됩니다. [링크](https://github.com/174cm/TIL/blob/master/EdgeX/EdgeX_QuickStarterGuide.md)

Docker Compose file
--

Docker Compose file은 다음과 같은 manifest file입니다. 
- 다운로드해야하는 docker containers (즉, docker container image)
- 컨테이너가 시작되는 순서
- 컨테이너를 실행해야하는 매개 변수

Run EdgeX Foundry 
--

Quick Start에 설명하지 않았던 명령어들의 상세 설명을 하겠습니다. 

docker-compose.yml을 이미 다운로드 하였기 때문에 바로 실행이 가능하며 혹시나 다운로드 받지 않았다면 [여기](https://raw.githubusercontent.com/edgexfoundry/developer-scripts/master/releases/fuji/compose-files/docker-compose-fuji.yml)에서 다운로드 받을 수 있습니다. 

Docker Compose 파일 위치로 git bash를 열고 도커 명령어를 실행합니다. 

Docker Command
--

- 모든 EdgeX Docker 이미지를 시스템으로 가져오는 명령어

    ```
    docker-compose pull
    ```
- Docker 이미지를 가져온 후 터미널에서 다음 명령으로 EdgeX를 시작하는 명령어

    ```
    docker-compose up -d
    ```
    __-d__ 옵션은 Docker Compose가 EdgeX 컨테이너를 분리 모드로 실행하도록 (즉, 백그라운드에서 실행) 나타냅니다. -d가 없다면 컨테이너는 모두 터미널에서 시작되고 터미널을 더 사용하려면 컨테이너를 중지하여야 합니다. 

- 모든 컨테이너가 다운로드되어 시작되었는지 확인하는 명령어 

    ```
    docker-compose ps
    ```

    config-seed와 같은 초기화 또는 시드 컨테이너는 관련 서비스를 초기화 한 다음 종료하는 작업이므로 종료됩니다. 

EdgeX Foundry 중지 및 제거
-- 

- 모든 EdgeX 컨테이너를 중지 및 해체(제거)하려면 다음의 명령어를 호출합니다. 

    ```
    docker-compose down
    ```

- 실행 중인 혹은 사용 가능한 컨테이너 체크 

    ```
    docker-compose ps
    ```

    현재 모든 컨테이너를 중지시켰기 때문에 ps의 결과로 아무것도 나타나지 않는 것을 볼 수 있습니다. 


고급 EdgeX 사용자 명령
--

- 특정 컨테이너 이미지 다운로드

    ```
    docker-compose pull [compose-container-name]
    ```

- 컨테이너의 Docker Compose 이름 목록 가져오기 

    ```
    docker-compose config --services
    ```

- 컨테이너 시작

    ```
    docker-compose start
    ```

    모든 컨테이너를 다시 시작하는데 사용됩니다. (중지 후)

- 개별 컨테이너 시작

    ```
    docker-compose start [compose-container-name] 
    ```

    여기에서 볼륨 컨테이너가 동작됩니다. 

- 컨테이너 중지

    ```
    docker-compose stop [compose-container-name]
    ```

    컨테이너 중지에는 다음과 같은 개별 중지와 

    ```
    docker-compose down
    ```

    모든 컨테이너를 중지하는 명령어가 따로 존재합니다. 
    
    down 명령어의 경우 모든 컨테이너를 중지 한 다음 __모든 컨테이너를 제거__ 합니다.        
    하지만 stop의 경우 컨테이너를 중지하지만 컨테이너 이미지를 제거하지는 않습니다. 




Reference
--
- edgeX console (http://192.168.0.178:4000/)
- edgeX 시작하기 (https://docs.edgexfoundry.org/1.2/getting-started/Ch-GettingStartedUsers/)