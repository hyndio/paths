package f.rd.paths.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import f.rd.paths.entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/root-context.xml"})
public class HibernateConfigTest {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Ignore
	@Test
	public void retrieveAccount() {
		// not part of a transaction, so we need to open a session manually
		Session session = sessionFactory.openSession(); 
		Query query = session.createQuery("from Account a where a.id=:id").setInteger("id", 1);
		Account a = (Account) query.uniqueResult();
		System.out.println();
		System.out.println(a);
		System.out.println();
		session.close();
		Assert.assertEquals(a.getCashBalance(), 500.0, 0.01);
	}
	
	@Ignore
	@Test @Transactional
	public void updateAccount() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account a where a.id=:id").setInteger("id", 1);
		Account a = (Account) query.uniqueResult();
		a.setName("foo");
		
		System.out.println();
		System.out.println(a);
		System.out.println();
	}
	
}
