package com.bank;

public abstract class Account 
{
	String name;
	int accno;
	double balance;
	int amount;
	static int date;
	int loanamount;
	static double intrest;
	double li;
	static int count;
	int[] arr = new int[10];
	static int dcount;
	int[] darr = new int[10];
	
	public static double getIntrest() 
	{
		return intrest;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public static int getDate() {
		return date;
	}

	public double getLi() {
		return li;
	}

	public static int getCount() {
		return count;
	}

//	public static void setCount(int count) {
//		Account.count = count;
//	}

	public static void setDate(int date) {
		Account.date = date;
	}

	public void setLi(double li) {
		this.li = li;
	}

	static 
	{
		intrest = 0.2;
		date =5;
		count =0;
		dcount=0;
	}


	
	public Account()
	{
		this.name=null;
		this.accno=0;
		this.balance=0;
		this.amount=0;
		this.li=0;
		this.loanamount=0;
		//this.arr[10]=0;
		//this.darr[10]=0;
		
	}
	

public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
public abstract void withdraw();
public abstract void deposit();
public abstract void ministatement();
}