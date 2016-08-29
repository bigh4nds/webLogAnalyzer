/** CountryData Class
 * @author Finn
 * > Updates & Sorts country hit count output
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CountryData 
{
	private Country[] CountryName = new Country[250];
	private int count = 0;
	
	/**
	 * > Updates counts in Country[] CountryName 
	 */
	public void UpdateCountryData(Log l, String country)
	{
		for(int i=0; i<count; i++)
		{
			if(country.equals(CountryName[i].getCountry()))
			{
				CountryName[i].incCount();
				break;
			}
		}
	}
	
	/**
	 * > Sorts Country[] CountryName in descending order by Country's count value 
	 */
	public void SortCountryData()
	{
		CountryNameInsertionSort insSort = new CountryNameInsertionSort(CountryName, count);
		insSort.desInsertionSort();
	}
	
	/**
	 * > Fills Country[] CountryName with every input country 
	 */
	public void InitializeCountryList()
	{
		String filename = "C:/Users/Finn/workspace/WebLogAnalyzer/src/ip_country_map.txt";
		String line;
		try
	    {    
            BufferedReader in = new BufferedReader(new FileReader(filename));
            if (!in.ready())
                throw new IOException();
            while ((line = in.readLine()) != null)
                ParseLine(line);
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
	}
	
	/**
	 * > Parses input string & creates/adds Country object to CountryName if country doesn't already exist
	 */
	public void ParseLine(String line)
	{
		line.trim();
		StringTokenizer tempStringTokenizer = new StringTokenizer(line);
		String ipstr = (String)tempStringTokenizer.nextElement();
		String coun = (String)tempStringTokenizer.nextElement();
		String temp[] = ipstr.split("\\.");
		int[] ip = new int[temp.length];
		for(int i=0; i<temp.length; i++)
		{
			ip[i] = Integer.parseInt(temp[i]);
		}
		Country c = new Country(ip, coun);
		for(int i=0; i<count; i++)
		{
			if(CountryName[i].getCountry().equals(coun))
				return;				
		}
		CountryName[count++] = c;
	}
	
	/**
	 * > Displays Country object's country abbreviation & count
	 */
	public void display()
	{
		for(int i=0; i<count; i++)
			System.out.println(CountryName[i].getCountry()+" "+CountryName[i].getCount());
	}
}
