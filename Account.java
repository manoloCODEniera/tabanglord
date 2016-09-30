import.java.util.*;

public class Account
{
	private int accountNumber = 000;
	private double balance = 0.0;

	Account(){

	}

    Account(int accountNumber, double balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
    }

    public int getAccountNumber(){
    	return accountNumber;
    }

    public int getBalance(){
    	return balance;
    }

    public void setBalance(double balance){
    	if (balance < 0)
            throw new IllegalArgumentException("You're in debt!");
        else
    	    this.balance = balance;
    } 

    public void credit(double balance){
    	if (balance < 0)
    		throw new IllegalArgumentException("You're giving yourself debt!");
    	else
    		this.balance += balance;
    }

    public void debit(double balance){
    	if (balance < 0 )
    		throw new IllegalArgumentException("You can't go out of debt");
    	else
    		this.balance -= balance;
    }

    public String toString(){
    	String account = String.format("A/C no: %d , Balance = $ %d", accountNumber, balance)
    	return account;
    }
}