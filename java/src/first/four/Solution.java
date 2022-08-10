package first.four;


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n = nums1.length, m =nums2.length;
       int a = select(nums1,0,n-1,nums2,0,m-1,(n+m)/2);
       if ((n+m)%2==1){
           return a;
       }
       int b = select(nums1,0,n-1,nums2,0,m-1,(n+m-1)/2);
       return (a+b)/2.0;
    }

    //在两个数组中找出第k小的元素
    private int select(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        if(l1>r1) {
            return nums2[l2+k];
        }
        if(l2>r2) {
            return nums1[l1+k];
        }
        int m1 = (r1-l1+1)/2, m2 = (r2-l2+1)/2;
        int e1 = nums1[l1+m1], e2 = nums2[l2+m2];
        if(m1+m2<k){
            if(e1>e2){
                return select(nums1,l1,r1,nums2,l2+m2+1,r2,k-m2-1);
            }else {
                return select(nums1,l1+m1+1,r1,nums2,l2,r2,k-m1-1);
            }
        }else {
            if(e1>e2){
                return select(nums1,l1,l1+m1-1,nums2,l2,r2,k);
            }else{
                return select(nums1,l1,r1,nums2,l2,l2+m2-1,k);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2}, nums2 = {1,2,3};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }


}