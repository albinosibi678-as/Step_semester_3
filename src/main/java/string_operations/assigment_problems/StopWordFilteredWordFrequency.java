import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class StopWordFilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        List<String> stopWordList = new ArrayList<>();
        for (String sw : stopWords) {
            stopWordList.add(sw);
        }

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (stopWordList.contains(word)) {
                continue;
            }

            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}