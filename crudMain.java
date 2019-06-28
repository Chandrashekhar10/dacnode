package com.crud;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class crudMain {
	

	public static void main(String[] args)
	{
		String choice=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			do
			{
			System.out.println("Enter Choice");
			System.out.println("1.Create Table");
			System.out.println("2.Insert Data");
			System.out.println("3.Update Data");
			System.out.println("4.Show table");
			System.out.println("5.Delete table");
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1 : create();
					System.out.println("Table Created");
					break;
			case 2 : insert();
					System.out.println("Data Inserted");
					break;
			case 3 : update();
					System.out.println("Data Updated");
					break;
			case 4 : showtable();
					break;
			case 5 : delete();
					System.out.println("Value Deleted");
					break;
			}System.out.println("Do tou want to contonue");
				choice = sc.next();
			}while(choice.equalsIgnoreCase("y"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void showtable() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter table name");
		String name=sc.next();
		ResultSet res = stmt.executeQuery("Select * from "+name+" ");
		while(res.next())
		{
			System.out.println(res.getString(1)+"	"+res.getInt(2));
		}
		con.close();
	
	}

	public static void insert() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter table name");
		String nam=sc.next();
		System.out.println("Enter name");
		String na=sc.next();
		System.out.println("Enter age");
		int age=sc.nextInt();		
		String query ="insert into "+nam+" values ('"+na+"',"+age+")";
		int UpdateRowCount=stmt.executeUpdate(query);	
		con.close();
	}
	public static void create() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter table name");
		String name=sc.next();
		String query ="Create table "+name+" (name varchar(20),age int(10))";
		int UpdateRowCount=stmt.executeUpdate(query);
		con.close();
	}
	public static void update()throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter table name");
		String name=sc.next();
		System.out.println("Enter name which have to be updated");
		String nam=sc.next();
		System.out.println("Enter age which name is updating");
		int age=sc.nextInt();
		String query ="update "+name+" set name = '"+nam+"' where age = "+age+" ";
		int UpdateRowCount=stmt.executeUpdate(query);
		con.close();
	}
	public static void delete()throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter table name");
		String name=sc.next();
		System.out.println("Enter name which you want to delete");
		String nam=sc.next();
		String query ="delete from "+name+" where name = '"+nam+"'";
		int UpdateRowCount=stmt.executeUpdate(query);
		con.close();
	}

}
