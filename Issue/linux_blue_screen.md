(Solved) Linux blue screen
==

오늘 사용하던 NVIDIA JETSON TX2에서 재부팅 후, 너무나 공포스러운 블루스크린이 뜨는 이슈가 발생하여 겨우 처리하였다.

부팅을 하게 되면, 정상적으로 되는 듯하다가 블루스크린에 커서만 뜬다.   
이럴때, 해결하는 방법을 남기고자 한다.

1. 우선, `Ctrl+Alt+F1`으로 tty로 들어간다.
2. 그런 다음, 로그인을 한다. (텍스트 로그인은 가능하다.)
3. 여기서 찾아보면 `sudo apt-get --configure -a`를 하라고 하는데, 에러를 출력하며 동작하지 않았다.
4. 몇가지 방법을 찾아보다 `sudo apt upgrade`를 먼저 하였다.
5. 그럼, `E: dpkg was interrupted, you must manually run 'sudo dpkg --configure -a' to correct the problem` 이라는 오류 메시지를 받을 것이다.
6. 그때 `sudo dpkg --configure -a`를 입력하면 주르르륵 복구를 시작한다.
7. 식겁했던 마음을 다스린다.

![image](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F994D0A465C59942F345EF6)
> linux tty 화면 

리눅스 블루스크린은 특정 업데이트에서 에러가 뜨거나 몇 가지 다른 이유로 인하여 우분투 데스크탑이 중단되었을 때 발생한다고 한다. 

나의 경우, install을 시도하던 중, `E: Could not get lock /var/lib/dpkg/lock-frontend - open (11: Resource temporarily unavailable)`
`E: Unable to acquire the dpkg frontend lock (/var/lib/dpkg/lock-frontend), is another process using it?` 라는 오류 메시지를 출력했었고, 재부팅 후 블루스크린이 발생하였다. 

Reference
--

- https://askubuntu.com/questions/839279/stuck-on-blue-screen-while-booting-the-system (해결하는데 도움이 된 곳)

- https://nulliusinverba.blog/2016/09/22/ubuntu-blue-screening-of-death/ (2번.sudo apt --configure -a)

- https://kgu0724.tistory.com/71 (dpkg error 해결법)