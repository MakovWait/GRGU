package taks_2;

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
