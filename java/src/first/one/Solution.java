package first.one;
/*
 *   给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 *   你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 *   你可以按任意顺序返回答案。
 *
 *   来源：力扣（LeetCode）
 *   链接：https://leetcode-cn.com/problems/two-sum
 *   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

import java.util.HashMap;

class Solution {
    // 暴力解法 时间复杂度为O(n²)
    // leetcode上耗时56ms

//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j <nums.length ; j++) {
//                if(nums[j]+nums[i]==target){
//                    return new int[]{j,i};
//                }
//            }
//        }
//        return null;
//    }
    // O(n)
    //leetcode上耗时4ms
//    public int[] twoSum(int[] nums,int target){
//
//        // <元素,索引>
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
//        // 不能和自己相加
//        for (int i = 0; i < nums.length; i++) {
//            int num = target - nums[i];
//            // 如果hashmap中存在另一个数,并且它的索引不是本身,那么便吻合
//            if(map.get(num)!= null && map.get(num)!=i) {
//                return new int[]{i,map.get(num)};
//            }
//        }
//        return null;
//    }

    //再尝试一种新的思路(类似与征婚一样,按自己要求找,找不到,就把自己放进去征婚池一样)
    // leetcode上耗时1ms
    public int[] twoSum(int[] nums,int target){

        // <元素,索引>
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target-nums[i];
            // 如果存在,则匹配成功
            if(map.containsKey(another)){
                return new int[]{i,map.get(another)};
            }
            // 如果不存在,则将自己放进匹配池
            map.put(nums[i],i);
        }

        return null;
    }


    public static void main(String[] args) {
      int[]  nums = {2,7,11,15} ;
        int[] ints = new Solution().twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}