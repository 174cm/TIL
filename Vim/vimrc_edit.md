Vim editer 효율적으로 사용하기
==

3학년때 리눅스를 처음 접하고 리눅스에서 가장 먼저 사용한 에디터는 바로 vim였습니다.   
하지만, vim은 너무나도 불편하였습니다. 지금은 많이 익숙해서 그냥 사용하지만 당시에는 `너무 불편한데 왜 사용하지?` 라고 생각했었습니다. 그 중에서 가장 불편했던 점은 바로 `줄 번호`가 나오지 않아 매우 불편했습니다.   
그래서 오늘은 vimrc를 통해 vim를 효율적이고 이쁘게 사용하는 방법을 적어놓을까 합니다. 

```
set hlsearch " 검색어 하이라이팅
set nu " 줄번호
set autoindent " 자동 들여쓰기
set scrolloff=2
set wildmode=longest,list
set ts=4 "tag select
set sts=4 "st select
set sw=1 " 스크롤바 너비
set autowrite " 다른 파일로 넘어갈 때 자동 저장
set autoread " 작업 중인 파일 외부에서 변경됬을 경우 자동으로 불러옴
set cindent " C언어 자동 들여쓰기
set bs=eol,start,indent
set history=256
set laststatus=2 " 상태바 표시 항상
"set paste " 붙여넣기 계단현상 없애기
set shiftwidth=4 " 자동 들여쓰기 너비 설정
set showmatch " 일치하는 괄호 하이라이팅
set smartcase " 검색시 대소문자 구별
set smarttab
set smartindent
set softtabstop=4
set tabstop=4
set ruler " 현재 커서 위치 표시
set incsearch
set statusline=\ %<%l:%v\ [%P]%=%a\ %h%m%r\ %F\
" 마지막으로 수정된 곳에 커서를 위치함
au BufReadPost *
\ if line("'\"") > 0 && line("'\"") <= line("$") |
\ exe "norm g`\"" |
\ endif
" 파일 인코딩을 한국어로
if $LANG[0]=='k' && $LANG[1]=='o'
set fileencoding=korea
endif
" 구문 강조 사용
if has("syntax")
 syntax on
endif
" 컬러 스킴 사용
colorscheme jellybeans
```

먼저, 현재 사용중인 vimrc의 내용입니다. `"`표시는 주석으로 설정에 영향을 주지 않습니다. 

그럼 시작하겠습니다. 

## 1. vim 설치


```
sudo apt install vim
```
vim을 설치합니다. 

## 2. vimrc 생성 

```
$ vi ~/.vimrc
```
vimrc는 자동으로 생성이 되지 않기 때문에 직접 만들어주어야 합니다. 

## 3. Syntax Highlighting

```
" Syntax Highlighting
if has(“syntax”)
    syntax on
endif
```

코딩할 때 꼭 필요한 기능입니다. 

## 4. 자동 인덴트 

```
set autoindent
set cindent
```

## 4.1 인덴트 너비 수정

```
set ts=4 " Tab 너비
set shiftwidth=4 " 자동 인덴트할 때 너비
```

## 5. 줄 번호 

```
set nu or set number
```

가장 원했던 기능으로, 줄 번호 기능을 켜는 내용입니다.   
vim에서도 수동으로 :set number를 입력하여 켤 수는 있지만 문서를 열 때마다 적용을 시켜주어야 하는 불편함이 있습니다. 

## 6. 마지막 수정된 장소에 커서를 위치

```
" 마지막으로 수정된 곳에 커서를 위치함
au BufReadPost *
\ if line("'\"") > 0 && line("'\"") <= line("$") |
\ exe "norm g`\"" |
\ endif
```

처음에는 별 생각없이 넣었는데, 생각보다 편리한 기능입니다.   
작업하던 곳에서 다시 시작하는 기능입니다. 

## 7.  현재 커서의 위치 표시

```
set laststatus=2 " 상태바 표시를 항상한다
set statusline=\ %<%l:%v\ [%P]%=%a\ %h%m%r\ %F\
```

현재 커서의 위치를 좌표로 나타내주는 기능입니다. 

Reference
--

- https://medium.com/sunhyoups-story/vim-%EC%97%90%EB%94%94%ED%84%B0-%EC%9D%B4%EC%81%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-5b6b8d546017