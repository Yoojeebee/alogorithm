package chap3.unit1.ch1;

// 이진 검색
public class Exercise3_4 {
    static int binSearch(int[] a, int n, int key) {
        int head = 0;       // 배열의 첫 번째 인덱스
        int tail = n - 1;   // 배열의 마지막 인덱스

        do {
            int center = (head + tail) / 2; // 배열의 중간 인덱스
            if(a[center] == key)
                return center;
            else if(a[center] < key)
                head = center + 1;
            else
                tail = center - 1;
        } while(head <= tail);

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {11, 18, 20, 22, 29, 38, 42, 51, 70, 89, 100};

        int binSearch = binSearch(numbers, numbers.length, 51);
        if(binSearch == -1)
            System.out.println("검색 실패!");
        else {
            System.out.println("검색 성공!");
        }
    }
}
