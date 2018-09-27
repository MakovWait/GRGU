package taks_2;

public class NumberOperations {

    public static int[] getDigits(int number){
        int[] digits = new int[3];
        int i = 0;

        while(number > 0){
            digits[i] = number % 10;
            number /= 10;
            i++;
        }

        return digits;
    }
}
