package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum1(root *TreeNode, sum int) [][]int {
	var path = make([]int, 0)
	var paths = make([][]int, 0)
	hasPathSum1(root, sum, &paths, path)

	fmt.Print(paths)
	return paths
}

func hasPathSum1(root *TreeNode, sum int, paths *[][]int, path []int) {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil {
		if root.Val == sum {
			path = append(path, root.Val)
			*paths = append(*paths, path)
		}
		return
	}

	path = append(path, root.Val)

	hasPathSum1(root.Left, sum-root.Val, paths, path)
	hasPathSum1(root.Right, sum-root.Val, paths, path)

	//l := len(path)
	//path = append(path[:l-2])
}

func main() {
	root := &TreeNode{Val: -6}
	node1 := &TreeNode{Val: -3}
	node2 := &TreeNode{Val: -6}
	node3 := &TreeNode{Val: 0}

	node4 := &TreeNode{Val: -6}
	node5 := &TreeNode{Val: -5}
	node6 := &TreeNode{Val: 4}
	node7 := &TreeNode{Val: 1}
	node8 := &TreeNode{Val: 7}

	root.Right = node1
	node1.Left = node2
	node1.Right = node3

	node2.Left = node4
	node2.Right = node5

	node3.Left = node6

	node6.Left = node7
	node6.Right = node8

	pathSum1(root, -21)
}
