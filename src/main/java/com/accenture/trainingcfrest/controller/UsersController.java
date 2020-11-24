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

import com.accenture.trainingcfrest.dto.UsersTO;
import com.accenture.trainingcfrest.service.UsersService;

@RestController
@RequestMapping("/Users")
public class UsersController {
	
	@Autowired
	UsersService service;
	
	@PostMapping(value="")
    public UsersTO postUser(@RequestBody UsersTO user) {
    	return service.saveUser(user);
    }
	
	@GetMapping(value = "/{id}")
    public UsersTO getUserByID(@PathVariable(value = "id") String userID){
        return service.findById(userID);
    }
	
	@GetMapping(value = "")
    public List<UsersTO> getUsers(){
        return service.findall();
    }
	
	 @PutMapping("/{userID}")
	 public UsersTO updateUser(@PathVariable("userID") String id, @RequestBody UsersTO user){
	    	if(!id.equals(user.getId())) {
	    		return new UsersTO();
	    	}
	    	return service.saveUser(user);
	 }
	
	
	 @DeleteMapping(value = "/{id}")
	 public String deleteUser(@PathVariable(value="id") String id) {
		 return service.deleteUser(id);
	 }

}
