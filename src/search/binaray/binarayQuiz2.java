package search.binaray;

public class binarayQuiz2 {
    public static int binSearchX(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;

            // 찾은 자리를 끝점으로 잡은 다음
            // pl 지점부터 차근차근 찾는다
            if(arr[pc] == key) {
                for(int i = pl; i < pc; i++) {
                    if(arr[i] == key)
                        return i;
                }
                return pc;
            }
            else if(arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while(pl <= pr);

        return -1;
    }
}
