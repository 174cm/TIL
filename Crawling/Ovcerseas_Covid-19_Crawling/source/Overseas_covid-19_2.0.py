'''
@author: 174cm
@version: 2.0
@since: 2020-04-13
@difference: 1.Usage(사용법)추가 2.csv 파일 이름을 입력한 날짜로 저장되도록 변경
'''
import urllib.request
import urllib.parse
from sys import stderr
import sys
import pandas as pd
from bs4 import BeautifulSoup

baseUrl = 'http://www.xn--now-po7lf48dlsm0ya109f.kr/infect/occurrence_info.do;jsessionid=ECE7F42FC9E3E16E014F66D4307272C7?infect_no=in_'
addUrl = input('날짜를 입력하세요: ')
if len(addUrl) < 12:
    print("Usage: 202004010001", file=sys.stderr)
    exit()
url = baseUrl + addUrl
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html, 'html.parser')
table = soup.find('table', {'style':'table-layout: fixed; border-width: 0.28pt; border-style: solid; border-color: rgb(0, 0, 0);'}) #테이블의 위치
trs = table.find_all('tr')
temp = ['아시아','중동', '아메리카', '유럽', '오세아니아','아프리카', '기타']
toCsv = []

for idx, tr in enumerate(trs):
    tds = tr.find_all('td')
    tmp = []
    if tds[0].text in temp:
        tmp.append(tds[1].text)
        tmp.append(tds[2].text)
        tmp.append(tds[3].text)
    else:
        tmp.append(tds[0].text)
        tmp.append(tds[1].text)
        tmp.append(tds[2].text)
    toCsv.append(tmp)

df = pd.DataFrame(data = toCsv)
df.to_csv('Overseas_covid-19_'+addUrl+'_result.csv', encoding='utf-8')