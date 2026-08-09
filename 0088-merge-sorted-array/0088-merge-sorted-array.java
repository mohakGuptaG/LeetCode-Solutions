class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - nums2.length - 1;
        int j = nums2.length-1;
        int x = nums1.length-1;

        while(k>=0 && j>=0){
            if(nums1[k]>nums2[j]){
                nums1[x] = nums1[k];
                k--;
            }
            else{
                nums1[x] = nums2[j];
                j--;
            }
            x--;
        }

        while(j>=0){
            nums1[x] = nums2[j];
            x--;
            j--;
        }
    }
}