import requests
import pandas as pd
from bs4 import BeautifulSoup

url = requests.get("https://news.naver.com/")
news = url.text
soup = BeautifulSoup(news, 'html.parser')
tag_news = soup.select('.main_content li a strong')
main_news = []

for tag in tag_news:
    main_news.append(tag.text)

#print(main_news)

df = pd.DataFrame(data=main_news, columns = ["main"])

df .to_csv("main_news.csv")