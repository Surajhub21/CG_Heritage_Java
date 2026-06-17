import java.util.*;
import java.util.stream.Collectors;

public class Q5_WordFrequencyAdvanced {
    public static void main(String[] args) {
        String paragraph = "Java is a popular programming language. Java is used for " +
                "building enterprise applications. Programming is fun and challenging. " +
                "Java programming requires practice. The language is powerful and flexible. " +
                "Programming with Java is enjoyable. Learn Java today!";

        System.out.println("=== PARAGRAPH ===");
        System.out.println(paragraph);
        System.out.println();

        analyzeWordFrequency(paragraph);
    }

    private static void analyzeWordFrequency(String paragraph) {
        String cleanedText = paragraph.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        String[] words = cleanedText.split("\\s+");

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        LinkedHashMap<String, Integer> sortedByFrequency = frequencyMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println("=== ALL WORDS AND FREQUENCIES ===");
        for (Map.Entry<String, Integer> entry : sortedByFrequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\n=== TOP 3 MOST FREQUENT WORDS ===");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedByFrequency.entrySet()) {
            if (count < 3) {
                System.out.println((count + 1) + ". " + entry.getKey() + " -> " + entry.getValue() + " times");
                count++;
            } else {
                break;
            }
        }

        System.out.println("\n=== WORDS APPEARING EXACTLY ONCE ===");
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedByFrequency.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        if (uniqueWords.isEmpty()) {
            System.out.println("No words appear exactly once.");
        } else {
            for (String word : uniqueWords) {
                System.out.println("- " + word);
            }
        }

        System.out.println("\n=== BAR CHART OF WORD FREQUENCIES ===");
        displayBarChart(sortedByFrequency);
    }

    private static void displayBarChart(LinkedHashMap<String, Integer> frequencyMap) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (count < 10) {
                System.out.print(String.format("%-15s | ", entry.getKey()));
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print("*");
                }
                System.out.println(" (" + entry.getValue() + ")");
                count++;
            } else {
                break;
            }
        }
    }
}

