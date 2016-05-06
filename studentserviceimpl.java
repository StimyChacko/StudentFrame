package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.studentdao;
import com.model.studentinfo;

import com.model.login;
import com.model.marks;
import com.model.subject;
import com.service.studentservice;

@Service("studentservice")
public class studentserviceimpl implements studentservice {
	@Autowired
	private studentdao studentdao;
	
	@Override
	@Transactional
	public List logchk(String username, String password) {
		return studentdao.logchk(username, password);
	}
	@Override
	@Transactional
	public List<subject> getsubj() {
		return studentdao.getsubj();
	}
	@Override
	@Transactional
	public void addstudent(studentinfo studinf) {
		studentdao.addstudent(studinf);
	}
	@Override
	@Transactional
	public void addmark(marks mark) {
		studentdao.addmark(mark);
	}
	
	@Override
	@Transactional
	public String adminadded (login log){
		
		return studentdao.adminadded(log);
		}
	@Override
	@Transactional
	public List<studentinfo> liststudent() {
		return studentdao.liststudent();
	}
	
	@Override
	@Transactional
	public void deletestudent(int id){
		studentdao.deletestudent(id);
	}
	@Override
	@Transactional
	public void deletemark(int id){
		studentdao.deletemark(id);
	}
	
	@Override
	@Transactional
	public studentinfo findstudentById(int id)
	{
		return studentdao.findstudentById(id);
	}
	@Override
	@Transactional
	public marks markrow(int studid)
	{
		return studentdao.markrow(studid);	
	}
	
	@Override
	@Transactional
	public float markper(int studid)
	{
		return studentdao.markper(studid);	
	}
	
	@Override
	@Transactional
	public void updatestudent(studentinfo stdinf){
		studentdao.updatestudent(stdinf);
	}
	@Override
	@Transactional
	public void updatemark(marks mark){
		studentdao.updatemark(mark);
	}
}
