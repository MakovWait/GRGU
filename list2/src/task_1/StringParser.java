package task_1;

public class StringParser {

    public static String[] getWords(String inputText){
        return inputText.replaceAll("[^A-Za-zА-Яа-я]", " ").
                        replaceAll("\\s+", " ").
                        split(" ");
    }

}
