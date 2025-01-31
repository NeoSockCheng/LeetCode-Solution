package Template;


public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;

        // Perform passes over the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // Swap elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}

    // early exit version
    // public class BubbleSort {
    //     public void bubbleSortOptimized(int[] nums) {
    //         int n = nums.length;

    //         for (int i = 0; i < n - 1; i++) {
    //             boolean swapped = false;

    //             for (int j = 0; j < n - 1 - i; j++) {
    //                 if (nums[j] > nums[j + 1]) {
    //                     // Swap elements
    //                     int temp = nums[j];
    //                     nums[j] = nums[j + 1];
    //                     nums[j + 1] = temp;
    //                     swapped = true;
    //                 }
    //             }

    //             // If no elements were swapped, the array is sorted
    //             if (!swapped) {
    //                 break;
    //             }
    //         }
    //     }
    // }



/*
 * Time complexity: O(n^2)
 * Not really useful, but is ok for small arrays
 */
