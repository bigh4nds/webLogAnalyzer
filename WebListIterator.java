/** WebListIterator class
 *  > type Object
 *  > Used to iterate WebLogLinkedList
 *  @author Finn
 */

class WebListIterator
   {
   private LogLink current;          
   private LogLink previous;        
   private WebLogLinkedList ourList;      

   public WebListIterator(WebLogLinkedList list)
   {
	   ourList = list;
       reset();
   }

   /** 
	 *  > Resets current LogLink to first Link of WebLogLinkedList
	 */
   public void reset()         
   {
	   current = ourList.getFirst();
       previous = null;
   }

   /** 
	 *  > Returns if WebListIterator is at end of WebLogLinkedList
	 */
   public boolean atEnd()      
   { 
	   return (current.next==null); 
   }

   /** 
	 *  > Iterates to next WebLogLinkedList LogLink
	 */
   public void nextLink()        
   {
       previous = current;
       current = current.next;
   }

   /** 
	 *  > Returns current WebListIterator LogLink
	 */
   public LogLink getCurrent()       
   { 
	   return current; 
   }

   /** 
	 *  > Deletes (from WebLogLinkedList) & returns the current WebListIterator LogLink
	 */
   public Object deleteCurrent()
   {
   		Object value = current.obj;
   		if(previous == null) 
   		{
   			ourList.setFirst(current.next);
   			reset();
        }
   		else
        {
   			previous.next = current.next;
   			if(atEnd())
   				reset();
   			else
   				current = current.next;
        }
   		return value;
   }
}  