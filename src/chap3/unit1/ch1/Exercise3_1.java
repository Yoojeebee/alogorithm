package chap3.unit1.ch1;

// 선형 검색 클래스
// 메서드 seqSearch()는 배열 a의 처음부터 끝까지 n개의 요소를 대상으로 값이 key인 요소를
// 선형 검색하고 검색한 요소의 인덱스를 반환
// 또한, key의 값과 같은 값 여러개를 가지고 있을 경우 검색 과정에서 처음 발결한 요소의
// 인덱스가 반환
public class Exercise3_1 {
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {           // 검색 실패
            if(i == n)
                return -1;
            if(a[i] == key)     // 검색 성공[인덱스 반환]
                return i;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] num = {55, 101, 22, 99, 9, 23, 10, 45};

        int result = seqSearch(num, num.length,45);
        if(result == -1) {
            System.out.println("해당하는 요소 값은 없습니다.");
        } else {
            System.out.println("해당하는 요소 값은 있습니다.");
        }
    }
}
