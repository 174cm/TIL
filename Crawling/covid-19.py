# Testing Crawling
import pandas as pd
import urllib.request
from bs4 import BeautifulSoup 

url = 'http://www.xn--now-po7lf48dlsm0ya109f.kr/infect/occurrence_info.do;jsessionid=ECE7F42FC9E3E16E014F66D4307272C7?infect_no=in_202004070001&pageIndex=&disease_no2=&search_nm='
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html, 'html.parser')
temp = soup.find_all('table')
temp1 = temp[0].find_all('span')
temp2 = temp[1].find_all('span')


    
def makecsv(item):
    data=[]
    for i in temp1:
        print(i.text)
    data.append(temp1 = temp[0].find_all('span'))
    covid_df = pd.DataFrame(i, columns = ['country'])
    covid_df.to_csv('test.csv', index=False)
    covid_df.head()
