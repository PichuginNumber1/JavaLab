import java.util.ArrayList;

public class CountHandler {
    public static ArrayList<Integer> getWordsInLines(ArrayList<String> list) {
        ArrayList<Integer> wordsInLines = new ArrayList<>();
        int wordsInLine;
        for (int i = 0; i < list.size(); i++) {
            wordsInLine = 1;
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == ' ')
                    wordsInLine++;
            }
            wordsInLines.add(wordsInLine);
        }
        return wordsInLines;
    }

    public static int getWordsAmount(ArrayList<Integer> wordsInLines) {
        int wordsAmount = 0;
        for (int i = 0; i < wordsInLines.size(); i++)
            wordsAmount += wordsInLines.get(i);
        return wordsAmount;
    }

    public static int getCharsAmount(ArrayList<String> list) {
        int charsAmount = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++)
                if (list.get(i).charAt(j) != ' ')
                    charsAmount++;
        }
        return charsAmount;
    }


    public static void getAmount(ArrayList<String> list) {
        int charsAmount = getCharsAmount(list);
        ArrayList<Integer> wordsInLines = getWordsInLines(list);
        int wordsAmount = getWordsAmount(wordsInLines);
        App.logger.info("amount of words in lines:\r\n" + wordsInLines.toString() + "\r\namount of words:" + wordsAmount + "\r\namount of letters:" + charsAmount);

    }
}
