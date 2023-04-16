import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinearSearch {
    private static final String filePath = "example.txt";

    public static int LinearCount(String word) throws IOException {
        int count = 0;
        String normalizedWord = word.toLowerCase();

        // read the text file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            // split the line into words
            String[] words = line.split("[^a-zA-Z0-9']+");
            for (String w : words) {
                // normalize the word and check if it matches the target word
                if (w.toLowerCase().equals(normalizedWord)) {
                    count++;
                }
            }
        }
        reader.close();

        return count;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String wordToSearch = "the";
        try {
            int count = LinearCount(wordToSearch);
            System.out.println("LinearCount: \"" + wordToSearch + "\" appears " + count + " times.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("Time for LinearCount: " + (endTime - startTime) + " ns");
    }
}