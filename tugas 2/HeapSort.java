//program tugas 2

package strukdatmateri;
public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Membangun heap (heapify)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Ekstraksi elemen satu per satu dari heap
        for (int i = n - 1; i > 0; i--) {
            // Pindahkan elemen teratas (terbesar) ke akhir array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Panggil heapify pada heap yang dikurangi
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // Inisialisasi largest sebagai root
        int left = 2 * i + 1; // Indeks anak kiri
        int right = 2 * i + 2; // Indeks anak kanan

        // Jika anak kiri lebih besar dari root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Jika anak kanan lebih besar dari largest yang saat ini
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Jika largest tidak lagi root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Rekursif heapify subtree yang terpengaruh
            heapify(arr, n, largest);
        }
    }

    // Metode untuk mencetak array
    void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Contoh penggunaan HeapSort
    public static void main(String args[]) {
        int[] arr = { 9, 5, 2, 7, 1, 3 };
        int n = arr.length;

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        System.out.println("Array setelah diurutkan menggunakan Heap Sort:");
        heapSort.printArray(arr);
    }
}
