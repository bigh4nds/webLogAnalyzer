/** Merge Sort
 * @author Finn
 * >Merge sorts Country[] theArray
 */

class MergeSort
{
	private Country[] theArray;          
	private int nElems;               

	public MergeSort(Country[] c)            
	{
		theArray = c;     
		nElems = theArray.length;
    }

	/**
	 * > Creates workSpace
	 * > Starts merge sort
	 */
	public void mergeSort()         
    {                              
		Country[] workSpace = new Country[nElems];
		recMergeSort(workSpace, 0, nElems-1);
    }

	/**
	 * > Recursively sorts workSpace
	 */
	private void recMergeSort(Country[] workSpace, int lowerBound,int upperBound)
    {
		if(lowerBound == upperBound)           
			return;                             
		else
        {                                    
			int mid = (lowerBound+upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
        }  
    }

	/**
	 * > Merges workSpace into theArray
	 * > Modified to check ip[1]'s if ip[0]'s are equal
	 */
	private void merge(Country[] workSpace, int lowPtr,int highPtr, int upperBound)
	{
		int j = 0;                             
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;    
		while(lowPtr <= mid && highPtr <= upperBound)
		{
			if(theArray[lowPtr].getIp()[0] == theArray[highPtr].getIp()[0])
			{
				if(theArray[lowPtr].getIp()[1] < theArray[highPtr].getIp()[1])
					workSpace[j++] = theArray[lowPtr++];
				else
					workSpace[j++] = theArray[highPtr++];
			}
			else
			{
				if(theArray[lowPtr].getIp()[0] < theArray[highPtr].getIp()[0])
					workSpace[j++] = theArray[lowPtr++];
				else
					workSpace[j++] = theArray[highPtr++];
			}
		}
		while(lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];

		while(highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];

		for(j=0; j<n; j++)
			theArray[lowerBound+j] = workSpace[j];
    } 
	
	/**
	 * > Displays theArray
	 */
	public void display()             
    {
		for(int j=0; j<nElems; j++)    
			theArray[j].display();
    }
}