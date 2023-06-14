//program tugas 1

package strukdatmateri;
class AVLNode {
    int key;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class AVLTree {
    AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = insertNode(this.root, key);
    }

    private AVLNode insertNode(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else {
            node.right = insertNode(node.right, key);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.left;
        AVLNode temp = newRoot.right;

        newRoot.right = node;
        node.left = temp;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.right;
        AVLNode temp = newRoot.left;

        newRoot.left = node;
        node.right = temp;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    public void printTreeInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(AVLNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Menambahkan simpul ke dalam AVL Tree
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(12);
        tree.insert(25);
        
        // Menambahkan simpul 30 ke dalam AVL Tree
        tree.insert(30);

        // Menampilkan AVL Tree dalam urutan
        System.out.println("AVL Tree:");
        tree.printTreeInOrder();
    }
}
