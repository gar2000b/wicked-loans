package com.onlineinteract;

import java.util.Date;

public class HISTORY {

	public String description;
	public Date date;
	public String Type;
	public float amount;

	
	public static HISTORY gethistory(int no)
	{
		if (no == 1)
		{
		HISTORY history = new HISTORY();
		history.description = "Car Loan";
		history.date = new Date();
		history.Type = "Car Loan";
		history.amount = 22000;
		return history;
		} else if (no == 2)
		{
			HISTORY history = new HISTORY();
			history.description = "Car Loan Repayment";
			history.date = new Date();
			history.Type = "Car Loan Repayment";
			history.amount = 2000;
			return history;			
		} else if (no == 3)
		{
			HISTORY history = new HISTORY();
			history.description = "Mortgage Loan";
			history.date = new Date();
			history.Type = "Mortgage Loan";
			history.amount = 850000;
			return history;			
		} else if (no == 4)
		{
			HISTORY history = new HISTORY();
			history.description = "Mortgage Loan Repayment";
			history.date = new Date();
			history.Type = "Mortgage Loan Repayment";
			history.amount = 5000;
			return history;			
		} else 
		{
			return null;
		}
	}
}
