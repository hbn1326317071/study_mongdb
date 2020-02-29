package com.hbn.study.mongodblearning.interview;

/**
 * @ClassNmae Solution
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/13 22:42
 * @Version 1.0
 */
public class Solution {


        public void flatten(TreeNode root) {
            TreeNode head = new TreeNode(-1);
//            头节点
            head.right = root;
            TreeNode node = head;

            while (node.right != null) {
                node = node.right;
                if (node.left != null) {
                    TreeNode end = node.left;
                    while (end.right != null) {
                        end = end.right;
                    }

                    TreeNode tmp = node.right;

                    node.right = node.left;
                    node.left = null;
                    end.right = tmp;
                }
            }

            head.right = null; // 去掉引用方便垃圾回收
        }

}
