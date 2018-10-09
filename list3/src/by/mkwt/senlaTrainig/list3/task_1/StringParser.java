package by.mkwt.senlaTrainig.list3.task_1;

public class StringParser {

    public static String[] getWords(String inputText) {
        return inputText.replaceAll("[^A-Za-zА-Яа-я]", " ")
                .replaceAll("\\s+", " ")
                .split(" ");
    }

}
