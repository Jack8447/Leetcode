import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        /*
         * Given an array of integers nums and an integer target, return indices of the
         * two numbers such that they add up to target.
         * 
         * You may assume that each input would have exactly one solution, and you may
         * not use the same element twice.
         * 
         * You can return the answer in any order.
         * 
         * ex:
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         */
        int[] nums = { 2, 7, 11, 15 };

        // just print out the answer of the function
        int[] ans = solution(nums, 9);
        for (int n : ans) {
            System.out.println(n);
        }
    }

    /*
     * Here I use a hashmap, the strategy is simple.
     * One: it is assumed that there will always be an answer to the target within
     * the array, therefore I can instantly process a return clause and return an
     * empty array
     * Two: I can use a hashmap to determine the desired indices.
     * I start the loop by instantly checking if there is a key within the map that
     * currently contains the i'th value of nums,
     * if it does I have my answer, and can return the value of that key, along with
     * the current i'th iteration.
     * This works as the map stores keys by first taking the target value and
     * subtracting by the current i'th nums value.
     * 
     * For example assume the array only contains [3,3] with the target being 6
     * the first iteration it checks if the map contains a key with that nums i'th
     * value it does not, so it moves onto the second
     * clause, which is to populate it into the map. The map populates this key by
     * taking the target (6) and subtracting it by the nums[i'th] value (3)
     * now the map stores the key as (6-3) = 3 therefore, the first key in the map
     * is 3 and the value maped to that key is 0.
     * For the second iteration (3), the map checks if there is a key value for that
     * map (there is). Since that value is already stored within the map
     * the function returns a new array, whose first indice is the value(indice) of
     * the initially stored map value, followed by the current i'th iteration ->
     * I.E; [0,1]
     */
    private static int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }

        return new int[] {};
    }
}