BeautyfulSoup install error
==

크롤링을 진행하던 중, Ubuntu에서 BeautyfulSoup을 설치하려고 했으나 __No Module named 'bs4'__ 라는 메세지를 남겼다. 

그래서 알아보니, Python 버전에 따라 설치하는 방법이 조금씩 달랐고 OS마다 달랐다.

- Python 2.x 버전에서는
```
sudo pip install BeautyfulSoup4
```

- Python 3.x 버전에서는
```
sudo apt-get install python3-bs4
```

로 설치를 하여야 가능했고, 나는 Python 3.x 버전의 명령어를 적용하여 해결하였다. 