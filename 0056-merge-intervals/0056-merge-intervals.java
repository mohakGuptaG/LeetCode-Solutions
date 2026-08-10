class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<n; i++){
            if(intervals[i][0]<=end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                int[] res = {start, end};
                ans.add(res);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}