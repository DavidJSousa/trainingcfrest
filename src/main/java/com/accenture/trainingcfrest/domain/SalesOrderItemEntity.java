package com.accenture.trainingcfrest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TRAINING_SALESORDER_TBLSALESORDERITEM")
public class SalesOrderItemEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "SALESORDER_ID")
	private SalesOrderEntity salesOrderId;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private ProductsEntity productsID;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SalesOrderEntity getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(SalesOrderEntity salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public ProductsEntity getProductsID() {
		return productsID;
	}

	public void setProductsID(ProductsEntity productsID) {
		this.productsID = productsID;
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
