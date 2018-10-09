package by.mkwt.senlaTrainig.list3.task_2;

import by.mkwt.senlaTrainig.list3.task_2.operations.DigitOperations;
import by.mkwt.senlaTrainig.list3.task_2.operations.NumberOperations;
import by.mkwt.senlaTrainig.list3.task_2.random.Randomizer;

public class Main {
    /*
    Вариант 1
    */
    public static void main(String[] args) {
        int num = Randomizer.getNaturalTripleNumber();

        System.out.println(num);
        System.out.print(DigitOperations.max(NumberOperations.getDigits(num)));
    }
}
