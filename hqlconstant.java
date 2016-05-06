package com.util;

public class hqlconstant {
	public static final String UserQuery=  " from login "
											+ " where username = :username and password = :password "; 
	public static final String SubQuery= " from subject ";
	public static final String MarkQuery=  " from marks "
											+ " where Stud_id = :studid "; 
}
