public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String word) {
        if (root == null) {
            root = new Node(word);
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            int cmp = word.compareToIgnoreCase(current.word);
            if (cmp == 0) {
                current.count++;
                return;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        Node newNode = new Node(word);
        if (word.compareToIgnoreCase(parent.word) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public int binaryCount(String word) {
        Node current = root;
        while (current != null) {
            int cmp = word.compareToIgnoreCase(current.word);
            if (cmp == 0) {
                return current.count;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return 0;
    }


    public void printTree() {
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(Node current, String indent, boolean last) {
        if (current == null) {
            return;
        }
        System.out.print(indent);
        if (last) {
            System.out.print("L");
            indent += "  ";
        } else {
            System.out.print("|-");
            indent += "|";
        }
        System.out.println(current.word + " (" + current.count + ")");
        printTreeHelper(current.left, indent, false);
        printTreeHelper(current.right, indent, true);
    }
}