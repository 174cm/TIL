.gitignore 설정하기
===
.gitignore 이란?
--
.gitignore 파일이란, __Git 버전 관리에서 제외할 파일 목록을 지정하는 파일__ 이다.   
git으로 프로젝트를 관리할 때, 그 프로젝트 안의 특정파일들은 관리할 필요가 없는 경우가 있다.  
예를 들면, 프로젝트 설정 파일, 자동으로 생성되는 로그파일(.log), 빌드할 때 생기는 컴파일된 파일(.class) 등이 있다. 따라서 이런 관리할 필요가 없는 파일들을 git이 track 하지 않도록 .gitignore을 설정하는 것이다. 

.gitignore 설정하기
--
1. .gitignore 파일 생성
    - 항상 최상위 디렉토리에 존재하여야 한다.
    - 문법

    ```xml
    ### Python ###
    # Byte-compiled / optimized / DLL files
    __pycache__/
    *.py[cod]
    *$py.class

    # C extensions
    *.so
    ```
    
2. .gitignore 적용하기
    - .gitignore 파일을 Push해주면 끝.

    ```c
    $ git rm -r --cached .
    // 현재 레파지토리의 캐쉬를 모두 삭제.
    $ git add .
    // .gitignore에 넣은 파일 목록을 제외한, 다른 모든 파일을 다시 track 하도록 설정.
    $ git commit -m "Fixed untracked files"
    // commit을 반드시 해주어야 한다.
    ```
3. 같이 보기 
    - gitignore는 Github에서 예시를 제공한다. 
    >  https://github.com/github/gitignore  
      
    - gitignore를 만들어주는 사이트도 존재한다.

    ![image](https://media.discordapp.net/attachments/633251365434687491/663384443129692193/ignore.png?width=759&height=403)

    >  https://www.gitignore.io/ 

    - git-scm
    > https://www.git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository

Reference
--
> - https://gmlwjd9405.github.io/2017/10/06/make-gitignore-file.html
> - https://gbsb.tistory.com/11
