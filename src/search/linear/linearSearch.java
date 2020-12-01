package search.linear;

public class linearSearch<E> {

    /**
     * int형 배열을 선형검색 하는 메소드
     * @param arr 선형검색을 실시하는 배열
     * @param n 배열의 요소 수(= 데이터 개수)
     * @param key 배열 arr에서 찾으려는 값
     * @return -1 : 키 값이랑 맞지 않는 경우 / 0이상 : 키 값이랑 맞은 경우
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
