package MediumQuestions;

public class DeleteNodeInABST {
    /**
      Delete Node in a BST

     Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
     Basically, the deletion can be divided into two stages:
     1. Search for a node to remove.
     2. If the node is found, delete the node.
     */

    public TreeNode deleteNodeInBST(TreeNode root, int key){
        if (root == null){
           return null;
        }

        if (key < root.val){
            root.left = deleteNodeInBST(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeInBST(root.right, key);
        } else {
//            Node to be deleted found
            if (root.left == null){
                return root.right;
            } else if (root.right == null ) {
                return root.left;
            }
//            Node with two children
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNodeInBST(root.right, minNode.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
