# 선형 검색  

- 요소가 직선 모양으로 늘어선 배열에서의 검색  
- 원하는 키 값을 갖는 요소를 만날 때 까지의 맨 앞부터 순서대로 요소를 검색  
<br/>

예) 아래의 배열에서 키 값 3을 선형 검색

![선혐검색](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/linear_search_1.jpg?raw=true)

1. 첫 번째 요소 6을 선택, 원하는 값이 아니다.
2. 두 번째 요소 4를 선택, 원하는 값이 아니다.
3. 세 번째 요소 7을 선택, 원하는 값이 아니다.  
4. 네 번째 요소 3을 건택, 원하는 값이다.  
<br/>

하지만 만약 배열에서 키 값 8을 검색하게 된다면  

![선혐검색](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/linear_search_2.jpg?raw=true)

끝까지 검색을 하더라도 키 값 8을 찾지 못한다.

성공의 예와 실패의 예를 보면 검색 조건의 종료 조건은 2개 임을 알 수 있다.  
> 조건 1. 검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우  
> 조건 2. 검색할 값과 같은 요소를 발견할 경우  

<br/>

### 선형검색을 구현한 코드  
```java
public class linearSearch<E> {

    /**
     * int형 배열을 선형검색 하는 메소드
     * @param arr 선형검색을 실시하는 배열
     * @param n 배열의 요소 수(= 데이터 개수)
     * @param key 배열 arr에서 찾으려는 값
     * @return
     */
    public static int seqSearch(int[] arr, int n, int key) {
        // 선형 검색을 위한 배열 인덱스 변수
        int i = 0;

        while(true) {
            // 선형검색을 실시하면서 찾지 못한 경우
            // 즉, 배열의 0번째 부터 배열의 끝자리 까지 찾지 못한 경우
            // 반환 값 -1을 반환
            if(i == n)
                return -1;

            // 배열 arr의 i번째 자리가 key의 값과 같은 경우
            // 배열의 인덱스 i를 반환
            if(arr[i] == key) {
                return i;
            }

            i++;
        }
    }

}
```
> [1]. i == n  
> 종료조건 1: 검색 실패이므로 -1 반환
>  
> [2]. arr[i] == key
> 종료조건 2: 검색 성공이므로 i를 반환

![linear_code_image](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/linear_searh_3.jpg?raw=true)  

## 보초법
선형 검색의 종료 조건을 검사하는 비용(= 횟수)을 반으로 줄이는 방법  

![보초법1](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/linear_searh_4_1.jpg?raw=true)  

위의 그림은 보초법을 그림으로 나타낸 예시이며 검색하기 전에 검색하고자 하는 키 값을 맨 끝 요소에 추가로 저장하며 이 때, 저장하는 값을 보초(sentinel)라 한다.  
<br/>

아래의 두 그림은 보초를 써 선형검색을 한 예이다.

![보초법2](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/linear_searh_4.jpg?raw=true)  

> 1), 2) 두 배열 모두 각각의 키 값을 검색하기 위해 배열의 끝에 키 값을 저장한다.  

이렇게 원하는 키 값을 찾기 못했을 때 판단하는 조건인 `검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우`가 없어도 된다.  
보초는 반복문에서 종료 판단 횟수를 2회 -> 1회로 줄이는 역할을 한다.   
```java
while(true) {
    if(i == n)
        return -1;

    if(arr[i] == key) {
        return i;
    }

    i++;
}
```
보초를 쓰게 된다면 두 번째 if문 `if(arr[i] == key)` 가 아닌 위의 첫 번째 if문 `if(i==n)`에서 종료되게 된다.  
<br/>

### 선형검색(보초법 포함)을 구현한 코드  
- Sentinel 클래스  
    보초법을 이용한 선형 검색 클래스
```java
public class Sentinel {

    /**
     * int형 배열을 선형검색 하는 메소드
     * @param arr 선형검색을 실시하는 배열(마지막 배열 인덱스 자리의 데이터는 없음)
     * @param n 배열의 요소 수(= 데이터 개수)
     * @param key 배열 arr에서 찾으려는 값
     * @return
     */
    public static int seqSearchSen(int[] arr, int n, int key) {
        // 선형 검색을 위한 배열 인덱스 변수
        int i = 0;

        // 배열 arr의 데이터 개수는 하나가 비어 있으므로
        // 이 비어있는 자리의 인덱스 번호와 n은 같은 값을 가지고 있음
        // 그러므고 arr[n]은 배열의 끝에 데이터를 넣는 것과 같다
        arr[n] = key;

        // 보초를 이용한 선형검색으로 인해 while문 내 조건문 하나가 빠짐
        while(true) {
            if(arr[i] == key)
                break;
            i++;
        }

        return i == n ? -1 : i;
    }
}
```
<br/>

- Main 클래스
```java
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열에 몇 개의 데이터를 넣을 것인지를 입력
        System.out.print("요솟수 입력: ");
        int num = scanner.nextInt();

        // 배열의 끝 자리에 보초를 넣기위해 배열의 길이 num에 +1을 붙임
        int arr[] = new int[num+1];

        // 배열에 들어갈 데이터 입력
        for(int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + "]: ");
            arr[i] = scanner.nextInt();
        }

        // 키 값 입력
        System.out.print("키 값: ");
        int key = scanner.nextInt();

        // 배열의 몇 번째 있는지 알려주는 변수
        int keyIndex = Sentinel.seqSearchSen(arr, num, key);

        if(keyIndex == 1)
            System.out.println("키 값은 배열 arr[" + keyIndex + "]에 있다.");
        else
            System.out.println("그 값의 요소는 없습니다.");
    }
}
```