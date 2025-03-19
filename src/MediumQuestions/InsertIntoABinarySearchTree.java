package MediumQuestions;

public class InsertIntoABinarySearchTree {
    /**
     701. Insert into a Binary Search Tree
     You are given the root node of a binary search tree (BST) and a value to insert into the tree.
     Return the root node of the BST after the insertion.
     It is guaranteed that the new value does not exist in the original BST.
     Notice that there may exist multiple valid ways for the insertion,
     as long as the tree remains a BST after insertion. You can return any of them.
     */
// time o(n) space o(1)
    public TreeNode insertIntoBST(TreeNode root, int val){
        TreeNode newNode = new TreeNode(val);

        if (root == null){
            return newNode;
        }

        TreeNode currentNode = root;

        while (currentNode != null){
            if (val < currentNode.val){
                if (currentNode.left != null){
                    currentNode = currentNode.left;
                } else{ currentNode.left = newNode;
                break;
                }
            } else {
                if (currentNode.right != null){
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    break;
                }
            }
        }
        return root;
    }
}
