package first.five;

class Solution {
    public String longestPalindrome(String s) {
        //使用动态规划
        //？？什么是回文串 -- 左边等于右边（只有一个的时候左边就是右边），在此基础上继续左边等于右边
        int size = s.length();
        if (size<2){
            return s;
        }
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[size][size];
        //单个字符都是回文串
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
        }
        //从一次2位开始
        for (int length = 2; length <= size; length++) {
            for (int i = 0; i < size; i++) {
                int j = i+length-1;
                if(j>=size){
                    break;
                }
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1>max){
                    start = i;
                    max = j-i+1;
                }
            }
        }
        return s.substring(start, start+max);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindrome(s));
    }
}