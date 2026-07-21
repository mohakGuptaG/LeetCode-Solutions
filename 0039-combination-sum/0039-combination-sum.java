class Solution {

    public void backtrack(int[] candidates, int index, int remaining,
                          List<Integer> current, List<List<Integer>> result) {

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0 || index == candidates.length) {
            return;
        }

        current.add(candidates[index]);
        backtrack(candidates, index, remaining - candidates[index], current, result);

        current.remove(current.size() - 1);

        backtrack(candidates, index + 1, remaining, current, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, 0, target, current, result);

        return result;
    }
}