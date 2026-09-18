public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc"};

        for (String input : testInputs) {
            char result = findFirstNonRepeatingChar(input);
            System.out.println("Input: \"" + input + "\"");

            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
            System.out.println();
        }
    }
}