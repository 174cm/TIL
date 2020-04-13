'''
@author: 174cm
@version: 1.0
@since: 2020-04-09
'''
import urllib.request
import pandas as pd
from bs4 import BeautifulSoup

url = 'http://www.xn--now-po7lf48dlsm0ya109f.kr/infect/occurrence_info.do?infect_no=in_202004080001&pageIndex=&disease_no2=&search_nm='
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
df.to_csv('Overseas_covid-19_result.csv', encoding='utf-8')