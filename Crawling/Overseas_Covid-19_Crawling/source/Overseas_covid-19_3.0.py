'''
@file: Overseas_covid-19_3.0.py
@author: 174cm
@version: 3.0
@since: 2020-04-20
@brief: 해외 국가의 코로나 확진자 및 사망자수를 크롤링하는 프로그램. 
@difference: 1.table의 style을 계속해서 변경하기 때문에 table을 찾아 어떤 table이라도 적용되도록 변경
'''
import urllib.request
import urllib.parse
from sys import stderr
import sys
import pandas as pd
from bs4 import BeautifulSoup
import csv

baseUrl = 'http://www.xn--now-po7lf48dlsm0ya109f.kr/infect/occurrence_info.do;jsessionid=ECE7F42FC9E3E16E014F66D4307272C7?infect_no=in_'
addUrl = input('날짜를 입력하세요: ')
if len(addUrl) < 12:
    print("Usage: YYYYMMDD0001 EX)202004010001", file=sys.stderr)
    exit()
url = baseUrl + addUrl
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html, 'html.parser')
table = soup.find('table')  # 테이블을 찾음
trs = table.find_all('tr')
date = soup.select('p:nth-child(7) > span > b')
continent = ['아시아', '중동', '아메리카', '유럽', '오세아니아', '아프리카', '기타'] # 대륙이 [0]번째 list를 잡아먹음으로, 제외할 항목을 작성.
toCsv = []
 
for idx, tr in enumerate(trs):
    tds = tr.find_all('td')
    tmp = []
    if tds[0].text in continent:
        tmp.append(tds[1].text)
        tmp.append(tds[2].text)
        tmp.append(tds[3].text)
    else:
        tmp.append(tds[0].text)
        tmp.append(tds[1].text)
        tmp.append(tds[2].text)
    toCsv.append(tmp)

df = pd.DataFrame(data=toCsv)
df.to_csv('Overseas_covid-19_'+addUrl+'_result.csv', encoding='utf-8')
'''
f = open('Overseas_covid-19_'+addUrl+'_result.csv','a', newline='')
wr = csv.writer(f)
wr.writerow([date[0].text.strip()], encoding='utf-8')
f.close()
'''