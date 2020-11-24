package com.accenture.trainingcfrest.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private LocalDateTime createDat;
	
	@Column(name = "MODIFIEDAT")
	private LocalDateTime modifiedDat;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "MODIFIEDBY")
	private String modifiedBy;
	
	@Column(name = "VALIDFROM")
	private LocalDateTime validFrom;
	
	@Column(name = "VALIDTO")
	private LocalDateTime validTo;
	
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
	public LocalDateTime getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDateTime validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDateTime getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDateTime validTo) {
		this.validTo = validTo;
	}	
}
