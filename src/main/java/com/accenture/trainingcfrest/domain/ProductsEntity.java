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
@Table(name = "TRAINING_PRODUCTS_TBLPRODUCTS")
public class ProductsEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	
	@Column(name = "SALESPRICE")
	private Double salesprice;
	
	@Column(name = "BASEPRICE")
	private Double baseprice;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
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
	
	@Column(name = "VALIDFROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validFrom;
	
	@Column(name = "VALIDTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validTo;
	
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Double getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(Double salesprice) {
		this.salesprice = salesprice;
	}
	public Double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}	
}
