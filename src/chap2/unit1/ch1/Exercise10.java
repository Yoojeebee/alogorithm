package chap2.unit1.ch1;

public class Exercise10 {
    public static void main(String[] args) {
        int counter = 0;                // 나눗셈의 횟수
        int ptr = 0;                    // 찾은 소수의 개수
        int[] prime = new int[100];     // 소수를 저장하는 배열

        prime[ptr++] = 2;               // 2는 소수이기에 0번째 자리에 바로 초기화

        for(int n = 3; n < 100; n+=2) { // 홀수의 소수를 찾기위한 for문
            int i;
            for(i = 1; i < ptr; i++) {  // prime배열에 들어가 있는 소수를 통해 소수인지를 판단 i는 배열의 인덱스
                counter++;
                if(n % prime[i] == 0) {
                    break;
                }
            }
            if(ptr == i) {              // 배열의 모든 소수값을 통해 나눴음에도 나눠지지 않으면 그게 바로 소수
                prime[ptr++] = n;
            }
        }

        for(int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }
    }
}
