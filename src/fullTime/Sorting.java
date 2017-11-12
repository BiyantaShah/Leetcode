package fullTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Biyanta on 11/09/17.
 */
public class Sorting {

    public static void main(String[] args) {

        int [] arr = {6,2,0,5,1};
        System.out.println("Before fullTime.Sorting");
        for (int a : arr) {
            System.out.print(a +" ");
        }
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        quickSort(arr, 0, arr.length-1);

        mergeSort(arr, 0, arr.length-1);


        System.out.println();

        System.out.println("After fullTime.Sorting");
        for (int a : arr) {
            System.out.print(a +" ");
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {

            int mid= (low+high)/2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);

            merge(arr, low, mid, high);
        }


    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
        int [] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i ++) {
            left[i] = arr[low+ i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1+ i];
        }

        int k = low, i=0, j=0;

        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;

            }
            else   {
                arr[k] = right[j];
                j++;
                k++;

            }

        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }


        }


    private static void quickSort(int[] arr, int low, int high) {

        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        int mid = (low + high)/2;
        int pivot = arr[mid];

        int i = low, j = high;

        while (i <= j) {

            while (arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if ( i <= j) {
                int temp = 0;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }



    private static void insertionSort(int[] arr) {

        int i = 1;

        while (i < arr.length) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
            i++;
        }
    }

    private static void selectionSort(int[] arr) {

        int i = 0, j = 0;

        int iMin = 0;

        for (j = 0; j < (arr.length - 1);j++) {
            iMin = j;

            for (i = j+1; i <arr.length; i++) {

                if (arr[i]< arr[iMin]) {
                    iMin = i;
                }
            }

            if (iMin != j) {
                int temp = 0;

                temp = arr[iMin];
                arr[iMin] = arr[j];
                arr[j] = temp;

            }
        }
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length-i); j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = 0;

                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

}
