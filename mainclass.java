package com.main;
import java.util.Scanner;

import com.bank.*;

public class mainclass {

	static int i;
	static
	{
		i=0;
	}
	public static void main(String[] args) 
	{
	
	
		int ch;
		String choice;
		Scanner sc =new Scanner(System.in);
		Account[] acc = new Account[10];
		
			
		do
		{
			System.out.println("What you want to do");
			System.out.println("1.Create Account");
			System.out.println("2.Already have an account");
			System.out.println("3.Close Account");
			ch=sc.nextInt();
			if(ch == 1)
			{
				System.out.println("Enter account no");
				int no = sc.nextInt();
				int flag=0;
				for(int j=0;j < i;j++)
				{
					if(acc[j].getAccno() == no)
					{
						System.out.println("Your already have an account please log in");
						flag = 1;
						break;
					}
					
				}
				if(flag==0)
				{
					System.out.println("Which type of account you want to create");
					System.out.println("1.Salary");
					System.out.println("2.Loan");
					int abc=sc.nextInt();
					if(abc==1)
					{
						System.out.println("Creating Salary account");
						acc[i] = new salary();
						System.out.println("Enter your name");
						acc[i].setName(sc.next());
						System.out.println("Enter your account no");
						acc[i].setAccno(sc.nextInt());
						System.out.println("Enter your Amount to deposited");
						acc[i].setBalance(sc.nextInt());
						System.out.println("Your account is created");
						i++;
					}
					else
					{
						System.out.println("Creating Loan account");
						acc[i] = new loan();
						//loan  = new loan();
						//loan s = (loan)acc[i];		//downcasting from account to loan if we want to access specific function of class
						System.out.println("Enter your name");
						acc[i].setName(sc.next());
						System.out.println("Enter your account no");
						acc[i].setAccno(sc.nextInt());
						System.out.println("Enter loan Amount");
						acc[i].setLoanamount(sc.nextInt());
						acc[i].setLi((acc[i].getLoanamount()*acc[i].getIntrest()));
						System.out.println("You have to pay :"+ acc[i].getLi());
						acc[i].setBalance(acc[i].getLi()+acc[i].getLoanamount());
						System.out.println("Your account is created");
						i++;
					}
				}
				
			}
			if(ch == 2)
			{
				int flag=0;
				System.out.println("Enter your account no");
				int no = sc.nextInt();
				for(int j=0;j<i;j++)
				{
					
					if(acc[j].getAccno() == no)
					{	
						flag=1;
						System.out.println("Name is "+ acc[j].getName());
						System.out.println("Account number is "+acc[j].getAccno());
						System.out.println("Balance in your account is "+acc[j].getBalance());
						System.out.println("Which Function you want to perform");
						System.out.println("1.Withdraw");
						System.out.println("2.Deposit");
						System.out.println("3.Mini Statement");
						int abc = sc.nextInt();
						if(abc==1)
						{
							acc[j].withdraw();
						}
						if(abc==2)
						{
							acc[j].deposit();
						}
						if(abc==3)
						{
							acc[j].ministatement();
						}
					}
					
				}
				if(flag==0)
				{
						System.out.println("You Dont have an account please create account first");
						break;
				}
			}
			if( ch == 3 )
			{	
				int flag=0;
				int local=0;
				System.out.println("Enter your account no");
				int no = sc.nextInt();
				for(int j=0;j<i;j++)
				{
					if(acc[j].getAccno() == no)
					{	
						flag=1;
						local = j;						
					}
				}
				int trav=0;
				if(flag==1)
				{
					for(int j=0;j<i;j++)
					{
						if(j==local)
						{
						j+=1;
						acc[j-1]=acc[j];
						
						}
					}
					while(trav == i)
					{
						acc[trav]=null;
					}
					//i--;
				}
				else
				{
					System.out.println("Account No. not found");
				}
			}
			System.out.println("Do You Want to continue");
			choice = sc.next();
		}while(choice.equals("y") || choice.equals("Y"));
	sc.close();
	}

}
