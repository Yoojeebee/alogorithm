package chap2.unit1.ch1;

public class PraticeQ7 {
    static public char[] convertNumber(int decimalNumber, int convertNumber) {
        int digitNumber = 0;
        String convert = "0123456789ABCDEF";
        char[] digit = new char[16];

        do {
            if(digitNumber == 0)
                System.out.println(convertNumber + "|\t\t" + decimalNumber);
            int rest = decimalNumber % convertNumber;
            digit[digitNumber++] = convert.charAt(decimalNumber % convertNumber);
            decimalNumber = decimalNumber / convertNumber;
            System.out.println(" +--------");
            System.out.println(convertNumber + "|\t\t" + decimalNumber + "..." + (rest));
        } while(decimalNumber != 0);

        for(int i = 0; i < digit.length / 2; i++) {
            char temp = digit[digit.length - i - 1];
            digit[digit.length - i - 1] = digit[i];
            digit[i] = temp;
        }

        System.out.print(convertNumber + "진수: ");
        for(int i = 0; i < digit.length; i++) {
            if(digit[i] != ' ')
                System.out.print(digit[i] + "");
        }
        System.out.println();

        return digit;
    }

    public static void main(String[] args) {
        char[] digit = convertNumber(59, 2);

        int count = 0;
        int total = 0;
        for(int i = digit.length - 1; i >= 0; i--) {
            if(digit[i] == '1') {
                total += Math.pow(2, count++);
            } else if(digit[i] == '0') {
                count++;
            }
        }
        System.out.println(total);
    }
}
