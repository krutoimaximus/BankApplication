package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bankapp.entites.Customers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addCustomer(Customers customers) {
		manager.persist(customers);
		return true;
	}

	@Override
	public List<Customers> getAllCustomers() {
		TypedQuery<Customers> query = manager.createQuery("From Customers", Customers.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean updateCustomer(Customers customers) {
		Customers customer1 = manager.find(Customers.class, customers.getCustomerid());
		BeanUtils.copyProperties(customers, customer1);
		return true;
	}

	@Override
	public Customers getCustomerById(int customerid) {
		Customers customer = manager.find(Customers.class, customerid);
		return customer;
	}

	@Override
	@Transactional
	public boolean deleteCustomer(int customerid) {
		Customers customer = manager.find(Customers.class, customerid);
		manager.remove(customer);
		return true;
	}

	@Override
	public Customers validateReciever(String firstName, String lastName, String accNo) {
		String query = "Select c From Customers c where c.first='" + firstName + "' and c.last= '" + lastName
				+ "' and c.accountno='" + accNo + "'";
		TypedQuery<Customers> data = manager.createQuery(query, Customers.class);
		return data.getSingleResult();
	}

	@Override
	public Customers getPassword(int customerid) {
		String query = " Select p From Customers p where p.customerid=" + customerid;
		TypedQuery<Customers> result = manager.createQuery(query, Customers.class);
		return result.getSingleResult();
	}

	@Override
	@Transactional
	public int customerDebit(int customerid, String accountno, int debit) {
		Customers customer = manager.find(Customers.class, customerid);
		int mainbalance = customer.getBalance();
		int amount = mainbalance - debit;
		if (mainbalance < debit) {
//			System.out.println("No sufficient Balance");
			return 0;
		} else {
			customer.setBalance(amount);

			Query query = manager.createQuery("UPDATE Customers SET balance = balance+'" + debit + "' where accountno=" + accountno);
			int rows = query.executeUpdate();
			return rows;
//		String query="Select c From Customers c where c.accountno="+accountno;
//				"' and c.openb=c.openb+'"+debit;

//		TypedQuery<Customers> result = manager.createQuery(query,Customers.class);

//		result.getSingleResult();
//		Query result=manager.createQuery("UPDATE Transactions SET credit='"+debit+"'where accountNo='"+accountno+"'");
//		int data=result.executeUpdate();
//		
//		Query debit_transaction=manager.createQuery("UPDATE Transactions SET debit='"+debit+"'where customerid='"+customerid+"'");
//		int finalval=debit_transaction.executeUpdate();

//		System.out.println("Transaction Successfull");
//		return finalval ;

			
//		String query="Update Customers p set p.openb=data+value";
//		Query result=manager.createQuery(query,Customers.class);
//		return customer;
//		return finalval;

//		customer.get(Customers.class,customerDebit(debit, accountno);
//		CriteriaBuilder cb= manager.getCriteriaBuilder();
//		CriteriaUpdate<Customers> update= cb.createCriteriaUpdate(Customers.class);
//		Root<Customers>root=update.from(Customers.class);
//		update.set(Customers.getOpenb(),cb.sum(root.get(openb),debit));
//		System.out.println(value);
//		Query result= manager.createQuery("UPDATE Customers p set p.openb=p.openb - :debited"+" where p.customerid=:customer",Customers.class);
//		result.setParameter("debited", value);
//		result.setParameter("customer", customerid);
//		result.executeUpdate();
//	}	return customerDebit(customerid, accountno, debit) ;
		}
	}

	@Override
	@Transactional
	public boolean changePassword(int customerid, String password) {
		Customers customer = manager.find(Customers.class, customerid);
		customer.setPassword(password);
		return true;
	}
}
