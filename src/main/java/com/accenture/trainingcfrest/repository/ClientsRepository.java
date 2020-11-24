package com.accenture.trainingcfrest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.trainingcfrest.domain.ClientsEntity;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, String>{
	
}
	

