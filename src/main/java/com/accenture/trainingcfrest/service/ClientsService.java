package com.accenture.trainingcfrest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.trainingcfrest.domain.ClientsEntity;
import com.accenture.trainingcfrest.dto.ClientsTO;
import com.accenture.trainingcfrest.repository.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	ClientsRepository rep;
	
	@Autowired
	ModelMapper mapper;
	
	public ClientsTO saveClient(ClientsTO client){
		ClientsEntity save = rep.save(mapper.map(client, ClientsEntity.class));		
		return mapper.map(save, ClientsTO.class);
	}
	
	public List<ClientsTO> findall() {
        List<ClientsEntity> findAll = rep.findAll();
        return findAll.stream().map(item -> {
            return mapper.map(item, ClientsTO.class);
        }).collect(Collectors.toList());
    }
	
	public ClientsTO findById(String id) {
        Optional<ClientsEntity> findId = rep.findById(id);

        if(findId.isPresent()){
            return mapper.map(findId.get(), ClientsTO.class);
        }
        return null;
    }
       
	public String deleteClient(String id) {
		if(rep.existsById(id)) {
			rep.deleteById(id);
			return "Success";	
		} else {
			return "Insucess";
		}
	}

}
