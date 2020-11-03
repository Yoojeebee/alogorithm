package chap2.unit1.ch1;

public class Exercise9 {
    public static void main(String[] args) {

        // 나눗셈의 횟수
        int counter = 0;

        // 2부터 시작해 소수를 판단하는 for문
        // int n은 소수인지를 판별하기 위해 올라가는 변수
        // int i는 소수인지를 판별하기 위해 n보다 작은 수를 i로 나누어 0인지 판단
        for(int n = 2; n <= 100; n++) {
            int i;
            for(i = 2; i < n; i++) {
                counter++;
                if(n % i == 0) {
                    break;
                }
            }
            if(n == i) {
                System.out.println(n);
            }
        }

    }
}
