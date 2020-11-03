package chap2.unit1.ch1;

public class Exercise11 {
    public static void main(String[] args) {

        int counter = 0;                // 곱셈과 나눗셈의 횟수
        int ptr = 0;                    // 찾은 소수의 개수
        int[] prime = new int[100];     // 소수를 저장하는 배열

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for(int n = 5; n < 100; n+=2) { // 5부터 시작해 100까지 for문을 돌려 소수를 판단
            boolean flag = false;
            for(int i = 1; prime[i] * prime[i] <= n; i++) {
                counter +=2;
                if(n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

    }
}
