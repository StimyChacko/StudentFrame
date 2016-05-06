package com.service;
import java.util.List;

import com.model.marks;
import com.model.login;
import com.model.studentinfo;
import com.model.subject;

public interface studentservice {

	public List logchk (String username, String password);
	public List<subject> getsubj();
	public void addstudent(studentinfo stdinf);

	public String adminadded (login log);
	
	public void deletestudent(int id);
	public void deletemark(int id);
	
	public studentinfo findstudentById(int id);
	public void updatestudent(studentinfo stdinf);
	public void updatemark(marks mark);
	public List<studentinfo> liststudent();
	
	public void addmark(marks mark);
	public marks markrow(int studid);
	public float markper(int studid);
}
