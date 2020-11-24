package com.accenture.trainingcfrest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.trainingcfrest.domain.ProductsEntity;
import com.accenture.trainingcfrest.dto.ProductsTO;
import com.accenture.trainingcfrest.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	ProductsRepository rep;
	
	@Autowired
	ModelMapper mapper;
	
	public ProductsTO saveProduct(ProductsTO product){
		if (Strings.isEmpty(product.getId())) {
			product.setCreatedBy("teste");
			product.setCreateAt((LocalDateTime.now().toString()));
		}
			product.setModifiedBy("teste");
			product.setCreateAt(LocalDateTime.now().toString());
			ProductsEntity savedEntity = rep.save(mapper.map(product, ProductsEntity.class));
		return mapper.map(savedEntity, ProductsTO.class);
	}
	
	
	public List<ProductsTO> findall() {
        List<ProductsEntity> findAll = rep.findAll();
        return findAll.stream().map(item -> {
            return mapper.map(item, ProductsTO.class);
        }).collect(Collectors.toList());
    }
	
	public List<ProductsTO> findByKeyword(String keyword, boolean fuzzy) {
        List<ProductsEntity> findAll = null;
        
        if(Strings.isEmpty(keyword)) {
        	findAll = rep.findAll();
        } else {
        	
        	if(!fuzzy) {
        		keyword = "%" + keyword +"%";
        		findAll = rep.findByKeyword(keyword);
        	} else {
            	findAll = rep.findByKeywordWithFuzzy(keyword);
        	}
        }
       
        return findAll.stream().map(item -> {
            return mapper.map(item, ProductsTO.class);
        }).collect(Collectors.toList());
        
        
    }
	
	public ProductsTO findById(String id) {
        Optional<ProductsEntity> findId = rep.findById(id);

        if(findId.isPresent()){
            return mapper.map(findId.get(), ProductsTO.class);
        }
        return null;
    }
       
	public String deleteProduct(String id) {
		if(rep.existsById(id)) {
			rep.deleteById(id);
			return "Success";	
		} else {
			return "Insucess";
		}
	}

}
