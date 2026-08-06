class Solution {
    public static void msort(int[] arr, int low, int high){
        if(low<high){
            int pivotIndex = func(arr, low, high);
            msort(arr, low, pivotIndex-1);
            msort(arr, pivotIndex+1, high);
        }

        return;
    }

    public static int func(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;
        while(i<j){
            while(arr[i]<=pivot && i<high){
                i++;
            }

            while(arr[j]>pivot && j>low){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } 
        }
                int temp = arr[j];
                arr[j] = arr[low];
                arr[low] = temp;
        return j;
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        msort(nums, low, high);
        return;
    }
}