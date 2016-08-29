/** Log Class
 * @author Finn
 * >Log object
 *   - int[] ip: Ip of visitor log
 *   - String country: Two letter abbreviation of country
 */

public class Log 
{
	private int[] ip;
	private String country = "unmatched";
	
	
	public Log(int[] i)
	{
		ip = i;
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
	 * > Sets country 
	 */
	public void setCountry(String c)
	{
		country = c;
	}
	
	/**
	 * > Displays Log object
	 */
	public void display()
	{
		System.out.println(ip[0]+"."+ip[1]+"."+ip[2]+" "+country);
	}
}
