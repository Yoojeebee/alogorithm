package chap3.unit1.ch1;

public class Exercise3_1 {

    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {
            if(i == n)
                return -1;
            if(a[i] == key)
                return i;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] num = {55, 101, 2324, 99, 9, 23, 10, 45};

        System.out.println(num.length);
        int result = seqSearch(num, num.length,45);
        if(result == -1) {
            System.out.println("해당하는 요소 값은 없습니다.");
        } else {
            System.out.println("해당하는 요소 값은 있습니다.");
        }
    }
}
