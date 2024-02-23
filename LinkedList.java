import java.security.InvalidParameterException;

public class LinkedList {
    
        public class Node {
        	
        	public int data;
        	public Node next;
        	
        	public Node() {
        		data = 0;
        		next = null;
       	}
        
        public Node(int x) {
        	this();
        	data = x;
        }
    }

    public Node header;
    public int size;
    
    public LinkedList() {
    	header = new Node();
    	size = 0;
    }
    
    public boolean contains(int e) {
    	Node p = header.next;
    	while(p != null && p.data !=e) {
    		p = p.next;
    	}
    	return p != null;
    }
    
    
    public void addFirst(int x) {
        Node n = new Node(x);
        n.next = header.next;
        header.next = n;
        size++;
    }
    
    public void addLast(int x) {
    	Node n = new Node(x);
    	Node p = header;
    	while (p.next != null) {
    		p= p.next;
    	}
    	p.next = n;
    	size++;
    }
    
  //for searching for information in the node.
    public Node nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidParameterException("Index out of reach: " + index);
        }
        int i = 0;
        Node p = header;
        while(p.next != null && i != index) {
        	p = p.next;
        	i++;
        }
        return p;
    }
    
    //for removing the information in the position we want.
    public void removeAt(int index) {
        Node p = nodeAt(index);
        
        if(p.next != null) {
        	p.next = p.next.next;
        	size--;
        }
    }
    
    public int get(int index) {
    	if (index < 0 || index >= size) {
            throw new InvalidParameterException("Index out of reach: " + index);
        }
    	return nodeAt(index).data;
    }
    
    public void set(int index, int e) {
    	if(index < 0 || index>= size) {
            throw new InvalidParameterException("Index out of reach: " + index);
    	}
        nodeAt(index).data = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    // Example of using linkedlist

//     public static void main(String args[]) {
//     Node newnode1 = new Node(); // here we are making objects of class Node
//     Node newnode2 = new Node(); // basically these are nodes of first linkedlist
//     Node newnode3 = new Node();
//     Node newnode4 = new Node();
//     newnode1.data = 1;
//     newnode2.data = 2;
//     newnode3.data = 3;
//     newnode4.data = 4;
//
//     newnode1.next = newnode2; // here we are linking the previous node to the
//     // next node of the list
//     newnode2.next = newnode3;
//     newnode3.next = newnode4;
//     newnode4.next = null;
//     
//     // Now we will print the linked list
//     for (int i = 1; i <= 4; i++) {
//     System.out.print(newnode1.data + " ");
//     newnode1 = newnode1.next; // we are assigning the next address of the linked
//     // list to the current address
//     }
//    }
    
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(); // Create a new instance of your LinkedList

        // Adding elements to the linked list using your custom methods
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        // Now, you can print the linked list by traversing it using your custom methods
        Node currentNode = linkedList.header.next; // Start from the first node

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next; // Move to the next node
        }
    }
    
}