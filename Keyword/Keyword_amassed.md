Keyword amassed
==
> 본 문서는 IT용어 Keyword들을 모아 공부 및 정리하는 용도의 문서입니다.

HTML
-- 

- nbsp: HTML에서 사용되는 특수 문자 기호입니다. nbsp는 __Non-breaking Space__ 의 약어이며 __공백(Space)__ 을 나타내 주는 것이라 이해하면 쉽습니다. 이 기호를 일반적인 문자 조합과 구분하기 위해 앞에는 &, 뒤에 ;를 넣어 &nbsp;라 표기합니다. 

- lt: lt는 Less than sign의 약자로 부등호를 나타냅니다. 기호로 표기하면 (<)로 표기됩니다. 마찬가지로 앞에는 &, 뒤에는 ;를 넣어 &lt;로 표기합니다. 

- gt: gt는 Greater than sign의 약자로 부등호를 나타냅니다. 기호로 표기하면 (>)로 표기됩니다. 마찬가지로 앞에는 &, 뒤에는 ;를 넣어 &gt;로 표기합니다. 

Security
--

- SHA(Secure Hash Algorithm): 해쉬 알고리즘 함수들은 서로 관련된 암호학적 해시 함수들의 모음입니다. 이들 함수는 미국 국가보안국(NSA)이 1993년에 처음 설계하였고 미국 국가 표준으로 지정되었습니다. SHA는 SHA-224, SHA-256, SHA-384, SHA-512등이 존재합니다. 


    - SHA-1 해시값의 예제
    ```
    SHA1("The quick brown fox jumps over the lazy dog")
    = 2fd4e1c67a2d28fced849ee1bb76e7391b93eb12
    ```

    ```
    SHA1("The quick brown fox jumps over the lazy dog.")
    = 408d94384216f890ff7a0c3528e8bed1e0b01621
    ``` 
    산사태 효과(avalanche effect)때문에 점 하나 차이로 값이 달라지는 것을 확인할 수 있습니다. 