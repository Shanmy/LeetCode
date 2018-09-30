class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap is a data structure and has O(1) time complexity for get() and put()
        HashMap<Integer, Integer> searchMap = new HashMap<Integer, Integer>(nums.length);
        for(int i=0; i<nums.length; i++) {
            // expect value as keys, original indices as values.
            searchMap.put(target-nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
            if(searchMap.containsKey(nums[i]) && i!=searchMap.get(nums[i])) {
                // if the int is expected and not the same index
                return new int[] {i, searchMap.get(nums[i])};
            }
        }
        return null;
    }
}