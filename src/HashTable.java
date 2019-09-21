/*
  Functional Hash table array size of 5,
with chaining for collision resolution
Key=String and Value = String

 */


public class HashTable
{

    public static final int ARRAY_SIZE = 5;

    private Node hashTable[];
    private int Size;

    public HashTable()
    {
        this.hashTable = new Node[ARRAY_SIZE];
        this.Size = 0;
    }

    public static int getArraySize() {
        return ARRAY_SIZE;
    }

    public Node[] getHashTable()
    {

        Node copyHashTable[] = new Node[ARRAY_SIZE];

        for(int i=0;i<hashTable.length;i++)
        {
            copyHashTable[i] = copyHashChain(hashTable[i]);
        }
        return copyHashTable;
    }

    public void setHashTable(Node[] hashTable) {
        this.hashTable = hashTable;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int hash(String Key)
    {

        return (Key.hashCode() & 0x7fffffff) % ARRAY_SIZE;

    }

    public String get(String Key) throws Exception
    {
        if(Key==null)
        {

            throw  new Exception("The Key is not defined");

        }
        else
            {
                int hashvalue = hash(Key);

                for(Node i=hashTable[hashvalue];i!=null;i=i.getNext())
                {
                    if(i.getKey().equals(Key))
                    {
                        return i.getValue();

                    }
                }

                return null;
            }

    }

    public void putValue(String Key,String Value) throws Exception
    {
        if(Key==null || Value==null)
        {
            throw new Exception("Both the Key and the Value must be defined");

        }

        else
            {

                int hashvalue = hash(Key);

                for(Node i=hashTable[hashvalue];i!=null;i=i.getNext())
                {
                    if(i.getKey().equals(Key))
                    {

                        i.setValue(Value);
                        return;


                    }
                }

                hashTable[hashvalue] = new Node(Key,Value,hashTable[hashvalue]);



            }


    }

    public Node copyHashChain(Node rootNode)
    {
        if(rootNode==null)
        {
            return null;
        }

        else if(rootNode.getNext() == null)
        {
            return new Node(rootNode.getKey(),rootNode.getValue(),rootNode.getNext());
        }

        else
            {
                return  new Node(rootNode.getKey(),rootNode.getValue(),copyHashChain(rootNode.getNext()));
            }
    }


    public HashTable getCopyHashTable()
    {
        HashTable Hash = new HashTable();

        Hash.setHashTable(getHashTable());

        Hash.setSize(getSize());

        return Hash;
    }


}
