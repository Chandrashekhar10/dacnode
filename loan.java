package com.bank;

import java.util.Scanner;

public class loan extends Account
{

	int ab;
	
	public int getab()
	{
		return ab;
	}
	
	Scanner sc = new Scanner(System.in); 
	

	public loan()
	{
		super();
		ab = 0;
	}
	
	public void withdraw() 
	{
		if(balance> 0)
		{
			System.out.println("You can take loan upto 5000");
			System.out.println("Enter Amount : ");
			this.amount=sc.nextInt();
			balance-=amount;
			if(this.balance > -5000)
			{
				System.out.println("Your account is Debitied");
				balance= balance - amount;
				arr[count]=amount;
				count++;
			}
			else
			{
				System.out.println("Please Enter the valid amount");
				balance+=amount;
			}
			
		}
		else
		{
			System.out.println("Please fill the loan first");
		}
	}

	public void deposit() 
	{
		if(balance<0)
		{
		System.out.println("You have "+loanamount+"loan");
		System.out.println("How much loan you want to pay");
		this.loanamount=sc.nextInt();
		balance+=loanamount;
		darr[dcount]=amount;
		dcount++;
		
		}
		else
		{
			System.out.println("You dont have any loan left");
			System.out.println("How much amount you want to deposit in your account");
			amount=sc.nextInt();
			balance+=amount;
			
		}
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
