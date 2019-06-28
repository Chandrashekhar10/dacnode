package com.bank;

import java.util.Scanner;

public class salary extends Account 
{

	Scanner sc =  new Scanner(System.in);
	public salary()
	{
		super();
	}
	
	public void withdraw() 
	{
		System.out.println("Enter amount to be Withdrawl");
		this.amount=sc.nextInt();
		this.balance-=this.amount;
		System.out.println("Your updated balance is "+this.balance);
		arr[count]=amount;
		count++;
	}

	public void deposit() 
	{
		System.out.println("Enter amount to be deposit");
		this.amount=sc.nextInt();
		this.balance+=this.amount;
		System.out.println("Your updated balance is "+this.balance);
		darr[dcount]=amount;
		dcount++;
	}

 public void ministatement()
 	{
	 int k=1;
	 for(int j=0;j<count;j++)
		{
			System.out.println((k)+" . Deposit Amount--"+arr[j]);
			k++;
		}
		for(int j=0;j<dcount;j++)
		{
			System.out.println((k)+" . Withdrawl--"+darr[j]);
			k++;
		}
		System.out.println("No. of Transaction"+(count+dcount));
	}

}
