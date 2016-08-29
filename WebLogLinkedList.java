/** Link class
 *  > type Object
 *  > used for both Student & Apartment Links
 *  @author Finn
 */

class LogLink
{
	public Object obj;                
	public LogLink next;                

	public LogLink(Object o)              
    { 
		obj = o;
	}
	
	/** 
	 *  > Returns LogLink Object
	 */
	public Object displayLink()
	{
		return obj;
	}
}  

////////////////////////////////////////////////////////////////
/** WebLogLinkedList class
 *  > type Object
 *  @author Finn
 */

class WebLogLinkedList
{
	private LogLink first;
	private LogLink last;

	public WebLogLinkedList()            
    {
		first = null;                  
    }
	
	/** 
	 *  > Returns first LogLink in WebLogLinkedList
	 */
	public LogLink getFirst()         
    { 
		return first; 
	}

	/** 
	 *  > Sets first LogLink in WebLogLinkedList
	 */
	public void setFirst(LogLink f)
    { 
		first = f; 
	}
	
	/** 
	 *  > Inserts new LogLink at end of WebLogLinkedList
	 */
	 public void insertLast(Object j) 
     {                           
		 LogLink newLink = new LogLink(j);
	      if(isEmpty())      
	         first = newLink;
	      else
	         last.next = newLink;
	      last = newLink;
     }

	 /** 
		 *  > removes LogLink at front of WebLogLinkedList
	 */
	 public Object deleteFirst()      
     {                          
		 LogLink temp = first;
	     if(first.next == null)         
	    	 last = null;                
	     first = first.next;          
	     return temp;        
     }

	/** 
	 *  > Checks if WebLinkedList is empty
	 */
	public boolean isEmpty()
    { 
		return first==null; 
	}
	
	/** 
	 *  > Casts the current LogLink Object as Log
	 *  > Implements the Log class toString()
	 */
	public void displayList()
    {
		LogLink current = first;
		while(current != null)
        {
			Log temp = (Log) current.displayLink();
			temp.display();
			current = current.next;
        }
		System.out.println("");
    }
	
	/** 
	 *  > Creates & returns WebListIterator
	 */
	public WebListIterator getIterator()
	{
		return new WebListIterator(this);
	}
}
	
////////////////////////////////////////////////////////////////
class LinkQueue
{
	private WebLogLinkedList theList;

	public LinkQueue()             // constructor
    {
		theList = new WebLogLinkedList();
    }

	/** 
	 *  > Enqueues Object j to theList
	 */
	public void enque(Object j)     // put item on top of stack
    {
		theList.insertLast(j);
    }

	/** 
	 *  > Removes & returns first Object from theList
	 */
	public Object deque()            // take item from top of stack
    {
		return theList.deleteFirst();
    }

	/** 
	 *  > Checks if theList is empty
	 */
	public boolean isEmpty()       // true if stack is empty
   	{
		return (theList.isEmpty());
   	}
	
	/** 
	 *  > Returns WebListIterator for theList
	 */
	public WebListIterator getIterator()
	{
		return theList.getIterator();
	}

	/** 
	 *  > Displays queue
	 */
	public void displayQueue()
	{
		System.out.println("Queue (head-->tail): ");
		theList.displayList();
	}
}


