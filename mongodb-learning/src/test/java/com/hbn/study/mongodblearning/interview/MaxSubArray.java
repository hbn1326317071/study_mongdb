package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae MaxSubArray
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/13 8:47
 * @Version 1.0
 * 这同样是一个动态规划的题目。我们只需要一个局部最大值，然后一个全局最大值即可。关键是局部最优值的来源是什么。
 * 主要有2，1是当前值，另一个是之前的局部最大值+当前值。那么看局部最大值是来源于哪即可，然后再和全局最优进行比较。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));

    }

    public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
//        全局最大
        int max=Integer.MIN_VALUE;
//        局部最大
        int tempmax=0;
        for(int i=0;i<nums.length;i++){
            tempmax=tempmax+nums[i];
            //状态转移    判断 求和后的值 是否大于 求和前的值
            tempmax=tempmax>nums[i]?tempmax:nums[i];
            //和全局比较   记录出全局最大值
            max=max>tempmax?max:tempmax;
        }
        return max;
    }
//    求出乘积的最大值
//    和第一题思路一样，只不过这里要考虑正负值，因为负负得正，这样最小值有可能直接变成最大值了。
    public int maxProduct(int[] nums) {
        if(nums==null){
            return 0;
        }
        int max=nums[0];
        int min=nums[0];
        int globalmax=nums[0];
        //int globalmin=nums[0];
        for(int i=1;i<nums.length;i++){
            int tempmax=max*nums[i];
            int tempmin=min*nums[i];
            //如果最小值和最大值互换了
            if(tempmin>tempmax){
                int temp=tempmax;
                tempmax=tempmin;
                tempmin=temp;
            }
            //局部最大，局部最小
            max=tempmax>nums[i]?tempmax:nums[i];
            min=tempmin<nums[i]?tempmin:nums[i];
            //全局最大
            globalmax=globalmax>max?globalmax:max;
            //全局最小
            //globalmin=globalmin<min?globalmin:min;
        }
        return globalmax;
    }

}
