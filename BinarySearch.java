/** Binary Search
 * @author Finn
 * >Searches Country[] for int[] targetIp
 */

class BinarySearch
{
	private Country[] arr;
	private int[] targetIp;
	
	public BinarySearch(Country[] c) 
	{
		arr = c;
	}
	
	/**
	 * > Takes in current Log & CountryData
	 * > targetIp is the ip of the Log
	 * > Modified binary search to check ip[1]'s if ip[0]'s are equal
	 * > Sets Log's country value & calls UpdateCountryData
	 */
	public void search(Log l, CountryData cdata)
	{
		targetIp = l.getIp();
        for(int i=0; i<arr.length-1; i++)
        {
        	int low=i, high = arr.length-1,  middle;
	        while(arr[low].getIp()[0]<=arr[high].getIp()[0])
	        {
	            middle = (low+high)/2;
	            if(arr[middle].getIp()[0]==targetIp[0])
	            {
	            	if(arr[middle].getIp()[1]==targetIp[1])
	            	{
	            		l.setCountry(arr[middle].getCountry());
	            		cdata.UpdateCountryData(l,arr[middle].getCountry());
	            		return;
	            	}
	            	else
	            	{
	            		if(arr[middle].getIp()[1]<targetIp[1])
	            			low = middle + 1;
	            		else
	            			high = middle - 1;
	            	}
	            }
	            else 
	            {
	            	if( arr[middle].getIp()[0]<targetIp[0])
	            		low = middle + 1;
	            	else
	            		high = middle - 1;
	            }
	        }
        }
	}
}