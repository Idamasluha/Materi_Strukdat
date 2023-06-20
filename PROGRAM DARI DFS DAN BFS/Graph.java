package coba.modul.pkg6;

import java.util.*;


public class Graph {
    private int node;
    private List<List<Integer>> adjacencyList;

    public Graph(int node) {
        this.node = node + 1; // Tambahkan 1 untuk memperluas ukuran adjacencyList
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < this.node; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
    }

    public void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adjacencyList.get(v)) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    public void DFSTraversal(int v) {
        boolean[] visited = new boolean[node];
        DFS(v, visited);
        System.out.println();
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[node];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            for (int n : adjacencyList.get(v)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6); // Mengubah ukuran graf menjadi 6

        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        System.out.println("Hasil DFS :");
        graph.DFSTraversal(1);

        System.out.println("Hasil BFS :");
        graph.BFS(1);
    }
}
