package com.onlineinteract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loanapplication
{
	protected void loanapplication(int customerID)
	{
		// get customer based on customer ID
		customer c = Customerservice.getcustomer(String.valueOf(customerID));
		
		// social insurance verification lookup via canada services
		int sin = c.sin;
		String name = c.name;
		int age = c.age;
		
		boolean success = sinservice.verify(sin, name, age);
		
		// if succcess is true then proceed with loan application
		if (success == Boolean.TRUE)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("How much would you like to borrow?:");
			int borrowamount = sc.nextInt();
			
			// run fraud check
			// TODO fraud functionality here
			int id = c.id;
			boolean fraudcheck = true;
			
			// approval process - check whether this customer can receive
			// a loan from us based on amount requested.
			List<HISTORY> history = new ArrayList<>();
			history.add(HISTORY.gethistory(1));
			history.add(HISTORY.gethistory(2));
			history.add(HISTORY.gethistory(3));
			history.add(HISTORY.gethistory(4));
			
			float totalrepayments = 0;
			float totalborrowed = 0;
			boolean hisotrycheck;
			for (HISTORY item : history) 
			{
				if (item.Type.contains("Repayment"))
					totalrepayments = totalrepayments + item.amount;
				else
					totalborrowed = totalborrowed + item.amount;
			}
			if(totalrepayments > 5000)
				hisotrycheck = true;
			else
				hisotrycheck = false;
			
			// work out total loan ceiling
			int loanceiling = c.salary * 20;
			
			int loanamountallowed = 0;
			if(hisotrycheck)
			{
				loanamountallowed = loanceiling - ((int) totalborrowed - (int)totalrepayments);
				if (borrowamount > loanamountallowed)
				{
					System.out.println("Sorry, we can not lend you that amount.");
				}
				else
				{
					if (fraudcheck == true && hisotrycheck == true)
					{
						System.out.println("Whehey, looks like you're going to Disney Land!");
					}
				}
			}
		}
	}
}
