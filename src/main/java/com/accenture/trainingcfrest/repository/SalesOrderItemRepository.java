package com.accenture.trainingcfrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.trainingcfrest.domain.SalesOrderItemEntity;

@Repository
public interface SalesOrderItemRepository extends  JpaRepository<SalesOrderItemEntity, String> {
	

}
