class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){

            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }

            int j=i+1, k=nums.length-1;
            while(j<k){

                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else{
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);

                   
                        list.add(ans);
                    
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                    
                }
            }
        }
        return list;
    }
}