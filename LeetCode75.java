'''Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library''''s sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

 

Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.'''

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        
    }

    // Qiuick Sort Lumonto Algorithm
    static void quickSort(int[] arr, int  low, int high){

        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    // Pivot Finding
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr,i, j);
            }
        }

        swap(arr, i+1, high);
        return i+1;
    }
    
    // Swapping of numbers
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}