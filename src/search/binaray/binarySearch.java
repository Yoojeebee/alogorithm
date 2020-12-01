package search.binaray;

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
