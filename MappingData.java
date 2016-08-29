/** MappingData Class
 * @author Finn
 * > Handles input, sorting, & matching of ip country map data
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MappingData 
{
	private Country[] country = new Country[65280];
	private CountryData cdata;
	private int count = 0;
	
	/**
	 * > Fills Country[] country with every ip country map input
	 * > Change filename to ip country map txt file
	 */
	public void ReadMappingData(CountryData c)
	{
		cdata = c;
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
	 * > Parses input string & creates/adds Country object to country
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
		country[count++] = c;
	}
	
	/**
	 * > Displays Country[] country
	 */
	public void displayArray()
	{
		for(int i=0; i<count; i++)
		{
			Country c = (Country) country[i];
			c.display();
		}
	}
	
	/**
	 * > Linear searches through Country[] country to match each Log in LinkQueue q
	 * > Sets Log country value when match is found
	 * > Calls CountryData cdata.UpdateCountryData() after updating Log object 
	 */
	public void SimpleSearchData(LinkQueue q)
	{
		WebListIterator iter = q.getIterator();
		iter.reset();
		while(iter.getCurrent()!=null)
		{
			Log l = (Log)iter.getCurrent().obj;
			int[] ip = l.getIp();
			for(int i=0; i<count; i++)
			{
				Country c = (Country) country[i];
				if(ip[0] == c.getIp()[0] && ip[1] == c.getIp()[1])
				{
					l.setCountry(c.getCountry());
					cdata.UpdateCountryData(l,c.getCountry());
				}
			}
			iter.nextLink();
		}
	}
	
	/**
	 * > Merge sorts Country[] country by ip
	 */
	public void SortData()
	{
		MergeSort sort = new MergeSort(country);
		sort.mergeSort();
	}
	
	/**
	 * > Binary searches through Country[] country to match each Log in LinkQueue q
	 */
	public void BinarySearchData(LinkQueue q)
	{
		WebListIterator iter = q.getIterator();
		BinarySearch bin = new BinarySearch(country);
		iter.reset();
		while(iter.getCurrent()!=null)
		{
			Log l = (Log)iter.getCurrent().obj;
			bin.search(l, cdata);
			iter.nextLink();
		}
		
		
	}
}
