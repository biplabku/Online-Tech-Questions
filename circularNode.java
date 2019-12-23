public class circularNode {
    public int val;
    public circularNode next;

    public circularNode() {}

    public circularNode(int _val) {
        val = _val;
    }

    public circularNode(int _val, circularNode _next) {
        val = _val;
        next = _next;
    }
}
