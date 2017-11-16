package lists;
//list that uses two adresses that double link the 
public abstract class DLlists<T> implements listInterface<T>
{
	private DLNode head;	//pointer to beginning of line
	private DLNode tail;	//pointer to end of line
        private DLNode p;	//points to a specific location
        public int num = 0;

	
        
        public DLlists()
                {
                    head = null;
                    tail = null;
                    p = null;
                }
        
        public DLlists(T item)
                {
                    head = new DLNode(item, null, head);
                    tail = head;
                    p = head;
                    num++;
                }
   /** Adds a new entry to the end of the list and increases 
    * the list by one*/
   public void add(T item)
   {
       if (head == null)
       {
           head = new DLNode(item,null, head);
            tail = head;
       }
       else
       {
           DLNode DLNode = new DLNode(item, null, DLNode);
           tail.next = DLNode;
           tail = DLNode;
       }
       num++;
   }
   
      /** Adds a new entry to the specified position of the list
       *  and increases the array size by one */
   public void add(int position, T item)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           if (head == null)
           {
               head = new DLNode(item,null, head);
               tail = head;
           }
           else
           {
               DLNode DLNode = new DLNode(item, null, DLNode);
               tail.next = DLNode;
               tail = DLNode;
           }
       }   
   }
   
   /** Removes the entry at a specific location
    *  and decreases the array size by one*/
   public void remove(int position)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           DLNode TDLNode = head;
           int temp = 1;
           while (temp != position)
           {
               if(temp == position-1)
                   TDLNode = p;
               p = p.next;
               temp++;
           }
           TDLNode.next = p.next;
           p.data = null;
           p.next = null;
           p = head;
           num--;
           
       }   
   }
   
   /**  clears the array */
   public void clear()
   {
       while(head.next != null)
       {
           head.data = null;
           head = head.next;
       }
       head = null;
       tail = null;
       p = null;
   }
   
   /** checks if an item is in the list */
   public T view(int position)
   {
       T tempd;
       @SuppressWarnings("unused")
	DLNode TDLNode = head;
       int temp = 1;
       while (temp != position)
       {
           p = p.next;
           temp++;
       }
       tempd = p.data;
       p = head;
       return tempd;
   }
   
   /** Verifies if an item is an entry of this List.*/
   public boolean contains(T obj)
   {
       for(int i = 1; i <= num; i++)
       {
           if(obj == p.data)
               return true;
       }
       
       return false;
   }
   
   /** checks if the list is empty*/
   public boolean isEmpty()
   {
       if (num > 0)
           return false;
       else
           return true;
   }
   
   /**
    *class that creates the nodes
    */
   public class DLNode{
   	T data;
   	DLNode next;
   	DLNode prev;
   	
   	/**
	 * creates position for the data and the addresses in the node
	 */
   	public DLNode() {
   		data = null;
   		next = null;
   		prev = null;
   	}

   	public DLNode(T newItem, DLNode nextN, DLNode prevN)
   	{
   		this.data = newItem;
   		this.next = nextN;
   		this.prev = prevN;
   	
   	}

   }
}

