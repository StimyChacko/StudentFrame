package com.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table ( name = "subject" )
public class subject {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "Sub_id" )
	private int subId;
	
	
	@Column ( name = "Subj_name" )
	private String subjname;
	
	
	public String getSubjname() {
		return subjname;
	}
	public void setSubjname(String subjname) {
		this.subjname = subjname;
	}
	public subject()
	{
		
	}
	public subject(String subjname) {
		this.subjname = subjname;
		
	}



	public int getSubId() {
		return subId;
	}



	public void setSubId(int subId) {
		this.subId = subId;
	}



	


}
