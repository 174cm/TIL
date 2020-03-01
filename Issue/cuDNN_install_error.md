cuDNN install error
==

- cuDNN이란: cudnn은 gpu 가속 라이브러리로 cuDNN은 정방향 및 역방향 컨볼 루션, 풀링, 정규화 및 활성화 계층과 같은 표준 루틴에 대해 고도로 조정 된 구현을 제공한다고 한다. (아직까지 cuDNN이 어떤 용도인지는 잘 모릅니다.)

해당 문제는 cuDNN을 설치한 후, 문제가 생겼습니다.   

에러코드는 다음과 같습니다. 

```
error code: libcudnn.so.7: cannot open shared object file: No such file or directory
```

이유는 bashrc에 환경 변수를 제대로 설정해주지 않아 발생하였습니다.   
기존에 CUDA를 설치하였을 때 환경 변수를 설정해주었는데, cuDNN도 따로 한번 더 해주어야 했습니다. 

따라서, 다음의 코드를 bashrc에 추가해주어야 합니다. 

```
export PATH=/usr/local/cuda-10.2/bin${PATH:+:${PATH}}
export LD_LIBRARY_PATH=/usr/local/cuda-10.2/lib64${LD_LIBRARY_PATH:+:${LD_LIBRARY_PATH}}
```

![image](https://github.com/174cm/TIL/blob/master/Issue/img/bashrc.png) 