package _01_100

// 暴力破解
//func twoSum(nums []int, target int) []int {
//	for i:=0;i<len(nums) ;i++  {
//		for j:=i;j+1<len(nums) ;j++  {
//			if nums[i]+nums[j]==target {
//				res :=[]int {i,j}
//				return res;
//			}
//		}
//	}
//	return nil;
//}
//初始到map
//func twoSum(nums []int, target int) []int {
//
//	// 创建一个map作为匹配池
//	pool := make(map[int] int);
//	for i := 0; i<len(nums);i++  {
//		// 将素引放入map
//		pool[nums[i]] = i
//	}
//	for i := 0; i < len(nums); i++ {
//		var index,ok =  pool[target-nums[i]];
//		if ok && i!=index {
//			res :=[]int {i,index}
//			return res;
//		}
//	}
//	return nil
//}

// 匹配式的在map中查找

func twoSum(nums []int, target int) []int {

	// 创建一个map作为匹配池
	pool := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		another := target - nums[i]
		index, ok := pool[another]
		if ok {
			return []int{i, index}
		}
		pool[nums[i]] = i
	}

	return nil
}
