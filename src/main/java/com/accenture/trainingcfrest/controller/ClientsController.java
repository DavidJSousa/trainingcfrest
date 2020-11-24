package com.accenture.trainingcfrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.trainingcfrest.dto.ClientsTO;
import com.accenture.trainingcfrest.service.ClientsService;


@RestController
@RequestMapping("/Clients")
public class ClientsController {
	
	@Autowired
	ClientsService service;
	
	@PostMapping(value="")
    public ClientsTO postClient(@RequestBody ClientsTO client) {
    	return service.saveClient(client);
    }
	
	@GetMapping(value = "/{id}")
    public ClientsTO getClientByID(@PathVariable(value = "id") String clientID){
        return service.findById(clientID);
    }
	
	@GetMapping(value = "")
    public List<ClientsTO> getClients(){
        return service.findall();
    }
	
	
	 @PutMapping("/{clientID}")
	 public ClientsTO updateClient(@PathVariable("clientID") String id, @RequestBody ClientsTO client){
	    	if(!id.equals(client.getId())) {
	    		return new ClientsTO();
	    	}
	    	return service.saveClient(client);
	 }
	
	
	 @DeleteMapping(value = "/{id}")
	 public String deleteClient(@PathVariable(value="id") String id) {
		 return service.deleteClient(id);
	 }
	
}
