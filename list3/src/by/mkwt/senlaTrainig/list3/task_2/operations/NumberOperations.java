package by.mkwt.senlaTrainig.list3.task_2.operations;

public class NumberOperations {

    public static int[] getDigits(int number) {
        int[] digits = new int[3];

        for (int i = 0; number > 0; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }
}
