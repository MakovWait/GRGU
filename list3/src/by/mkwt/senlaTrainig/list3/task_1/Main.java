package by.mkwt.senlaTrainig.list3.task_1;

public class Main {
    /*
    Вариант 3
    */
    public static void main(String[] args) {
        String text = "dsfdsfds,,,ss22, dsfsdf,   _sf";
        String[] words = StringParser.getWords(text);
        
        for (String word : words) {
            System.out.println(word);
        }
    }
}
