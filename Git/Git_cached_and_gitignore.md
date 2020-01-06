Github에 잘못 올라간 파일 삭제하기
==

Github에 잘못 올라간 파일 삭제
--
### 1. 원격 저장소에서 파일 삭제하기.

- 이미 github remote에 push 한 상태이기에 로컬의 저장소에서 파일을 삭제해도 원격 저장소에는 영향을 미치지 않는다.
``` c
// 원격 저장소와 로컬 저장소에 있는 파일을 삭제 할 때
$ git rm [File name]

// 원격 저장소에 있는 파일을 삭제. 로컬 저장소에 있는 파일은 삭제하지 않음.
$ git rm --cached [File name]
```

- 따라서 아래와 같이 `git rm --cached [File name]` 명령어를 이용하여 원격 저장소에서 잘못 올라간 파일을 삭제해 주어야 한다. 

```c
// .idea/modules.xml 파일 삭제
$ git rm --cached .idea/modules.xml
// .idea 폴더 하위의 모든 파일 삭제
$ git rm --cached -r .idea/
```
### 2. .gitignore 설정하기
만약 .gitignore가 제대로 설정되어 있지 않다면 .gitignore를 설정하여 다음에는 개인이 관리하여야 하는 파일들이 원격 저장소에 올라가지 않도록 하여야 한다. [.gitignore 설정하기](https://github.com/174cm/TIL/blob/master/Git/Git_gitignore.md) 를 참고하여 .gitignore를 설정한다. 

### 3. 원격 저장소에 적용하기
버전 관리에서 완전히 제외하기 위해서는 반드시 commit 명령어와 push를 수행하여야 한다.

```c
// 버전 관리에서 완전히 제외하기 위해 반드시 commit 수행
$ git commit -m ".gitignore add"
// 원격 저장소에 push
$ git push origin master
```

Reference
--
> - https://gmlwjd9405.github.io/2018/05/17/git-delete-incorrect-files.html