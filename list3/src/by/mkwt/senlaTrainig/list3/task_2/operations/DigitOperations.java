package by.mkwt.senlaTrainig.list3.task_2.operations;

public class DigitOperations {
    public static int max(int[] digits) {
        if (digits != null) {
            int maxValue = digits[0];

            for (int i = 1; i < digits.length; i++) {
                if (maxValue < digits[i]) {
                    maxValue = digits[i];
                }
            }
            return maxValue;
        }
        return 0;
    }
}
