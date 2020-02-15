(Solved) linux system error message
==

최근 리눅스 관련 이슈를 많이 접해서 기분이 좋다.

오늘은 계속해서 로그인을 하면 나타나는 에러 메시지를 출력하는 녀석을 없애보고자 한다.

![imgae](https://media.discordapp.net/attachments/633251365434687491/678246441927442472/image.png)
> __그림__: 시스템 프로그램 오류 메시지

이 녀석인데 로그인을 하면 항상 나타나서 나를 괴롭히는 녀석이다. 

원인을 찾아보니 저 메시지는 오류를 보고하여도, 로그가 그대로 남아있어 계속해서 사용자에게 알리는 모양이다.

그럼, 로그의 위치는 어디일까?

찾아보니 `/var/crash` 폴더에 존재하는 것을 알아내었다.

![imgae](https://media.discordapp.net/attachments/633251365434687491/678246980610293809/image.png?width=695&height=468)
> __그림__: /var/crash 폴더 내 파일

현재 나의 폴더안에는 두 가지의 crash 파일이 존재해 계속해서 시스템 오류를 출력하였던 것이다.

- _opt_google_chrome_chrome.1000.crash: 크롬창을 끄지 않고 reboot을 하면 나타나는 오류로 종료전에 정상적으로 크롬을 종료하여야 한다.

- nvidia-kernel-source-410.0.crash: nvidia driver를 설치할 때 무언가 문제가 생긴듯 한데, 아마도 CUDA를 설치하면서 설치된 nvidia driver의 version이 제대로 설치되지 못하고 crash가 난 듯하다. CUDA를 설치할 때 driver가 제대로 설치되지 않았던 문제가 이 문제였던 모양이다. 

그럼, 저 계속해서 나타나는 시스템 오류 메시지를 없애는 방법은 여기 있는 crash 파일을 모두 지우면 될 것이다.

```
/var/crash$ sudo rm *
```

![imgae](https://media.discordapp.net/attachments/633251365434687491/678248088481038336/image.png?width=695&height=468)
> __그림__: 삭제된 crash file

다음과 같이 /var/crash 폴더 내에서 삭제를 진행해주어야 하며 home에서 삭제를 진행하였다간, 끔찍한 경험을 할 수 있을 것이다.

home에서 진행하고 싶다면, `sudo rm /var/crash/*` 커맨드로 진행하면 동일한 결과를 얻을 수 있다.

Reference
--
- https://moordev.tistory.com/152