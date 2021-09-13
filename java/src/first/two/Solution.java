package first.two;

/**
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        head.next = addTwoNumbers(l1,l2,0,head.next);
        return head.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int i,ListNode res) {
        res = new ListNode();
        if(l1==null && l2 ==null ){
            if(i!=0){
                res.val = i;
                return res;
            }
            return null;
        }
        if(l1==null){
            int gewei  = (l2.val+i)%10;
            int shiwei = (l2.val+i)/10;
            res.val = gewei;
            res.next = addTwoNumbers(null,l2.next,shiwei,res.next);
        }
        if(l2==null){
            int gewei  = (l1.val+i)%10;
            int shiwei = (l1.val+i)/10;
            res.val = gewei;
            res.next = addTwoNumbers(l1.next,null,shiwei,res.next);
        }
        if(l1 !=null && l2 !=null){
            int gewei  = (l1.val+l2.val+i)%10;
            int shiwei = (l1.val+l2.val+i)/10;
            res.val = gewei;
            res.next = addTwoNumbers(l1.next,l2.next,shiwei,res.next);
        }
        return res;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6,new ListNode(6,new ListNode(6,new ListNode(6))));
        ListNode b =  new ListNode(6,new ListNode(6));
        ListNode res = new Solution().addTwoNumbers(a, b);

        while(res != null){
            System.out.println(res.val);
            res =res.next;
        }
    }
}