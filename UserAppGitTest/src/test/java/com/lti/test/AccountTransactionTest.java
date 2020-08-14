package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AccountTransactionDao;
import com.lti.model.Account;
import com.lti.model.Customer;
import com.lti.model.Transaction;

public class AccountTransactionTest {
	AccountTransactionDao dao = new AccountTransactionDao();
	@Test
	public void addAccount() {
		
		Account account = new Account();
		account.setAccountType("Salary");;
		account.setBalance(50000);
		
		dao.addAccount(account);
		
	}
	
	@Test
	public void addTransactionsIntoAnAccount(){
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(3000);
		transaction.setTransactionDate(LocalDate.now());
		transactions.add(transaction);
		
		transaction = new Transaction();
		transaction.setAmount(5000);
		transaction.setTransactionDate(LocalDate.of(2020,02,23));
		transactions.add(transaction);
		
		transaction = new Transaction();
		transaction.setAmount(3000);
		transaction.setTransactionDate(LocalDate.of(2020,03,12));
		transactions.add(transaction);
		
		dao.addTransactionsIntoAnAccount(20201, transactions);
		
		
	}
	
	@Test
	public void addAccountWithTransactions(){
		Account account = new Account();
		account.setAccountType("Current");
		account.setBalance(50000.0);
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction t1 = new Transaction();
		t1.setAmount(5000.0);
		t1.setTransactionDate(LocalDate.now());
		
		Transaction t2 = new Transaction();
		t2.setAmount(10000.0);
		t2.setTransactionDate(LocalDate.now());
		
		transactions.add(t1);
		transactions.add(t2);
		
		dao.addAccountWithTransactions(account, transactions);
	}
	
	@Test
	public void fetchAllTransactionsOfAnAccount(){
		//System.out.println(dao.fetchAllTransactionsOfAnAccount(20201));
		
		List<Transaction> transactions = dao.fetchAllTransactionsOfAnAccount(20201);
		for(Transaction t: transactions) {
			System.out.println(t);
		}
	}
	
	@Test
	public void fetchAccountForATransaction() {
		Account account = dao.fetchAccountForATransaction(1010);
		System.out.println(account);
	}
	
	@Test
	public void fetchMaxAmountTransaction(){
		System.out.println(dao.fetchMaxAmountTransaction());
	}
	
	@Test
	public void fetchTransactionWithMaxAmount(){
		System.out.println(dao.fetchTransactionWithMaxAmount());
	}
	
	@Test
	public void miniStatement(){
		System.out.println(dao.miniStatement(LocalDate.of(2020, 2, 23), LocalDate.of(2020, 8, 11)));
	}
	
	@Test
	public void fetchMiniStatementForAccountNoOrderByLatestDate(){
		System.out.println(dao.fetchMiniStatementForAccountNoOrderByLatestDate(LocalDate.of(2020, 2, 23), LocalDate.of(2020, 8, 11), 20201));
		
	}
	
	@Test
	public void fetchAccountWithMaxNoOfTransactions(){
		System.out.println(dao.fetchAccountWithMaxNoOfTransactions());
	}
	
	@Test
	public void fetchAllAccounts(){
		System.out.println(dao.fetchAllAccounts());
	}
	
	@Test
    public void addNewCustomerWithNewAccount(){
        Customer customer=new Customer();
        customer.setCustomerName("John");
        customer.setCustomerCity("London");
        
        Account account=new Account();
        account.setAccountType("Savings");
        account.setBalance(12000);
        
        dao.addNewCustomerWithNewAccount(customer, account);
    }
	
	@Test
	public void fetchTest(){
		Account account = dao.getAccount(20201);
	}

}
