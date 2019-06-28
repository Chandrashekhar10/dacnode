package com.coin.pack;
import java.util.*;

public class funMain 
{
public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		String choice=null;
		Users user = new Users();
			do
			{
				System.out.println("******Welcome to Coin Collection Center******");
				System.out.println("1. Adding the coin using terminal");
				System.out.println("2. Adding the coin using file");			//need to implement this
				System.out.println("3. Searching");
				System.out.println("4. List Creation");				
				//System.out.println("5. Auction");					//what we have to do in auction perticularly
				System.out.println("6. Details of all coins");
				int action = sc.nextInt();
				switch(action)
				{
				case 1:user.addcountry();
					break;
				case 2 : try 
						{					
							user.addfile();
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					break;
				case 3:user.searching();
					break;
				case 4: user.listcreation();
					break;
				case 6: user.displaycountry();
					break;
				}System.out.println("Do you want to peform more actions");
				choice=sc.next();
			}while(choice.equalsIgnoreCase("y"));
			sc.close();
	}
}
