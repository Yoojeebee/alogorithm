package chap1.unit1.ch2;

public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("----- 곱셈표 -----");

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}
