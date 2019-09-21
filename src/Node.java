public class Node
{
    private String Key;
    private String Value;
    private Node next;

    public Node(String Key,String Value,Node next)
    {
        this.Key = Key;
        this.Value = Value;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
