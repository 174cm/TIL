요구사항 정의
==
> 본 문서는 [2020 시나공 정보처리기사 필기](http://www.yes24.com/Product/Goods/82838724) 책을 공부한 내용을 기술하였습니다.

## 1. 요구사항의 개념 및 특징

요구사항은 소프트웨어가 어떤 문제를 해결하기 위해 제공하는 서비스에 대한 설명과 정상적으로 운영되는데 필요한 제약조건 등을 나타낸다. 

- 요구사항은 소프트웨어 개발이나 유지 보수 과정에서 필요한 기준과 근거를 제공
- 요구사항은 개발하려는 소프트웨어의 전반적인 내용을 확인할 수 있게 하므로 개발에 참여하는 이해관계자들 간의 의사소통을 원할하게 하는 데 도움을 준다
- 요구사항이 제대로 정의되어야만 이를 토대로 이후 과정의 목표와 계획을 수립할 수 있다. 

## 2. 요구사항의 유형

요구사항은 일반적으로 기술하는 내용에 따라 `기능 요구사항`과 `비기능 요구사항`으로 구분하며, 기술 관점과 대상의 범위에 따라 `시스템 요구사항`과 `사용자 요구사항`으로 나눈다. 

### 기능 요구사항
- 시스템이 무엇을 하는지, 어떤 기능을 하는지에 대한 사항
- 시스템의 입력이나 출력으로 무엇이 포함되어야 하는지, 시스템이 어떤 데이터를 저장하거나 연산을 수행해야 하는지에 대한 사항
- 시스템이 반드시 수행해야 하는 기능
- 사용자가 시스템을 통해 제공받기를 원하는 기능 

### 비기능 요구사항
- 시스템 장비 구성 요구사항: 하드웨어, 소프트웨어, 네트워크 등의 시스템 장비구성에 대한 요구사항
- 성능 요구사항: 처리 속도 및 시간, 처리량, 동,정적 적용량, 가용성 등 성능에 대한 요구사항
- 인터페이스 요구사항: 시스템 인터페이스와 사용자 인터페이스에 대한 요구사항으로 다른 소프트웨어, 하드웨어 및 통신 인터페이스, 다른 시스템과의 정보 교환에 사용되는 프로토콜과의 연계도 포함하여 기술
- 데이터 요구사항: 초기 자료 구축 및 데이터 변환을 위한 대상, 방법, 보안이 필요한 데이터 등 데이터를 구축하기 위해 필요한 요구사항
- 테스트 요구사항: 도입되는 장비의 성능 테스트(BMT)나 구축된 시스템이 제대로 운영되는지를 테스트하고 점검하기 위한 테스트 요구사항
- 보안 요구사항: 시스템의 데이터 및 기능, 운영 접근을 통제하기 위한 요구사항
- 품질 요구사항: 관리가 필요한 품질 항목, 품질 평가 대상에 대한 요구사항으로 `가용성`, `정합성`, `상호 호환성`, `대응성`, `신뢰성`, `사용성`, `유지 관리성`, `이식성`, `확장성`, `보안성`등으로 구분하여 기술
- 제약사항: 시스템 설게, 구축, 운영과 관련하여 사전에 파악된 기술, 표준, 업무, 법 제도 등의 제약조건
- 프로젝트 관리 요구사항: 프로젝트의 원활한 수행을 위한 관리 방법에 대한 요구 사항
- 프로젝트 지원 요구사항: 프로젝트의 원활한 수행을 위한 지원 사항이나 방안에 대한 요구사항

### 사용자 요구사항
- 사용자 관점에서 본 시스템이 제공해야 할 요구사항
- 사용자를 위한 것으로 친숙한 표현으로 이해하기 쉽게 작성

### 시스템 요구사항
- 개발자 관점에서 본 시스템 전체가 사용자와 다른 시스템에 제공해야 할 요구사항
- 사용자 요구사항에 비해 전문적, 기술적인 용어로 표현
- 소프트웨어 요구사항으로도 불림 

## 3. 요구사항 개발 프로세스

요구사항 개발은 요구공학의 한 요소

- 도출 > 분석 > 명세 > 확인 순

## 4. 요구사항 도출(Requirement Elicitaion, 요구사항 수집)

요구사항 도출은 시스템, 사용자, 그리고 시스템 개발에 관련된 사람들이 서로 의견을 교환하여 요구사항이 어디에 있는지, 어떻게 수집할 것인지를 식별하고 이해하는 과정

- 요구사항 도출은 소프트웨어가 해결해야 할 문제를 이해하는 첫 번쨰 단계
- 요구사항 도출 단계에서 개발자와 고객 사이의 관계가 생성, 이해환계자(Stakeholder)가 식별됨
- 이 단계에서는 다양한 이해관계자 간의 효율적인 의사소통이 중요
- 요구사항 도출은 소프트웨어 개발 생명 주기(SDLC)동안 지속적으로 반복
- 요구사항을 도출하는 주요 기법에는 인터뷰, 설문, 브레인스토밍, 워크샵, 프로토타이핑, 유스케이스 등이 있음

## 5. 요구사항 분석(Requrement Analysis)

요구사항 분석은 개발 대상에 대한 사용자의 요구사항 중 명확하지 않거나 모호하여 이해되지 않는 부분을 발견하고 이를 걸러내는 과정

- 사용자 요구사항의 타당성을 조사, 비용과 일정에 대한 제약을 설정
- 내용이 중복되거나 하나로 통합되어야 하는 등, 서로 상충되는 요구사항이 있으면 이를 해결
- 도출된 요구사항을 토대로 소프트웨어의 범위를 파악
- 도출된 요구사항들을 토대로 소프트웨어와 주변 환경이 상호 작용하는 방법을 이해

## 6. 요구사항 명세(Requrement Specification)

요구사항 명세는 요구사항을 체계적으로 분석한 후 승인될 수 있도록 문서화하는 것을 의미

- 요구사항을 문서화 할때는 기능 요구사항을 빠짐없이 완전하고 명확하게 기술, 비기능 요구사항은 필요한 것만 명확하게 기술
- 요구사항은 사용자가 이해하기 쉬우며, 개발자가 효과적으로 설계할 수 있도록 작성
- 설계과정에서 잘못된 부분이 확인될 경우, 그 내용을 요구사항 정의서에서 추적할 수 있어야 한다. 

## 7. 요구사항 확인(Requirement Validation, 요구사항 검증)

요구사항 확인은 개발 자원을 요구사항에 할당하기 전에 요구사항 명세서가 정확하고 완전하게 작성되었는지를 검토하는 활동

- 명세서의 내용이 이해하기 쉬운지, 일관성은 있는지, 회사의 기준에는 맞는지, 누락된 기능은 없는지 등을 검증하는 것이 중요
- 요구사항 문서는 `이해관계자들이 검토`해야 한다
- 일반적으로 요구사항 관리 도구를 이용하여 요구사항 정의 문서들에 대해 `형상 관리`를 수행