/** Country Class
 * @author Finn
 * >Country object
 *   - int[] ip: Ip of country
 *   - String country: Two letter abbreviation of country
 *   - int count: Count of how many visitors are from this country
 */

public class Country 
{
	private int[] ip;
	private String country = "N/A";
	private int count = 0;
	
	public Country(int[]i, String c)
	{
		ip = i;
		country = c;
	}
	
	/**
	 * > Returns ip
	 */
	public int[] getIp()
	{
		return ip;
	}
	
	/**
	 * > Returns country
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * > Returns count
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * > Increments count
	 */
	public void incCount()
	{
		count++;
	}
	
	/**
	 * > Displays Country object in same format as inputed
	 */
	public void display()
	{
		System.out.println(ip[0]+"."+ip[1]+" "+country);
	}
}
