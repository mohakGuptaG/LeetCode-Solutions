class Solution {
    public static int[] myfunc(int[] a , int[] b){
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<a.length; i++){
            if(!mp.containsKey(a[i])){
                mp.put(a[i], 1);
            }
            else{
                mp.put(a[i], mp.get(a[i])+1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<b.length; i++){
            if(mp.containsKey(b[i])){
                mp.put(b[i], mp.get(b[i])-1);
                arr.add(b[i]);
                if(mp.get(b[i])==0){
                    mp.remove(b[i]);
                }
            }

        }

        int[] nep = new int[arr.size()];

        for(int k=0; k<nep.length; k++){
            nep[k] = arr.get(k);
        }

        return nep;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1.length < nums2.length){
        return myfunc(nums1, nums2);
       }
       else{
        return myfunc(nums2, nums1);
       }
    }
}