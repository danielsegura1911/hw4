package PQue;
//arranges items in a queue based off the items priority
public class PQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>//this dame thing
{

	private Node head;
	private Node tail;
	private int count = 0;
	
	
	public PQueue()
	{
		head = null;
		tail = head;
	}
	// class constructor that creates a new node
	public PQueue(T item)
	{
		
		head = new Node(item, null);	
                tail = head;
	}
	
	   /** Adds a new entry to the queue. */
	public void add(T newEntry)
	{
		Node point = head;
		Node temp = head;
		if (head == null)
		{
			head = new Node(newEntry, null);
			tail = head;
			count++;
		}
		else 
		{
			Node node = new Node(newEntry, head);
			switch(head.compareTo(node))
			{
				case 0: node.next = head.next;
						head.next = node;
						count++;
						break;
				case 1: node.next = head;
						head = node;
						count++;
						break;
				case -1: while (point.compareTo(node) < 0 )
							 point = point.next;
						 while(temp.next != point)
							 temp = temp.next;
						 temp.next = node;
						 node.next = point;
						 count++;
						 break;
			}
		}
		
	}

   /**removes the entry with the highest priority
    *  and replaces it with the item behind it if it exits */
	public T remove()
	{
		if(head != null)
		{
			T temp;
                        temp = head.data;
			head.data = null;
			if(head.next != null)
			{
				head = head.next;
			}
			count--;
			return temp;
		}
		
                return null;
	}

   /** shows the item with the highest priority */
	public T peek()
	{
		if (head.data != null)
			return head.data;
		else 
			return null;
	}

   /** checks if the queue is empty.*/
	public boolean isEmpty()
	{
		if (head.data == null && tail.data == null)
			return true;
		else 
			return false;
	}

   /** Gets the size of the queue.*/
	public int getSize()
	{
		return count;
	}

   /** clears the queue */
	public void clear()
	{
		do{
			head.data = null;
			if(head.next != null)
			{
				head = head.next;
			}				
		}while(head != null);
	}
	//class that defines the node
	public class Node{
		T data;
		Node next;
		
		public Node() {
			data = null;
			next = null;
		}
		//method that defines the components of the node
		public Node(T newItem, Node nextN)
		{
			this.data = newItem;
			this.next = nextN;
		}
		
	        public int compareTo(Node nod)
	        {
	            return data.compareTo(nod.data);
	        }
	}
}
