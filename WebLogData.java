/** WebLogData Class
 * @author Finn
 * > Contains main method
 * > Reads & parses web log
 * > Enqueues each visit as Log object
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WebLogData 
{
	/**
	 * > Main Method
	 */
	public static void main(String[] args) 
	{
		// 1st Pass: Simple search
		System.out.println("[PASS 1]");
		long sTime = System.nanoTime();
		LinkQueue logs = new LinkQueue();
		MappingData map = new MappingData();
		CountryData cdata = new CountryData();
		cdata.InitializeCountryList();
		ReadLogData(logs);
		map.ReadMappingData(cdata);
		map.SimpleSearchData(logs);
		cdata.SortCountryData();
		cdata.display();
		System.out.println("Runtime: "+(System.nanoTime()-sTime)+"ns");
		System.out.println("-----------------------------");
		System.out.println();
		// 2nd Pass: Fast search
		System.out.println("[PASS 2]");
		sTime = System.nanoTime();
		logs = new LinkQueue();
		map = new MappingData();
		cdata = new CountryData();
		cdata.InitializeCountryList();
		ReadLogData(logs);
		map.ReadMappingData(cdata);
		map.SimpleSearchData(logs);
		map.SortData();
		map.BinarySearchData(logs);
		cdata.SortCountryData();
		cdata.display();
		System.out.println("Runtime: "+(System.nanoTime()-sTime)+"ns");
	}
	
	/**
	 * > Fills LinkQueue logs with Log object from each web log input
	 * > change filename to web log txt file
	 */
	public static void ReadLogData(LinkQueue logs)
	{
		String filename = "C:/Users/Finn/workspace/WebLogAnalyzer/src/web_log.txt";
		String line;
		try
	    {    
            BufferedReader in = new BufferedReader(new FileReader(filename));
            if (!in.ready())
                throw new IOException();
            while ((line = in.readLine()) != null)
                ParseLine(line, logs);
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
	}
	
	/**
	 * > Parses input string & creates/enqueues Log object to LinkQueue
	 */
	public static void ParseLine(String line, LinkQueue logs)
	{
		String[] temp;
		int[] ip = new int[3];
		temp = line.substring(0,15).split("\\.");
		for(int i=0; i<3; i++)
		{
			ip[i] = Integer.parseInt(temp[i]);
		}
		Log l = new Log(ip);
		logs.enque(l);
	}
}
