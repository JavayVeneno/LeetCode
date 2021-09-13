package _01_100

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	resNode := ListNode{0, nil}
	resNode.Next = add(l1, l2, resNode.Next, 0)
	return resNode.Next
}

func add(l1 *ListNode, l2 *ListNode, res *ListNode, carry int) *ListNode {
	res = &ListNode{0, nil}
	if l1 == nil && l2 == nil {
		if carry == 0 {
			return nil
		}
		res.Val = carry
		return res
	}
	if l1 != nil && l2 == nil {
		geiwei := (l1.Val + carry) % 10
		shiwei := (l1.Val + carry) / 10
		res.Val = geiwei
		res.Next = add(l1.Next, nil, res.Next, shiwei)
	}
	if l1 == nil && l2 != nil {
		geiwei := (l2.Val + carry) % 10
		shiwei := (l2.Val + carry) / 10
		res.Val = geiwei
		res.Next = add(nil, l2.Next, res.Next, shiwei)
	}

	if l1 != nil && l2 != nil {
		geiwei := (l1.Val + l2.Val + carry) % 10
		shiwei := (l1.Val + l2.Val + carry) / 10
		res.Val = geiwei
		res.Next = add(l1.Next, l2.Next, res.Next, shiwei)
	}
	return res

}
