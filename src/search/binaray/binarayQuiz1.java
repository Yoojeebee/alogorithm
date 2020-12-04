package search.binaray;

public class binarayQuiz1 {

    public static int binSearch(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        // 첫 째줄
        System.out.print(" |");
        for(int i = 0; i < n; i++) {
            System.out.print("\t" + i);
        }
        System.out.print("\n");

        // 둘 째줄
        System.out.print("-+");
        for(int i = 0; i < n; i++) {
            System.out.print("----");
        }
        System.out.print("\n");

        do {

            int pc = (pl + pr) / 2;

            // 기호 표시
            System.out.print(" |");
            for(int i = pl; i < arr.length; i++) {
                System.out.print("\t");
                if(i == pl)
                    System.out.print("<");
                if(i == pc)
                    System.out.print("*");
                if(i == pr) {
                    System.out.println(">");
                    break;
                }
            }

            // 숫자 표시
            System.out.print(arr[pc] + "|");
            for(int y = 0; y < n; y++) {
                System.out.print("\t" + arr[y]);
            }
            System.out.print("\n");

            if(arr[pc] == key)
                return pc;
            else if(arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while(pl <= pr); /* 인덱스가 겹치는지 아닌지를 확인하는 것, 인덱스가 겹치면 검색이 끝났다는 의미 */

        return -1;
    }

}
