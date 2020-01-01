> 인프런 - 부경대IT융합응용공학과 권오흠 교수님의 '__영리한 프로그래밍을 위한 알고리즘 강좌__'를 토대로 공부한 내용입니다. [(Link)](https://www.inflearn.com/course/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%95%EC%A2%8C#)

제 1장.   
알고리즘의 분석: 시간복잡도
===

알고리즘의 분석
--
- 알고리즘의 __자원(resourece) 사용량__ 을 분석
- 자원이란 실행 시간, 메모리, 저장장치, 통신 등
- 여기서는 __실행시간의 분석__ 에 대해서 다룬다.

시간 복잡도
--
- 실행시간은 실행환경에 따라 달라짐.
    - 하드웨어, 운영체제, 언어, 컴파일러 등

- 실행 시간을 측정하는 대신 __연산의 실행 횟수__ 를 카운트
- 연산의 실행 횟수는 __입력 데이터의 크기에 대한 함수__ 로 표현
- 데이터의 크기가 같더라도 실제 데이터에 따라서 달라짐
    - 최악의 경우 시간복잡도 (worst-case analysis)
    - 평균 시간복잡도 (average-case analysis)

점근적(Asymptotic) 분석
--
- 점근적 표기법을 사용
    - 데이터의 개수 n -> ∞일때 수행시간이 증가하는 growth rate로 시간복잡도를 표현하는 기법
    - Θ-표기, O-표기 등을 사용
- 유일한 분석법도 아니고 가장 좋은 분석법도 아니다
    - 다만 (상대적으로) 가장 간단
    - 알고리즘의 실행환경에 비의존적
    - ∴ 가장 광범위하게 사용되는 분석법

점근적 분석의 예: 상수 시간복잡도
--
> 입력으로 n개의 데이터가 저장된 배열 data가 주어지고, 그 중 n/2번째 데이터를 반환한다.

```C
int sample( int data[], int n)
{
    int k = n/2;
    return data[k];
}
```

- 일 때, n에 관계없이 상수 시간이 소요된다.  
이 경우 알고리즘의 시간복잡도는 O(1)이다.

점근적 분석의 예: 선형 시간복잡도
--
> 입력으로 n개의 데이터가 저장된 배열 data가 주어지고, 그 합을 구하여 반환한다.

```c
int sum(int data[], int n)
{
    int sum = 0;
    for (int i = 0; i < n; i++)
        sum = sum + data[i]; 
// sum = sum + data[i]; 은 이 알고리즘에서 가장 자주 실행되는 문장이며, 실행 횟수는 항상 n번이다. 가장 자주 실행되는 문장의 실행횟수가 n번이라면 모든 문장의 실행 횟수의 합은 n에 선형적으로 비례하며, 모든 연산들의 실행 횟수의 합도 역시 n에 선형적으로 비례한다.
    return sum;
}
```
- 선형 시간복잡도를 가진다고 말하고 O(n)이라고 표기한다.

Quadratic
--
> 배열 x에 중복된 원소가 있는지 검사하는 함수이다.
```c
bool is_distinct(int n, int x[])
{
    for (int i = 0; i < n-1; i++)
        for (int j = i +1; i < n; j ++)
            if(x[i] == x[j])
// if(x[i] == x[j]) 이 알고리즘에서 가장 자주 실행되는 문장이며, 최악의 경우 실행 횟수는 n(n-1)/2번이다. 
                return false;
    return true;
}
```
- 최악의 경우 배열에 저장된 모든 원소 쌍을 비교하므로   
비교 연산의 횟수는 n(n-1)/2이다.  
최악의 경우 시간 복잡도는 O(n²) 

이진검색
--
> 배열 data에 n개의 문자열이 오름차순으로 정렬되어 있다.

```c
int binarySearch(int n, char *data[], char *target) 
{
    int begin = 0, end = n-1
    while(begin <= end) {
        int middle = (begin + end)/2;
        int result = strcmp(data[middle], target);
        if (result == 0)
            return middle;
        else if (result < 0)
            begin = middle + 1;
        else
            end = middle - 1;
    }
    return -1;
}
```
- 한 번 비교할 때마다 남아있는 데이터가 절반으로 줄어든다.  
따라서, 시간복잡도는 O(log₂n)이다.

이진검색 정리
-- 
- 데이터가 연결리스트에 오름차순으로 정렬되어 있다면?
    - 연결리스트에서는 가운데(middle) 데이터를 O(1)시간에 읽을 수 없다.
    - 따라서 이진검색을 할 수 없다.
- 순차검색의 시간복잡도는 O(n)이고 이진검색은 O(log₂n)이다. 이 둘의 차이는 매우 크다.

버블 정렬(bubble sort)
--
- 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
    - 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면, 서로 교환한다.
- 선택 정렬과 기본 개념이 유사
> 배열에 7,4,5,1,3이 저장되어 있다고 가정하고 자료를 오름차순으로 정렬

![bubble sort](https://gmlwjd9405.github.io/images/algorithm-bubble-sort/bubble-sort.png)

> bubble sort code
```c
void bubbleSort(int data[], int n)
{
    for (int i = n-1; i > 0; i--) {
        for (int j = 0; j <i; j++) {
            if (data[j] > data[j+1]) {
                int tmp = data[j];
                data[j] = data[j+1];
                data[j+1] = tmp;
            }
        }
    }
}
```
버블 정렬 알고리즘의 특징
--
- 장점
    - 구현이 매우 간단하다.
- 단점
    - 순서에 맞지 않은 요소를 인접한 요소와 교환한다.
    - 하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는 배열에서 모든 다른 요소들과 교환되어야 한다.
    - 특히 특정 요소가 최종 정렬위치에 이미 있는 경우라도 교환되는 일이 일어난다.
- 일반적으로 자료의 교환 작업(SWAP)이 자료의 이동 작업(MOVE)보다 더 복잡하기 때문에 버블정렬은 단순성에도 불구하고 __거의 쓰이지 않는다.__ 

버블 정렬의 시간복잡도
--
- 비교 횟수
    - 최상, 평균, 최악 모두 일정함.
    - n-1, n-2, ..., 2, 1 번 = n(n-1)/2

- 교환 횟수
    - 입력 자료가 역순으로 정렬되어 있는 최악의 경우, 한 번 교환하기 위하여 3번의 이동이 필요하므로 (비교 횟수 *3)번 = 3n(n-1)/2
    - 입력 자료가 이미 정렬되어 있는 최상의 경우, 자료의 이동이 발생하지 않는다.
- ∴ __T(n) = O(n²)__

선택 정렬(Selection sort)
--
- 가장 작은 숫자를 __선택__ 하는 방식으로 정렬을 진행하여 __선택정렬__ 이라 불림
- 제자리 정렬(in-place sorting) 알고리즘의 하나
    - 입력 배열(정렬되지 않은 값들) 이외에 다른 추가 메모리를 요구하지 않는 정렬 방법
    - 가장 작은 숫자를 차례대로 탐색하여, 가장 왼쪽 자리부터 스왑하는 알고리즘 
- 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
    - 첫 번째 순서에는 첫 번쨰 위치에 가장 최소값을 삽입.
    - 두 번째 순서에는 두 번째 위치에 남은 값 중의 최소값을 삽입.
    - loop

선택 정렬 알고리즘의 예제
--
> 배열에 9,6,7,3,5가 저장되어 있다고 가정하고 오름차순으로 정렬 

![selection sort](https://gmlwjd9405.github.io/images/algorithm-selection-sort/selection-sort.png)

> selectionSort code
```c
void selectionSort(int arr[], int n)
{
    int i, j, min;
    for (i = 0; i < n -1; i++) {
        min = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[min])
                min = j;

            swap(&arr[min], &arr[i]);
    }
}
```

선택 정렬(selection sort) 알고리즘의 특징
--
- 장점
    - 자료 이동 횟수가 미리 결정된다.
- 단점
    - 안정성을 만족하지 않는다.
    - 즉, 값이 같은 레코드가 있는 경우에 상대적인 위치가 변경될 수 있다.

선택 정렬(selection sort)의 시간복잡도
--
- 선택 정렬의 시간복잡도는 모든 케이스에서 동일하게 O(n²)이다.
    - Worst   : O(n²)
    - Average : O(n²)
    - Best    : O(n²)

References
--
> - 삽입 정렬 https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html  
> - 버블 정렬 https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html