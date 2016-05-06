package com.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.studentdao;
import com.util.hqlconstant;
import com.model.studentinfo;

import com.model.login;
import com.model.marks;
import com.model.subject;

@Repository("studentdao")
public class studentdaoimpl implements studentdao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List logchk(String Username, String Password) {
		Session session = sessionFactory.openSession();
		String hql = hqlconstant.UserQuery;
		Query query = session.createQuery(hql);
		query.setParameter("username", Username);
		query.setParameter("password", Password);
		List list = query.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<subject> getsubj() {
		Session session = sessionFactory.openSession();
		String hql = hqlconstant.SubQuery;
		Query query = session.createQuery(hql);
		
		List slist = query.list();
		session.close();
		return slist;
	}
	
	@Override
	public void addstudent(studentinfo studinf) {
		sessionFactory.getCurrentSession().persist(studinf);
	}
	@Override
	public void addmark(marks mark) {
		sessionFactory.getCurrentSession().persist(mark);
	}

	@Override
	public String adminadded(login log) {
		String email=log.getEmail();
		System.out.println(email);
		sessionFactory.getCurrentSession().persist(log);
		return(email);
	}
	
	@Override
	public void deletestudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		studentinfo stdinf = (studentinfo) session.load(studentinfo.class, id);
		session.delete(stdinf);
		}
	
	@Override
	public void deletemark(int id) {
	Session session1 = sessionFactory.openSession();
	String hql = hqlconstant.MarkQuery;
	Query query = session1.createQuery(hql);
	query.setParameter("studid", id);
	marks markobj = (marks) query.uniqueResult();
	int mid=markobj.getmId();
	
	Session session = sessionFactory.getCurrentSession();
	marks markobj2 = (marks) session.load(marks.class, mid);
	session.delete(markobj2);
	session1.close();
	}

	@Override
	public studentinfo findstudentById(int id) {
		return (studentinfo) sessionFactory.getCurrentSession().get(studentinfo.class, id);
	}
	@Override
	public marks markrow(int studid) {
		Session session = sessionFactory.openSession();
		String hql = hqlconstant.MarkQuery;
		Query query = session.createQuery(hql);
		query.setParameter("studid", studid);
		marks markobj = (marks) query.uniqueResult();
		
		session.close();
		return markobj;
	}
	@Override
	public float markper(int studid) {
		Session session = sessionFactory.openSession();
		String hql = hqlconstant.MarkQuery;
		Query query = session.createQuery(hql);
		query.setParameter("studid", studid);
		marks markobj = (marks) query.uniqueResult();
		float percent=((markobj.getTotal()/600)*100);
		session.close();
		return percent;
	}
	@Override
	public void updatestudent(studentinfo stdinf) {
		sessionFactory.getCurrentSession().update(stdinf);
	}
	@Override
	public void updatemark(marks mark) {
		mark.setTotal(mark.getSub1()+mark.getSub2()+mark.getSub3()+mark.getSub4()+mark.getSub5()+mark.getSub6());
		sessionFactory.getCurrentSession().update(mark);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<studentinfo> liststudent() {
		Session session = sessionFactory.getCurrentSession();
		String hql = " from studentinfo ";
		Query query = session.createQuery(hql);
		List<studentinfo> stdinf = query.list();
		return stdinf;
	}
}
