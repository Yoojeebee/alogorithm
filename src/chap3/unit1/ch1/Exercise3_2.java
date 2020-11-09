package chap3.unit1.ch1;

// Exercise3_1의 선형 검색 클래스에서
// while문을 for문으로 바꾼 클래스
public class Exercise3_2 {
    static int seqSearch(int[] a, int n, int key) {
        for(int i = 0; i < n; i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {55, 101, 2324, 99, 9, 23, 10, 45};

        int result = seqSearch(num, num.length,45);
        if(result == -1) {
            System.out.println("해당하는 요소 값은 없습니다.");
        } else {
            System.out.println("해당하는 요소 값은 있습니다.");
        }
    }
}
