package f.rd.paths.web.security.model;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import f.rd.paths.web.security.extend.impl.UserDetailsImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/root-context.xml"})
public class SS3Test {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Ignore
	@Test
	public void save() {
		// not part of a transaction, so we need to open a session manually
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setStaff(1);
		user.setEnabled(true);
		user.setOnline("no");
		user.setPassword("5536484b09fdfa322c70338849bcff11"); //1{sysadmin}
		user.setUsername("sysadmin");
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Ignore
	@Test
	public void get() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User a where a.staff=:id").setInteger("id", 1);
		User a = (User) query.uniqueResult();
		
		UserDetails user = new UserDetailsImpl(a.getStaff(), a.getUsername(), a.getPassword(), a.isEnabled(), new ArrayList<GrantedAuthority>(), true, true, true);
		
		System.out.println();
		System.out.println(user);
		System.out.println();
		session.close();
	}

}
