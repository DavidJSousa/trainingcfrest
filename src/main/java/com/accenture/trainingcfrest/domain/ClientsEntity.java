package com.accenture.trainingcfrest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRAINING_CLIENTS_TBLCLIENT")
public class ClientsEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "FAMILYNAME")
	private String familyName;
	
	@Column(name = "CREATEDAT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDat;
	
	@Column(name = "MODIFIEDAT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDat;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "MODIFIEDBY")
	private String modifiedBy;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getCreateDat() {
		return createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	public Date getModifiedDat() {
		return modifiedDat;
	}

	public void setModifiedDat(Date modifiedDat) {
		this.modifiedDat = modifiedDat;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
