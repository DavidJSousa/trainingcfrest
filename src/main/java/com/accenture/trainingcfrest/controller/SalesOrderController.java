package com.accenture.trainingcfrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.trainingcfrest.domain.SalesOrderEntity;
import com.accenture.trainingcfrest.dto.SalesOrderTO;
import com.accenture.trainingcfrest.service.SalesOrderService;


@RestController
@RequestMapping("/SalesOrder")
public class SalesOrderController {
	
	@Autowired
	SalesOrderService service;
	
	@GetMapping(value = "")
    public List<SalesOrderTO> getOrders(){
        return service.findall();
    }
	
	 @GetMapping(value = "/{id}")
    public SalesOrderTO getSalesOrderByID(@PathVariable(value = "id") String salesOrder){
        return service.findById(salesOrder);
    }
	
	
	@DeleteMapping(value = "/{id}")
    public String deleteSalesOrder(@PathVariable(value="id") String id) {
    	return service.deleteSalesOrder(id);
    }
	
	 @PutMapping("/{salesOrderID}")
    public SalesOrderTO updateProduct(@PathVariable("salesOrderID") String id, @RequestBody SalesOrderTO salesOrder){
    	if(!id.equals(salesOrder.getId())) {
    		return new SalesOrderTO();
    	}
    	return service.saveSalesOrder(salesOrder);
	 }
	
	
	
}
