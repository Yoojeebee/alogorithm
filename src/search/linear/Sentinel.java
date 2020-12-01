package search.linear;

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
