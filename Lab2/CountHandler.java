import java.util.ArrayList;

public class CountHandler implements Runnable {
    ArrayList<String> list;

    CountHandler(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<Integer> getWordsInLines() {
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

    public int getWordsAmount(ArrayList<Integer> wordsInLines) {
        int wordsAmount = 0;
        for (int i = 0; i < wordsInLines.size(); i++)
            wordsAmount += wordsInLines.get(i);
        return wordsAmount;
    }

    public int getCharsAmount() {
        int charsAmount = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++)
                if (list.get(i).charAt(j) != ' ')
                    charsAmount++;
        }
        return charsAmount;
    }

    @Override
    public void run() {
        int charsAmount = getCharsAmount();
        ArrayList<Integer> wordsInLines = getWordsInLines();
        int wordsAmount = getWordsAmount(wordsInLines);
        synchronized (App.monitor) {
            App.logger.info("amount of words in lines:\r\n" + wordsInLines.toString() + "\r\namount of words:" + wordsAmount + "\r\namount of letters:" + charsAmount);
        }
        Thread.interrupted();
    }
}
