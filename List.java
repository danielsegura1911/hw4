package lists;
//a list that uses a single linke that goes through the nodes

public abstract class List<T> implements listInterface<T>
{
	private Node head;	//pointer to beginning of line
	private Node tail;	//pointer to end of line
        private Node p;	//points to a specific location
        public int num = 0;
        
        public List(){
                    head = null;
                    tail = null;
                    p = null;
                }
        
        public List(T item){
                    head = new Node(item, null);
                    tail = head;
                    p = head;
                    num++;
                }
   /** Adds a new entry to the end of the list and increases the list size by one */
   public void add(T item)
   {
       if (head == null)
       {
           head = new Node(item,null);
            tail = head;
       }
       else
       {
           Node node = new Node(item, null);
           tail.next = node;
           tail = node;
       }
       num++;
   }
   
      /** Adds a new entry to the specified location in the list and increases 
       * the list size by one */
   public void add(int position, T item)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           if (head == null)
           {
               head = new Node(item,null);
               tail = head;
           }
           else
           {
               Node node = new Node(item, null);
               tail.next = node;
               tail = node;
           }
       }   
   }
   
   /** Removes the entry from a specefic location and decreases
    *  the array size by one*/
   public void remove(int position)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           Node Tnode = head;
           int temp = 1;
           while (temp != position)
           {
               if(temp == position-1)
                   Tnode = p;
               p = p.next;
               temp++;
           }
           Tnode.next = p.next;
           p.data = null;
           p.next = null;
           p = head;
           num--;
           
       }   
   }
   
   /**  clears the list. */
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
   
   /** Verifies if an item is an entry of this List.*/
   public T view(int position)
   {
       T tempd;
       @SuppressWarnings("unused")
	Node Tnode = head;
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
   
   /** Verifies if an item is an entry of this List. */
   public boolean contains(T obj)
   {
       for(int i = 1; i <= num; i++)
       {
           if(obj == p.data)
               return true;
       }
       
       return false;
   }
   
   /**  checks if the array has any items*/
   public boolean isEmpty()
   {
       if (num > 0)
           return false;
       else
           return true;
   }
   
   /** class for the nodes */
   public class Node{
	T data;
	Node next;
	/**
	 * creates position for the data and the addresses in the node
	 */
	public Node() {
		data = null;
		next = null;
	}

	public Node(T newItem, Node nextN)
	{
		this.data = newItem;
		this.next = nextN;
	}

}
}
