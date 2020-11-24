package com.accenture.trainingcfrest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRAINING_USER_TBLUSER")
public class UsersEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CREATEDAT")
	private LocalDateTime createDat;
	
	@Column(name = "MODIFIEDAT")
	private LocalDateTime modifiedDat;
	
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

	public LocalDateTime getCreateDat() {
		return createDat;
	}

	public void setCreateDat(LocalDateTime createDat) {
		this.createDat = createDat;
	}

	public LocalDateTime getModifiedDat() {
		return modifiedDat;
	}

	public void setModifiedDat(LocalDateTime modifiedDat) {
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
