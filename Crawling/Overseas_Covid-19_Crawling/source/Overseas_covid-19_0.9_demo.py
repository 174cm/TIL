'''
@author: 174cm
@version: 0.9
@since: 2020-04-08
'''
import urllib.request
import pandas as pd
from bs4 import BeautifulSoup

url = 'http://www.xn--now-po7lf48dlsm0ya109f.kr/infect/occurrence_info.do?infect_no=in_202004080001&pageIndex=&disease_no2=&search_nm='
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html, 'html.parser')
table = soup.find('table', {
                  'style': 'table-layout: fixed; border-width: 0.28pt; border-style: solid; border-color: rgb(0, 0, 0);'})  # 테이블의 위치
trs = table.find_all('tr')
temp = ['아시아', '중동', '아메리카', '유럽', '오세아니아', '아프리카', '기타']

for idx, tr in enumerate(trs):
    tds = tr.find_all('td')
    if tds[0].text in temp:
        cont = tds[1].text  # 국가
        conv = tds[2].text  # 확진자
        dead = tds[3].text  # 사망자
    else:
        cont = tds[0].text  # 국가
        conv = tds[1].text  # 확진자
        dead = tds[2].text  # 사망자

    print(cont, conv,  dead)
