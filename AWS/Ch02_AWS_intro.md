AWS 소개
==
![image](https://image.chosun.com/sitedata/image/201911/19/2019111902788_0.png)
> 그림: AWS logo

Amazon
--
- 아마존 기업은 리테일사업 > 판매자 지원사업 > 클라우드 컴퓨팅의 역사를 가지고 있다.

AWS 인프라
--
- Region
    - AWS가 운영되는 지역을 뜻한다. 
    - region은 가용영역의 집합체이며 최소 두 개의 가용영역으로 구성되어 있으며 대부분 새로운 region을 포함해서 3개에서 최대 6개까지 있다.
    - 대륙간 네트워크 통신을 통해서 글로벌 네트워크로 연결이 된다.

- Avallabllity Zones & Data Center
    - 가용영역은 region안에 위치한 복수 개의 데이터센터라고 보면 된다.
    - 각각 의미있는 거리로 물리적으로 분리되어 있다.
    - 모든 가용영역은 고대역폭 저지연 네트워킹 완전 이중화를 통해서 상호연결이 되어있다.
    - 가용영역은 대기시간이 짧은 고가용성과 이중화를 기본구성으로 이루어진다.
    - 이중화? : 특정 가용영역 하나가 천재지변으로 인하여 파괴가 되었을 때 운영하는 서버가 장애를 일으키지 않도록 두번째 가용영역에 복사를 해놓는다. 

- Edge
    - Edge location regional edge cash server로 구성되고, 전세계 고객들에게 지연시간이 짧고 전송속도가 빠른 데이터, 비디오, 애플리케이션, API를 제공하는 CDN(Contents Delivery Network)서비스이다.
    - Cloud front와 같은 data center라고 생각하면 된다.  

따라서 AWS 인프라는 다음과 같이 삼각형의 구조로 구성됨을 알 수 있다. 

![image](https://media.discordapp.net/attachments/633251365434687491/662582039803068417/AWS_infra.png?width=934&height=468)
> 그림: AWS Infrastructure 구성

![image](https://cdn.discordapp.com/attachments/633251365434687491/662579741253042187/AWS_SEOUL_1.png)

> 그림: Seoul의 region 구성도

![image](https://media.discordapp.net/attachments/633251365434687491/662579353955205131/AWS_SEOUL.png?width=884&height=468)
> 그림: AWS 사용시의 Benefit 소개 

Reference
--
> https://www.infrastructure.aws/