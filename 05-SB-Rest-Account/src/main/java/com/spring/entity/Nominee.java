package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nominee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	 	private long nomineeId;
		
	    private String name;
	    private String govtId; 
	    private String govtIdType; 
	    private String phoneNo;
	    private Relation relation;
	    
	    
		public long getNomineeId() {
			return nomineeId;
		}
		public void setNomineeId(long nomineeId) {
			this.nomineeId = nomineeId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGovtId() {
			return govtId;
		}
		public void setGovtId(String govtId) {
			this.govtId = govtId;
		}
		public String getGovtIdType() {
			return govtIdType;
		}
		public void setGovtIdType(String govtIdType) {
			this.govtIdType = govtIdType;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public Relation getRelation() {
			return relation;
		}
		public void setRelation(Relation relation) {
			this.relation = relation;
		} 
	    
	    
}
