package com.accenture.trainingcfrest.controller;
import com.sap.cloud.security.xsuaa.token.Token;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.trainingcfrest.dto.ProductsTO;
import com.accenture.trainingcfrest.service.ProductsService;


@RestController
@RequestMapping("/Products")
public class ProductsController {
	
	@Autowired
	ProductsService service;
    
    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    
    @GetMapping(value = "")
    public List<ProductsTO> getProducts(/*@AuthenticationPrincipal Token token*/){
        return service.findall();
    }
    
    @GetMapping(value = "/keysearch")
    public List<ProductsTO> findAll(@RequestParam(value="keyword", required = false) String keyword, @RequestParam(value="fuzzy") boolean fuzzy){
        return service.findByKeyword(keyword, fuzzy);
    }
    
    @PostMapping(value="")
    public ProductsTO postProduct(@RequestBody ProductsTO product) {
    	return service.saveProduct(product);
    }
    
    @PutMapping("/{productID}")
    public ProductsTO updateProduct(@PathVariable("productID") String id, @RequestBody ProductsTO product){
    	if(!id.equals(product.getId())) {
    		return new ProductsTO();
    	}
    	
    	return service.saveProduct(product);
    }
    
    @GetMapping(value = "/{id}")
    public ProductsTO getProductByID(@PathVariable(value = "id") String productID){
        return service.findById(productID);
    }
    
    @DeleteMapping(value = "/{id}")
    public String deleteProduct(@PathVariable(value="id") String id) {
    	return service.deleteProduct(id);
    }
}
 