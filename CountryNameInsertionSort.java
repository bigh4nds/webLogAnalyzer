/** Insertion sort
 * @author Finn
 * > Insertion sorts Country[]
 */

class CountryNameInsertionSort
{
	private Country[] arr;                 
    private int nElems;              
    
    public CountryNameInsertionSort(Country[] a, int c)
    {
    	arr = a;
    	nElems = c;
    }
   
    /**
	 * > Sorts Country[] arr into descending order by Country count
	 */
    public void desInsertionSort()
   	{
    	int in, out;
    	for(out=1; out<nElems; out++)  
    	{
    		Country temp = (Country) arr[out];         
    		in = out;                     
    		while(in>0 && arr[in-1].getCount() <= temp.getCount() && arr[in-1].getCount() <= temp.getCount()) 
    		{
    			arr[in] = arr[in-1];            
    			--in; 
    		}
    		arr[in] = temp;                  
    	}
    }
}