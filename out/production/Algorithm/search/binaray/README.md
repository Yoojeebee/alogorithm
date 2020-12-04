# 이진 검색  
> 조건 : 데이터가 이미 정렬(sort) 되어 있다는 것  

요소가 오름차순 또는 내림차순으로 정렬된 배열에서 검색하는 알고리즘.  
선형 검색보다 좀 더 빠르게 검색할 수 있다는 장점이 있다.  

아래의 그림은 n개의 요소가 오름차순 혹은 내림차순으로 늘어선 배열에서 키 값을
 이진 검색으로 검색하는 과정을 그림으로 표현한 것  

- pl : 검색 범위의 맨 앞 인덱스
- pr : 검색 범위의 맨 끝 인덱스
- pc : 검색 범위의 중앙 인덱스  

검색 시작시 `pl`은 0, `pr`은 n-1, `pc`는 (n-1)/2로 초기화 된다.  
검색 범위의 대상은 회색을 제외한 나머지 색 안의 요소

아래의 그림은 `pl`, `pc`, `pr` 의 위치를 예시적으로 표시한 것

![이진검색_그림2](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/binary_image_2.jpg?raw=true)  
<br/>

밑의 그림은 이진 검색을 한 단계식 진행할 때 마다 검색하는 과정을 그림으로 표현한 것  
> 키 값: 39  
> 주황색 박스가 = pc
 
![이진검색_그림1](https://github.com/Yoojeebee/alogorithm/blob/master/src/images/binary_image_1.jpg?raw=true)  
  
여기서 주목할 점은 이진 검색을 한 단계식 진행할 때마다 검색 범위가 (거의)반으로 좁혀진다는 것  

또한 검사한 요소를 하나씩 제외시키는 선형 검색과는 다르게 이진 검색은 검색한 요소가 해당 단계에서 검색할 범위의 중간 지점으로 단숨에 이동   
<br/>

위의 그림과정을 설명하자면

1. <strong>arr[pc] < key</strong> 일 때  
    arr[pl] 혹은 arr[pc]이 키 값 보다 작으므로 제외하고 검색 범위는 중앙 요소
     arr[pc]보다 뒤쪽의 arr[pc + 1] ~ arr[pr]로 좁힌다. 그런 다음 `pl`의 값을
     `pc + 1`로 업데이트(`1` -> `2`)  

2. <strong>a[pc] > key</strong> 일 때  
    arr[pc] 혹은 arr[pr]이 키 값 보다 크기 때문에 검색 대상에서 제외
    검색 범위는 중앙 요소 arr[pc]보다 앞쪽 arr[pl] ~ arr[pc-1]로 좁혀진다. 
    `pr`의 값을 `pc - 1`로 업데이트(`2` - > `3`)  
<br/>

이진 검색 알고리즘의 종료 조건은 `1`, `2` 중 하나만 성립하면 된다.
> 1. arr[pc]와 키 값이 일치하는 경우  
> 2. 검색 범위가 더 이상 없는 경우  

### 이진검색을 구현한 코드  
```java
public class binarySearch {

    /**
     * int형 배열을 이짐검색 하는 메소드
     * @param arr 이진검색을 실시하는 배열
     * @param n 배열의 요소 수(= 데이터 개수)
     * @param key 배열 arr에서 찾으려는 값
     * @return -1 : 키 값이랑 맞지 않는 경우 / 0이상 : 키 값이랑 맞은 경우
     */
    public static int binSearch(int[] arr, int n, int key) {
        // 배열의 맨 앞 인덱스
        int pl = 0;
        // 배열의 맨 뒤 인덱스
        int pr = n - 1;
        // int pr = arr.length - 1; 또한 가능

        do {
            // 검색 범위의 중앙 인덱스
            int pc = (pl + pr) / 2;

            // 중앙 인덱스의 값이 키 값과 같을 경우
            if(arr[pc] == key)
                return pc;
            // 중앙 인덱스의 값이 키 값보다 작은 경우 배열의 맨 앞 인덱스 pl의 값을
            // 중앙 인덱스 값 보다 1 높게 잡는다(검색의 범위를 반으로 줄임)
            else if(arr[pc] < key)
                pl = pc + 1;
            // 중앙 인덱스의 값이 키 값보다 큰 경우 배열의 맨 뒤 인덱스 pr의 값을
            // 중앙 인덱스 값 보다 1 낮게 잡는다(검색의 범위를 반으로 줄임)
            else
                pr = pc - 1;
        } while(pl <= pr); /* 인덱스가 겹치는지 아닌지를 확인하는 것, 인덱스가 겹치면 검색이 끝났다는 의미 */

        return -1;
    }
}
```
