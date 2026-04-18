/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> clonedNodeMap = new HashMap<>();
    List<Node> visitedNode = new ArrayList<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Node clonedNode = null;
        visitedNode.add(node);
        clonedNode = new Node(node.val);
        clonedNodeMap.put(node, clonedNode);
        
        for(Node n : node.neighbors) {
            if(!visitedNode.contains(n))
                cloneGraph(n);
        }

        for(Node n : node.neighbors)
            clonedNode.neighbors.add(clonedNodeMap.get(n));
        
        return clonedNode;

    }
}