(Solved )linux keyboard mouse freezing
==

계속해서 에러를 뱉어내는 리눅스 덕분에 기록해야 할 사항이 늘어나고 있어서 정.말 감사하다.

오늘은 NVIDIA DRIVER 440을 설치하고 reboot 한 후에 일어난 일이다. 

login까지는 정상적으로 되었으나, 로그인 후 마우스, 키보드 인풋은 들어가지만 인식이 되지 않는 현상이었다.

그래서 살-짝 멘붕이 왔었지만, 다행히 방법이 있어 해결할 수 있었다.

그래서 내가 해결한 방법을 남긴다.

Solution
--

1. 로그인 화면에서 Ctrl+Alt+F1(F1~F6중 아무거나)를 눌러 tty 상태로 진입.  
나는 f2로 진입할 수 있었다.

2. tty 상태에서 login (사용자 이름 및 비밀번호를 입력)

![image](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F994D0A465C59942F345EF6)
> linux tty 화면 

3. `$ sudo apt-get install xserver-xorg-input-all` 입력
4. `sudo reboot`

다음과 같은 방법으로 마우스와 키보드가 다시 정상적으로 돌아왔다. 

Reference
--

- https://jangjy.tistory.com/351
