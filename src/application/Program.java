package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		
		try
		{
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = tec.nextInt();
			System.out.print("Holder: ");
			tec.nextLine();
			String holder = tec.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = tec.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = tec.nextDouble();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(tec.nextDouble());
			System.out.println(account);
		}
		catch(DomainException e)
		{
			System.out.println("Withdraw error: " +e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("unexpected error");
		}
		
		
		tec.close();
	}

}
