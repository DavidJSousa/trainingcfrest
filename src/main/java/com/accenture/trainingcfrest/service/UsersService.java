package com.accenture.trainingcfrest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.trainingcfrest.domain.UsersEntity;
import com.accenture.trainingcfrest.dto.UsersTO;
import com.accenture.trainingcfrest.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository rep;
	
	@Autowired
	ModelMapper mapper;
	
	public UsersTO saveUser(UsersTO user){
		if (Strings.isEmpty(user.getId())) {
			user.setCreatedBy("teste");
			user.setCreateAt((LocalDateTime.now().toString()));
		}
			user.setModifiedBy("teste");
			user.setCreateAt(LocalDateTime.now().toString());
			UsersEntity savedEntity = rep.save(mapper.map(user, UsersEntity.class));
		return mapper.map(savedEntity, UsersTO.class);
	}
	
	public List<UsersTO> findall() {
        List<UsersEntity> findAll = rep.findAll();
        return findAll.stream().map(item -> {
            return mapper.map(item, UsersTO.class);
        }).collect(Collectors.toList());
    }
	
	public UsersTO findById(String id) {
        Optional<UsersEntity> findId = rep.findById(id);

        if(findId.isPresent()){
            return mapper.map(findId.get(), UsersTO.class);
        }
        return null;
    }
       
	public String deleteUser(String id) {
		if(rep.existsById(id)) {
			rep.deleteById(id);
			return "Success";	
		} else {
			return "Insucess";
		}
	}
}
