public class CircularLL
{
	Node head;
	Node tail;
	CircularLL()
	{
		this.head=null;
		
	}
	
	public class Node{
		
		
		String data;
		Node next;
		Node(String data)
		{
			this.data=data;
			this.next=null;
			
			
		}

	}

    //ADD FIRST


	public void addFirst(String data)
	{
		
		Node newNode=new Node(data);
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
        newNode.next=head;
        
        tail.next=newNode;
        head=newNode;
		
	}

	//ADD LAST

	public void addLast(String data){
		
		Node newNode = new Node(data);
		if(head == null )
		{
			head = tail = newNode;
		}
		tail.next = newNode;
		tail = newNode;
		newNode.next =head;
	}

    //PRINT

    public void printList()
    {
    	if(tail==null){
    		System.out.println("empty list");
    		return;
    	}
    	Node head=tail.next;
    	while(head!=tail.next)
    	{
    		
    		System.out.println(head.data+" =>");
    		head=head.next;

    	}
    	

    }

    public static void main(String[] args)
     {
    	CircularLL list=new CircularLL();
    	list.addFirst("claver");
    	list.addFirst("is");
    	list.addFirst("she");

    	list.printList();
    }

    
}