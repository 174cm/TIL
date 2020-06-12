Overseas_Covid-19_Crawling
==
해당 소프트웨어는 해외 코로나 바이러스(우한폐렴)의 진행 상황을 파악하기 위하여 생성하였으며 실행 시, 해당 날짜의 결과를 csv file로 자동으로 생성한다. 

How to use?
--

- Windows
1. Vs code 터미널에서 `pip install pandas`로 pandas 설치
2. Vs code 터미널에서 `pip install BeautifulSoup4`로 BeautifulSoup 설치
3. 실행

- LINUX(Ubuntu)
1. 터미널에서 `sudo apt install pip`로 pip를 먼저 설치
2. 터미널에서 `pip install bs4`로 BeautifulSoup 설치
3. 터미널에서 `pip install pandas`로 pandas 설치
4. 실행

Update Note
--

- 2020.04.08 demo update
- 2020.04.09 1.0ver update
- 2020.04.13 2.0ver update
- 2020.04.21 2.1ver update
- 2020.04.21 3.0ver update

알려진 문제점 & 개선사항
-- 

- 현재 사이트에서 당일에 올라오지 않는 상황이 관측됨에 따라 결과물의 제목만으로는 정확하게 날짜를 알기 어려움.
- 따라서, 결과물에 날짜를 삽입하는 과정일 필요함.