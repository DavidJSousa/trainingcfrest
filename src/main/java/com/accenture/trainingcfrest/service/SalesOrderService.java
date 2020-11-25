package com.accenture.trainingcfrest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.trainingcfrest.domain.SalesOrderEntity;
import com.accenture.trainingcfrest.domain.SalesOrderItemEntity;
import com.accenture.trainingcfrest.dto.ClientsTO;
import com.accenture.trainingcfrest.dto.SalesOrderItemTO;
import com.accenture.trainingcfrest.dto.SalesOrderTO;
import com.accenture.trainingcfrest.dto.UsersTO;
import com.accenture.trainingcfrest.repository.SalesOrderItemRepository;
import com.accenture.trainingcfrest.repository.SalesOrderRepository;

@Service
public class SalesOrderService {
	
	@Autowired
	SalesOrderRepository repSalesOrder;
	
	@Autowired
	SalesOrderItemRepository repSalesOrderItem;
	
	@Autowired
	ModelMapper mapper;

	public List<SalesOrderTO> findall() {
        List<SalesOrderEntity> results = repSalesOrder.findAll();       
        return results.stream().map(item -> {
            SalesOrderTO salesOrder = mapper.map(item, SalesOrderTO.class);
           
            List<SalesOrderItemTO> collect = item.getItems().stream().map(soi -> {
                return mapper.map(soi, SalesOrderItemTO.class);
            }).collect(Collectors.toList());
            
            salesOrder.setItems(collect);
           
            ClientsTO cli = mapper.map(item.getClient_id(), ClientsTO.class);
            salesOrder.setClient_id(cli);
           
            UsersTO user = mapper.map(item.getUser_id(), UsersTO.class);
            salesOrder.setUser_id(user);
           
            return salesOrder;
        }).collect(Collectors.toList());
    }
	
	
	 
	
	public SalesOrderTO saveSalesOrder(SalesOrderTO salesOrder){
		SalesOrderEntity salesOrderEntity = mapper.map(salesOrder, SalesOrderEntity.class);
		
		
		if (Strings.isEmpty(salesOrderEntity.getId())) {
			salesOrderEntity.setCreatedBy("teste");
			salesOrderEntity.setCreateDat(LocalDateTime.now());
		}
			salesOrderEntity.setModifiedBy("teste");
			salesOrderEntity.setModifiedDat(LocalDateTime.now());
			SalesOrderEntity savedEntity = repSalesOrder.save(salesOrderEntity);
			
			salesOrderEntity.getItems().stream().forEach(item -> item.setSalesOrderId(savedEntity));
			repSalesOrderItem.saveAll(salesOrderEntity.getItems());
			
		return mapper.map(savedEntity, SalesOrderTO.class);
	}
	
	public SalesOrderTO findById(String id) {
        Optional<SalesOrderEntity> findId = repSalesOrder.findById(id);
        if(findId.isPresent()){
            return mapper.map(findId.get(), SalesOrderTO.class);
        }
        return null;
    }
	
	
	public String deleteSalesOrder(String id) {
		if(repSalesOrder.existsById(id)) {
			repSalesOrder.deleteById(id);
			return "Success";	
		} else {
			return "Insucess";
		}
	}
}
