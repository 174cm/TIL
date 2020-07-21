(SOLVED) docker-compose down failed
==

EdgeX를 통해 docker 이미지를 삭제하던 중, 삭제가 되지 않는 상황이 일어 났다.

error code는 다음과 같다.

```
ERROR: error while removeing network: network edgex-geneva_edgex-network id [idname] has active endpoints 
```

해당 오류를 찾던 중, 해답을 찾았다. 

`--remove-orphans`라는 명령어를 추가로 사용하면 문제없이 삭제가 되는 것을 확인할 수 있었다. 

```
Usage: down [options]

Options:
    --rmi type              Remove images. Type must be one of:
                              'all': Remove all images used by any service.
                              'local': Remove only images that don't have a
                              custom tag set by the `image` field.
    -v, --volumes           Remove named volumes declared in the `volumes`
                            section of the Compose file and anonymous volumes
                            attached to containers.
    --remove-orphans        Remove containers for services not defined in the
                            Compose file
    -t, --timeout TIMEOUT   Specify a shutdown timeout in seconds.
                            (default: 10)
```
- --rmi type: all과 local 로 명령어가 나뉜다. all은 모든 이미지를 지우는 명령어, local은 필드에 설정된 사용자 정의 태그가 없는 이미지만 지우는 명령어
- --remove-orphans: 정의되지 않은 서비스에 대한 컨테이너도 함께 제거하는 명령어.
- --volumes: 볼륨도 함께 제거.
- -t: 종료 시간 초과로 인한 종료.

![image](https://github.com/174cm/TIL/blob/master/Issue/img/docker-compose_down_--remove-orphans.png)

Reference
--

- docker-compose down(https://docs.docker.com/compose/reference/down/)