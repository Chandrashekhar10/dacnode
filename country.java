package com.coin.pack;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class country 
{
	String countryname;
	String filecname;
	Scanner sc= new Scanner(System.in);
	TreeSet<coin> coins= new TreeSet<coin>();
	
	public country()
	{
		this.filecname=null;
	}
	public country(String countryname) 
	{
		this.countryname = countryname;
	}

	public String getFilecname() {
		return filecname;
	}

	public void setFilecname(String filecname) {
		this.filecname = filecname;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	
	public void addingcoin()
	{
	System.out.println("Please fill the details");
	System.out.println("Enter Denomination");
	String denom=sc.next();
	System.out.println("Enter Year of Minting(YY)");
	String dat=sc.next();
	System.out.println("Enter Current value");
	int val=sc.nextInt();
	System.out.println("Enter Aquire Date");
	String adat=sc.next();
	coins.add(new coin(val,dat,denom,adat));
	System.out.println(coins.size());
	}
	
	public void displaycoin()
	{
		System.out.println(coins.size());
		
		Iterator<coin> itt = coins.iterator();
		while(itt.hasNext())
		{
			coin c = itt.next();
			System.out.println("Current value of the coin is "+c.getCurrentvalue());
			System.out.println("Aquiredate of the coin is "+c.getAcquireddate());
			System.out.println("Denomination is"+c.getDenomination());
			System.out.println("Year of mining is "+c.getYearofmining());
			//itt.next();
		}
	}
	public void yearminting()
	{
		Iterator<coin> itt=coins.iterator();
		while(itt.hasNext())
		{
			coin c =itt.next();
			System.out.println("Denomination "+c.getDenomination()+" and Year of minting "+c.getYearofmining());
			
		}
	}
	public void comparefun()			//compare function need to be checked how the type conversion take place
	{
		Iterator<coin> itt = coins.iterator();
		while(itt.hasNext())
		{
			coin c=itt.next();
			c.compareTo(c);
			System.out.println("Current value "+c.getCurrentvalue());
		}
	}

	public void denominationfun() 
	{
		int flag=0;
		Iterator<coin> itt = coins.iterator();
		while(itt.hasNext())
		{
			coin c=itt.next();
			System.out.println("Enter Denomination of the coin");
			String denom=sc.next();
			if(c.getDenomination().equalsIgnoreCase(denom))
			{
				c.display();
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Coins not found");
		}
		
	}
	public void yearmintingsearch()
	{
		Iterator<coin> itt = coins.iterator();
		int flag=0;
		while(itt.hasNext())
		{
			coin c=itt.next();
			System.out.println("Enter Year of Minting ");
			String denom=sc.next();
			if(c.getYearofmining().equalsIgnoreCase(denom))
			{
				flag =1;
				c.display();
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Coins not found");
		}
	}
	public void dym()
	{
		int flag=0;
		Iterator<coin> itt = coins.iterator();
		while(itt.hasNext())
		{
			coin c = itt.next();
			System.out.println("Enter Denomination of the coin");
			String denom=sc.next();
			System.out.println("Enter Year of Minting ");
			String str=sc.next();
			if(c.getDenomination().equalsIgnoreCase(denom)&&c.getYearofmining().equalsIgnoreCase(str))
			{
				flag=1;
				c.display();
				break;
			}
			
		}
		if(flag==0)
		{
			System.out.println("Coins not found");
		}
	}
	public void adate()
	{
		int flag=0;
		Iterator<coin> itt=coins.iterator();
		System.out.println("Enter Year Aquired date");
		String choice = sc.next();
		while(itt.hasNext())
		{
			coin c = itt.next();
			if(c.getAcquireddate().equalsIgnoreCase(choice))
			{
				flag=1;
				c.display();
				break;
			}
			
			
		}
		if(flag==0)
		{
			System.out.println("Coins not found");
		}
	}
	
	public void usingfile() throws Exception
	{
//		/int flag =0;
		int count=0;
		File fil = new File("E:\\Eclipse\\CoinpAssignment\\src\\Coins_Details.txt");
		Scanner scan= new Scanner(fil);
		while(scan.hasNextLine())
		{
			//flag=0;
			String str  =	scan.nextLine();
			System.out.println(str);
			StringTokenizer str1 = new StringTokenizer(str,",");
			while(str1.hasMoreElements())
			{
				this.filecname =(String) str1.nextElement();
				String denom = (String) str1.nextElement();
				String dat = (String) str1.nextElement();
				String adat = (String) str1.nextElement();
				String val = (String) str1.nextElement();
				int value = Integer.parseInt(val);
				//flag=1;
				coins.add(new coin(value,dat,denom,adat));
				count++;
				System.out.println(count+" Coin is added");
			}
		}
		
		
		
//		FileInputStream fin=null;
//		BufferedInputStream bin=null;
//		try 
//		{
//			fin = new FileInputStream("Coins_Details.txt");
//			bin = new BufferedInputStream(fin);
//			while(sc.hasNextLine())
//			{
//				
//			}
//			
//		
//		}
//		catch (FileNotFoundException e) 
//		{
//			System.out.println(" File not found ");
//			e.printStackTrace();
//		}
//		finally
//		{
//			try 
//			{
//			fin.close();
//			} 
//			catch (IOException e) 
//			{
//			e.printStackTrace();
//			}
//		}
	}
}
