package com.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dao.markdao;
import com.model.marks;
import com.util.hqlconstant;


@Repository("markdao")
public class markdaoimpl implements markdao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Override
	public void markro(int studid) {
		Session session = sessionFactory.openSession();
		String hql = hqlconstant.MarkQuery;
		Query query = session.createQuery(hql);
		query.setParameter("studid", studid);
		marks markobj = (marks) query.uniqueResult();
		float percentage = ((markobj.getTotal())/600)*100;
		assertTrue(percentage > 50.00);
			
		
		session.close();

	}

}
