package first.three;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    //通过linkedlist来记录正在处理的字串,最大的问题在于链表的contains是o(n)复杂度，导致整个计算复杂度为o(n2)
    //[]
    //[d]
    //[d->v]
    //[v->d]
    //[v->d->f]
    //max记录最大字串的长度
    public int lengthOfLongestSubstring2(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int max = 0;
        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (list.contains(data[i])) {
                list.addLast(data[i]);
                while (list.size() > 1 && !list.getFirst().equals(data[i])) {
                    list.removeFirst();
                }
                if (list.size() > 1 && list.getFirst().equals(data[i])) {
                    list.removeFirst();
                }
            } else {
                list.addLast(data[i]);
                max = Math.max(max, list.size());
            }
        }
        return max;
    }
    //使用滑动窗口的思路
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;
        int max = 0;
        while (r + 1 < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(r + 1)]++;
                r = r + 1;
            } else {
                freq[s.charAt(l)]--;
                l = l + 1;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    //上述滑动窗口没有快速拨动l指针而是挨个遍历的，使用数组存储索引来快速拨动l指针
    public int lengthOfLongestSubstring3(String s) {

        int[] index = new int[256];
        Arrays.fill(index,-1);
        int l = 0,r = -1, max=0;
        while(r+1<s.length() ){
            r ++;
            if(index[s.charAt(r)]!=-1){
                //防止l指针回拨（l只能越来越大）
                l = Math.max(l,index[s.charAt(r)]+1);
            }
            //存入r指针对应的数据索引
            index[s.charAt(r)] = r;
            max = Math.max(max,r-l+1);
        }
        return max;
    }


        public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(new Solution().lengthOfLongestSubstring3(s));
    }
}
