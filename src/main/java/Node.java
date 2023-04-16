public class Node {
    String word;
    int count;
    Node left;
    Node right;

    public Node(String word) {
        this.word = word;
        this.count = 1;
        left = null;
        right = null;
    }
}
