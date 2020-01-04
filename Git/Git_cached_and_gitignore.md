Github에 잘못 올라간 파일 삭제하기
==

Github에 잘못 올라간 파일 삭제
--
### 1. 원격 저장소에서 파일 삭제하기.

- 이미 github remote에 push 한 상태이기에 로컬의 저장소에서 파일을 삭제해도 원격 저장소에는 영향을 미치지 않는다.
``` c
// 원격 저자옷와 로컬 저장소에 있는 파일을 삭제 할 때
$ git rm [File name]

// 원격 저장소에 있는 파일을 삭제. 로컬 저장소에 있는 파일은 삭제하지 않음.
$ git rm --cached [File name]
```

- 따라서 아래와 같이 `git rm --cached [File name]` 명령어를 이용하여 원격 저장소에서 잘못 올라간 파일을 삭제해 주어야 한다. 

Reference
--
> - https://gmlwjd9405.github.io/2018/05/17/git-delete-incorrect-files.html