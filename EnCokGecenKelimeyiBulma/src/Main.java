import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin giriniz : ");
        String text = scanner.nextLine();

        text = text.toLowerCase();


        String[] words = text.split("[\\s.,;!?]+");


        Map<String, Integer> wordCounts = new HashMap<>();


        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }


        String mostFrequentWord = null;
        int mostFrequentWordCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > mostFrequentWordCount) {
                mostFrequentWord = entry.getKey();
                mostFrequentWordCount = entry.getValue();
            }
        }


        System.out.println("En çok geçen kelime : " + mostFrequentWord);
        System.out.println("Geçme Sayısı : " + mostFrequentWordCount);
    }
}