//program tugas 3

package strukdatmateri;
import java.util.*;

class Graph {
    private int V; // Jumlah simpul (vertices)
    private LinkedList<Integer>[] adjacencyList; // Daftar ketetanggaan graf

    // Constructor
    public Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adjacencyList[i] = new LinkedList();
    }

    // Menambahkan edge (sisi) pada graf
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Implementasi DFS menggunakan Stack
    void DFS(int start) {
        boolean[] visited = new boolean[V]; // Array untuk menandai simpul yang telah dikunjungi
        Stack<Integer> stack = new Stack<>(); // Stack untuk menyimpan simpul yang akan diperiksa selanjutnya

        stack.push(start); // Memasukkan simpul awal ke dalam stack

        while (!stack.empty()) {
            int current = stack.pop(); // Mengambil simpul teratas dari stack

            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                Iterator<Integer> iterator = adjacencyList[current].iterator();
                while (iterator.hasNext()) {
                    int neighbor = iterator.next();
                    if (!visited[neighbor])
                        stack.push(neighbor); // Menambahkan tetangga yang belum dikunjungi ke dalam stack
                }
            }
        }
    }

    // Implementasi BFS menggunakan Queue
    void BFS(int start) {
        boolean[] visited = new boolean[V]; // Array untuk menandai simpul yang telah dikunjungi
        Queue<Integer> queue = new LinkedList<>(); // Queue untuk menyimpan simpul yang akan diperiksa selanjutnya

        visited[start] = true;
        queue.add(start); // Memasukkan simpul awal ke dalam queue

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Mengambil simpul pertama dari queue
            System.out.print(current + " ");

            Iterator<Integer> iterator = adjacencyList[current].iterator();
            while (iterator.hasNext()) {
                int neighbor = iterator.next();
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor); // Menambahkan tetangga yang belum dikunjungi ke dalam queue
                }
            }
        }
    }

    // Contoh penggunaan DFS dan BFS
    public static void main(String args[]) {
        Graph graph = new Graph(7); // Membuat graf dengan 7 simpul

        // Menambahkan edge (sisi) pada graf
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.print("DFS traversal: ");
        graph.DFS(0); // Memulai DFS dari simpul 0
        System.out.println();

        System.out.print("BFS traversal: ");
        graph.BFS(0); // Memulai BFS dari simpul 0
        System.out.println();
    }
}
