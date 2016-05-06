package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

	@Entity
	@Table ( name = "studentinfo" )
	public class studentinfo {
		
		@Id
		@GeneratedValue ( strategy = GenerationType.IDENTITY )
		@Column ( name = "stud_id" )
		private int studId;
		
		
		@Column ( name = "stud_name" )
		private String studname;
		
		
		@Column ( name = "stud_age" )
		private int studage;
		
		
		@Column ( name = "stud_branch" )
		private String studbranch;
		
		@OneToOne (cascade = CascadeType.ALL)
		@JoinColumn ( name = "st_ad_id" )
		private stdaddress stdaddress;
		
		
		@Column ( name = "st_sub_id" )
		private int subjid;
		
		

		public studentinfo(){
			
		}
		
		public studentinfo(String studname, int studage, String studbranch) {
			this.studname = studname;
			this.studage = studage;
			this.studbranch = studbranch;
		}

		public int getStudId() {
			return studId;
		}

		public void setStudId(int studId) {
			this.studId = studId;
		}

		public String getStudname() {
			return studname;
		}

		public void setStudname(String studname) {
			this.studname = studname;
		}

		public int getStudage() {
			return studage;
		}

		public void setStudage(int studage) {
			this.studage = studage;
		}

		public String getStudbranch() {
			return studbranch;
		}

		public void setStudbranch(String studbranch) {
			this.studbranch = studbranch;
		}

		public stdaddress getStdaddress() {
			return stdaddress;
		}

		public void setStdaddress(stdaddress stdaddress) {
			this.stdaddress = stdaddress;
		}

		public int getSubjid() {
			return subjid;
		}

		public void setSubjid(int subjid) {
			this.subjid = subjid;
		}
		
	

}
