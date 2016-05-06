package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table ( name = "marks" )
public class marks {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "M_id" )
	private int mId;
	
	
	@Column ( name = "Stud_id" )
	private int studid;
	
	@Column ( name = "Sub1" )
	private float sub1;
		
	@Column ( name = "Sub2" )
	private float sub2;
	
	@Column ( name = "Sub3" )
	private float sub3;
	
	@Column ( name = "Sub4" )
	private float sub4;
	
	@Column ( name = "Sub5" )
	private float sub5;
	
	@Column ( name = "Sub6" )
	private float sub6;
	
	@Column ( name = "Total" )
	private float total;
	
	public marks()
	{
	
	}
	

	public marks(float sub1, float sub2, float sub3, float sub4, float sub5, float sub6, float total, int studid)
	{
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
		this.sub6 = sub6;
		this.total = total;
		this.studid = studid;
		}

	
	
	
	public int getmId() {
		return mId;
	}


	public void setmId(int mId) {
		this.mId = mId;
	}


	public int getStudid() {
		return studid;
	}


	public void setStudid(int studid) {
		this.studid = studid;
	}


	public float getSub1() {
		return sub1;
	}

	public void setSub1(float sub1) {
		this.sub1 = sub1;
	}

	public float getSub2() {
		return sub2;
	}

	public void setSub2(float sub2) {
		this.sub2 = sub2;
	}

	public float getSub3() {
		return sub3;
	}

	public void setSub3(float sub3) {
		this.sub3 = sub3;
	}

	public float getSub4() {
		return sub4;
	}

	public void setSub4(float sub4) {
		this.sub4 = sub4;
	}

	public float getSub5() {
		return sub5;
	}

	public void setSub5(float sub5) {
		this.sub5 = sub5;
	}

	public float getSub6() {
		return sub6;
	}

	public void setSub6(float sub6) {
		this.sub6 = sub6;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	

}
