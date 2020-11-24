package com.accenture.trainingcfrest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.trainingcfrest.domain.UsersEntity;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String>{
	
}
