package com.coin.pack;

import java.util.*;

public class Users 
{
	
	Scanner sc = new Scanner(System.in);
	
	
	ArrayList<country> count=new ArrayList<country>();
	
	
	public void addcountry()
	{
		int flag=1;
		System.out.println("Entery country name");
		String nam=sc.next();
		//country c = new country(nam);
		Iterator<country> itt=count.iterator();
		while(itt.hasNext())
		{
			country coun = itt.next();
			if(nam.equalsIgnoreCase(coun.getCountryname()))
			{
				System.out.println("You already have that country coins do you wanna add more");
				String ch =sc.next();
				if(ch.equalsIgnoreCase("y"))
				{
					System.out.println("Adding Coin");
					//country c = new country(nam);
					coun.addingcoin();
					System.out.println(count.size());
				}
				flag=0;
				break;
			}
//			itt.next();
		}
		
		if(flag==1)
		{
				System.out.println("Adding Coin");
				country c = new country(nam);
				c.addingcoin();
				count.add(c);
				System.out.println(count.size());
				
		}
		
	}
	public void displaycountry()
	{
		Iterator<country> itt=count.iterator();
		while(itt.hasNext())
		{
			country coun = itt.next();
			System.out.println("Country name is "+coun.getCountryname());
			coun.displaycoin();
			//itt.next();
		}
	}
	public void listcreation() 								//case 3 remains
	{
		System.out.println("Which type of list you want to create");
		System.out.println("1.Country");
		System.out.println("2.Year of minting");
		System.out.println("3.Current Value");
		int choice=sc.nextInt();
		Iterator<country> itt  =count.iterator();
		switch(choice)
		{
		case 1: System.out.println("*****Name of the country's which coins you have*****");
				
				int cont = 0;
				while(itt.hasNext())
				{
						country conn = itt.next();
						System.out.println("Contry name "+conn.getCountryname());
						cont++;
				}
				System.out.println("Total number of countries "+cont);
				break;
		case 2: System.out.println("*****Minting year of coins with Denimination*****");
				while(itt.hasNext())
				{
					country conn = itt.next();
					conn.yearminting();
				}
				
				break;
		case 3: System.out.println("Sorted Current value");
				while(itt.hasNext())
				{
					country conn = itt.next();
					System.out.println("Country name "+conn.getCountryname());
					conn.comparefun();
				}
				break;
		
		}
		
	}
	
	
	public void searching() 
	{
	int flag=0;
	System.out.println("*****Enter search method*****");
	System.out.println("1.Country + Denomination");
	System.out.println("2.Country + Year of Minting");
	System.out.println("3.Country + Denomination + Year of Minting");
	System.out.println("4.Country + Aquired date");
	int choice = sc.nextInt();
	Iterator<country> itt = count.iterator();
	switch(choice)
	{
	case 1: System.out.println("Enter Country name");
			String name = sc.next();
			while(itt.hasNext())
			{
				country conn= itt.next();				
				if(conn.getCountryname().equalsIgnoreCase(name))
				{	
					flag=1;
					conn.denominationfun();
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Country not found");
			}
			flag=0;
			break;
	case 2: System.out.println("Enter Country name");
			name = sc.next();
			while(itt.hasNext())
			{
				country conn= itt.next();				
				if(conn.getCountryname().equalsIgnoreCase(name))
				{	
					flag=1;
					conn.yearmintingsearch();
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Country not found");
			}
			flag=0;
			break;
	case 3: System.out.println("Enter Country name");
			name = sc.next();
			while(itt.hasNext())
			{
				country conn= itt.next();				
				if(conn.getCountryname().equalsIgnoreCase(name))
				{	
					flag=1;
					conn.dym();
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Country not found");
			}
			flag=0;
			break;
	case 4: System.out.println("Enter Country name");
			name = sc.next();
			while(itt.hasNext())
			{
				country conn= itt.next();				
				if(conn.getCountryname().equalsIgnoreCase(name))
				{	
					flag=1;
					conn.adate();
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Country not found");
			}
			flag=0;
			break;	
			
			
	}
		
	}
	public void addfile() throws Exception 
	{
		int flag=1;
		country c = new country();
		c.usingfile();
		Iterator<country> itt = count.iterator();
		while(itt.hasNext())
		{
			country coun = itt.next();
			if(c.getFilecname().equalsIgnoreCase(coun.getCountryname()))
			{
					System.out.println("Adding Coin");
					//country c = new country(nam);
					coun.usingfile();
					System.out.println(count.size());
					flag=0;
					break;
			}
				
				
		}
//			itt.next();
		
		if(flag==1)
		{
				System.out.println("Adding Coin");
				country cmd = new country(c.getFilecname());
				cmd.usingfile();
				count.add(cmd);
				System.out.println(count.size());
				
		}
		
	}
		
}
