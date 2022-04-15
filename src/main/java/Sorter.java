import java.util.Arrays;

public class Sorter {

    public static int[] insertionSort(int[] arr){
        int n = arr.length, j;
        for(int i = 1; i < n; i++){
            j = i - 1;
            int val = arr[i];
            while(j >= 0 && arr[j] > val){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1;j < arr.length; j++){
                if (arr[i] > arr[j]){
                    //swap
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        return arr;
    }


    public static int[] selectionSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            int largest = findMax(arr,i+1);
            if (largest != i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] arr){
        //TODO Add the code
        return new int[]{3, 2};
    }

    public static int[] heapSort(int[] arr){
        arr = buildHeap(arr);
        for(int i = arr.length-1; i >= 1; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }
        return arr;
    }

    private static int[] buildHeap(int[] arr){
        int n;
        for (n = arr.length/2 - 1; n >= 0; n--){
            arr = heapify(arr, n, arr.length-1);
        }
        return arr;
    }


    private static int[] heapify(int[] arr, int root, int max){
        // root is the index of the head element
        int largest, left, right;
        left = root * 2 + 1;
        right = root * 2 + 2;
        largest = root;

        if (left < max && arr[left] > arr[largest])
            largest = left;
        if (right < max && arr[right] > arr[largest])
            largest = right;

        if (largest != root){
            // swap root and largest
            int temp = arr[largest];
            arr[largest] = arr[root];
            arr[root] = temp;
            arr = heapify(arr, largest, max);
        }
        return arr;
    }

    private static int findMax(int[] arr){
        // returns the index of the largest element
        int largest = 0;
        if (arr.length == 1) return largest;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[largest]) largest = i;
        return largest;
    }

    private static int findMax(int[] arr, int to){
        // returns the index of the largest element between 0 and to
        int largest = 0;
        if (to == 1 || arr.length == 1) return 0;
        for (int i = 0; i < to; i++)
            if (arr[i] > arr[largest]) largest = i;
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(heapSort(new int[]{4, 2, 24, 3, 0, 12, 1, 6, 32, 16})));
    }
}
