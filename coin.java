package com.coin.pack;

public class coin implements Comparable<coin>
{
	int currentvalue;
	String yearofmining;
	String denomination;
	String acquireddate;
	
	
	
	public int getCurrentvalue() {
		return currentvalue;
	}

	public String getYearofmining() {
		return yearofmining;
	}

	public String getDenomination() {
		return denomination;
	}

	public String getAcquireddate() {
		return acquireddate;
	}

	public void setCurrentvalue(int currentvalue) {
		this.currentvalue = currentvalue;
	}

	public void setYearofmining(String yearofmining) {
		this.yearofmining = yearofmining;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public void setAcquireddate(String acquireddate) {
		this.acquireddate = acquireddate;
	}
	
	public int compareTo(coin i) // y not integer 
	{
		if(this.currentvalue < i.currentvalue)
		{
			return -1;
		}
		if(this.currentvalue > i.currentvalue)
		{
		return 1;
		}
		else
		{
			return 0;
		}
	}

	public coin(int currentvalue, String yearofmining, String denomination, String acquireddate) 
	{
		this.currentvalue = currentvalue;
		this.yearofmining = yearofmining;
		this.denomination = denomination;
		this.acquireddate = acquireddate;
	}
	
	public void display()
	{

		System.out.println("Aquired Date "+getAcquireddate());
		System.out.println("Curretn Value "+getCurrentvalue());
		System.out.println("Year of Minting "+getYearofmining());
		System.out.println("Denomination "+getDenomination());
	}
	
	
}
