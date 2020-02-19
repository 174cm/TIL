Microsoft Azure Education 
==
> 본 문서는 2020.2.17~ 2.18 창원대학교에서 진행한 `클라우드 서비스 기반의 쉬운 인프라 구축과 모바일 앱 개발` 오프라인 교육 내용입니다. 

Step 1. 리소스 그룹 생성
--

Step 2. 스토리지 어카운트 생성
--

Step 3. 안드로이드 스튜디오 어플리케이션 생성
--

1. 안드로이드 스튜디오 오픈
2. name: TwicePicApp minimumAPI:22(Lolipop)
3. 프로젝트 생성
4. build.Gradle(Module)에서 모두 최신버전으로 업데이트
5. Google에서 `maven azure android` 검색 (라이브러리를 추가할 때 필요한 것을 찾는 방법)
6. 검색 경로 접속(https://mvnrepository.com/artifact/com.microsoft.azure.android/azure-storage-android/2.0.0) (sdk는 2.0.0 ver.이 최신 version임.)
7. Gradle로 가서 copy한 후, implementation 'com.microsoft.azure.android:azure-storage-android:2.0.0' 다음과 같이 수정
8. Azure Storage Explorer에서 생성한 Blob Container에 `images`라는 컨테이너를 추가
9. images > 우클릭 > 공용 액세스 권한 클릭 > 컨테이너 및 Blob에 대한 공용 읽기 권한 설정
10. Storage Account > 액세스 키 > connection string을 copy 
11. 안드로이드 코드 작성 부분 추가하여야 함.

Step 4. function app
--

1. 설정은 어제와 동일
2. 사용자함수 > imgae 검색 > image resizer
3. c# > trigger의 sample-images를 images로 변경 > 만들기 
