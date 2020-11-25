package com.accenture.trainingcfrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.trainingcfrest.domain.SalesOrderEntity;

@Repository
public interface SalesOrderRepository extends  JpaRepository<SalesOrderEntity, String> {
	
}

