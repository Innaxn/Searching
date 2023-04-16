import java.io.*;

public class CountWordOccurrencesBinarySearch {
    private static final String filePath = "example.txt";

    public static void main(String[] args) {
        String wordToSearch = "the";
        long startTime = System.nanoTime();

        BinarySearchTree bst = CountWordOccurrencesBinarySearch.createBinarySearchTreeFromFile(filePath);
        int count = bst.binaryCount(wordToSearch);
        System.out.println("BinaryCount: \"" + wordToSearch + "\" appears " + count + " times.");
        long endTime = System.nanoTime();
        System.out.println("Time for BinaryCount: " + (endTime - startTime) + " ns");
        bst.printTree();

    }

    private static BinarySearchTree createBinarySearchTreeFromFile(String filePath) {
        BinarySearchTree bst = new BinarySearchTree();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]+");

                // Insert each word into binary search tree
                for (String word : words) {
                    if (!word.isEmpty()) {
                        bst.insert(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return bst;
    }
}

