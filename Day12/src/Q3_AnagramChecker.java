import java.util.*;

public class Q3_AnagramChecker {
    public static void main(String[] args) {
        String[][] testCases = {
                {"listen", "silent"},
                {"hello", "world"},
                {"triangle", "integral"},
                {"The Eyes", "They See"},
                {"BINARY", "BRAINY"}
        };

        System.out.println("=== ANAGRAM CHECKER ===\n");

        for (String[] testCase : testCases) {
            String s1 = testCase[0];
            String s2 = testCase[1];
            boolean result = isAnagram(s1, s2);
            System.out.println("'" + s1 + "' and '" + s2 + "' are anagrams: " + result);
        }
    }

    private static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll(" ", "").toLowerCase();
        s2 = s2.replaceAll(" ", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> frequencyMap1 = getCharacterFrequency(s1);
        HashMap<Character, Integer> frequencyMap2 = getCharacterFrequency(s2);

        return frequencyMap1.equals(frequencyMap2);
    }

    private static HashMap<Character, Integer> getCharacterFrequency(String str) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }
}

