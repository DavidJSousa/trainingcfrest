package com.accenture.trainingcfrest.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRAINING_SALESORDER_TBLSALESORDER")
public class SalesOrderEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UsersEntity user_id;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private ClientsEntity client_id;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATEDAT")
	private LocalDateTime createDat;
	
	@Column(name = "MODIFIEDAT")
	private LocalDateTime modifiedDat;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "MODIFIEDBY")
	private String modifiedBy;
	
	@OneToMany(mappedBy = "salesOrderId", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH })
    private List<SalesOrderItemEntity> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UsersEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UsersEntity user_id) {
		this.user_id = user_id;
	}

	public ClientsEntity getClient_id() {
		return client_id;
	}

	public void setClient_id(ClientsEntity client_id) {
		this.client_id = client_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<SalesOrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItemEntity> items) {
		this.items = items;
	} 
	
}
