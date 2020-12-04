package search.linear;

public class linearQuiz {

    public static int seqSearch(int[] arr, int n, int key) {
        // 선형 검색을 위한 배열 인덱스 변수
        int i = 0;

        // 첫 째줄
        System.out.print(" |");
        for(int x = 0; x <= n; x++) {
            System.out.print("\t" + x);
        }

        // 둘 째줄
        System.out.print("\n-+");
        for(int x = 0; x <= n; x++) {
            System.out.print("----");
        }
        System.out.print("\n");

        while(true) {
            // 기호 표시
            System.out.print(" |");
            for(int x = i; x >= 0; x--) {
                System.out.print("\t");
            }
            System.out.print("*\n");

            // 숫자 표시
            System.out.print(i + "|");
            for(int y = 0; y <= n; y++) {
                System.out.print("\t" + arr[y]);
            }
            System.out.print("\n");

            if(i == n)
                return -1;

            if(arr[i] == key) {
                return i;
            }

            i++;
        }
    }

}
