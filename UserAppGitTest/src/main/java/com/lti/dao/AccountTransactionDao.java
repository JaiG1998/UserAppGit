package com.lti.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Account;
import com.lti.model.Customer;
import com.lti.model.Transaction;


public class AccountTransactionDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public List<Account> fetchAllAccounts(){
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        TypedQuery<Account> query=em.createNamedQuery("account.allAccounts",Account.class);
        
        return query.getResultList();
    }

	public void addAccount(Account account) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();

		tx.begin();
		em.merge(account);
		tx.commit();
	}

	public void addTransactionsIntoAnAccount(int accountId, List<Transaction> transactions) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		Account account = em.find(Account.class, accountId);
		account.setTransactions(transactions);

		for (Transaction t : transactions) {
			t.setAccount(account);
		}

		tx = em.getTransaction();
		tx.begin();
		em.merge(account);
		tx.commit();

	}

	public void addAccountWithTransactions(Account account, List<Transaction> transactions) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		account.setTransactions(transactions);

		for (Transaction t : transactions) {
			t.setAccount(account);
		}

		tx = em.getTransaction();

		tx.begin();
		em.merge(account);
		tx.commit();

	}

	public List<Transaction> fetchAllTransactionsOfAnAccount(int accountId) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		Account account = em.find(Account.class, accountId);
		return account.getTransactions();

	}

	public Account fetchAccountForATransaction(int transactionId) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		Transaction transaction = em.find(Transaction.class, transactionId);
		return transaction.getAccount();

	}

	public double fetchMaxAmountTransaction() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		Query query = em.createQuery("select MAX(t.amount) from Transaction t");
		double maxAmount = (Double) query.getSingleResult();

		return maxAmount;
	}

	public List<Transaction> fetchTransactionWithMaxAmount() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		Query query = em
				.createQuery("select tx from Transaction tx where tx.amount=(select MAX(t.amount) from Transaction t)");
		return (List<Transaction>) query.getResultList();

	}

	public List<Transaction> miniStatement(LocalDate from, LocalDate to) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		String sql = "select tx from Transaction tx where tx.transactionDate between :from and :to";
		TypedQuery<Transaction> query = em.createQuery(sql, Transaction.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<Transaction> resultList = query.getResultList();
		return resultList;
	}

	public List<Transaction> fetchMiniStatementForAccountNoOrderByLatestDate(LocalDate from, LocalDate to,
			int accountNo) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		String sql = "select tx from Transaction tx where tx.transactionDate between :from and :to and tx.account.accountNumber =: accountNo order by tx.transactionDate desc";
		TypedQuery<Transaction> query = em.createQuery(sql, Transaction.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("accountNo", accountNo);
		List<Transaction> resultList = query.getResultList();
		return resultList;
	}

	public List<Account> fetchAccountWithMaxNoOfTransactions() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		String sql = "select tx.account.accountNumber from Transaction tx group by tx.account.accountNumber having sum(tx.amount) = (select max(sum(tx.amount)) from Transaction tx group by tx.account.accountNumber)";
		TypedQuery<Integer> query = em.createQuery(sql, Integer.class);
		List<Account> accounts = new ArrayList<Account>();
		
		for(Integer i  : query.getResultList()){
			accounts.add(em.find(Account.class, i));
		}
		return accounts;
	}
	
	public List<Account> fetchAccountWithMaxNoOfTransactions2() {
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        
        String sql1 ="select tx.account.accountNumber from Transaction tx group by tx.account.accountNumber having count(*) = (select max(count(*)) from Transaction t group by t.account.accountNumber)";
        Query qry=em.createQuery(sql1);
        List<Integer> list= qry.getResultList();
        
        List<Account> account = new ArrayList<Account>();
        
        for(int i : list) {
            account.add(em.find(Account.class,i));
        }
        
        return account;
    }
	
	
	public List<Account> fetchAccountWithMaxAmountOfTransactions() {
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        String sql = "select acc from Account acc where acc.accountNo="
                + "(select tx.account.accountNo from Transaction tx group by "
                + "tx.account.accountNo having sum(tx.transacAmount)=(select max(sum(tx.transacAmount)) "
                + "from Transaction tx group by tx.account.accountNo))";
        TypedQuery<Account> qry = em.createQuery(sql, Account.class);
        return qry.getResultList();
        
    }
	
	public void addNewCustomerWithNewAccount(Customer customer, Account account){
		emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        customer.setAccount(account);
        account.setCustomer(customer);
        tx.begin();
		em.merge(customer);
		tx.commit();
        
	}
	
	public Account getAccount(int accountId){
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        return em.find(Account.class, accountId);
    }
    public Customer getCustomer(int customerId){
        emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        return em.find(Customer.class, customerId);
    }

	

}
