package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.jpa.RsMortgageRealEstatePropertyRepository;
import com.rollingstone.domain.Customer;
import com.rollingstone.domain.RealEstateProperty;


/*
 * Service class to do CRUD for Customer RealEstateProperty through JPS Repository
 */
@Service
public class RealEstatePropertyService {

    private static final Logger log = LoggerFactory.getLogger(RealEstatePropertyService.class);

    @Autowired
    private RsMortgageRealEstatePropertyRepository customerRealEstatePropertyRepository;
    
  
    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public RealEstatePropertyService() {
    }

    public RealEstateProperty createRealEstateProperty(RealEstateProperty liability) {
        return customerRealEstatePropertyRepository.save(liability);
    }

    public RealEstateProperty getRealEstateProperty(long id) {
        return customerRealEstatePropertyRepository.findOne(id);
    }

    public void updateRealEstateProperty(RealEstateProperty liability) {
    	customerRealEstatePropertyRepository.save(liability);
    }

    public void deleteRealEstateProperty(Long id) {
    	customerRealEstatePropertyRepository.delete(id);
    }

    public Page<RealEstateProperty> getAllRealEstatePropertysByPage(Integer page, Integer size) {
        Page pageOfRealEstatePropertys = customerRealEstatePropertyRepository.findAll(new PageRequest(page, size));
        
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("com.rollingstone.getAll.largePayload");
        }
        return pageOfRealEstatePropertys;
    }
    
    public List<RealEstateProperty> getAllRealEstatePropertys() {
        Iterable<RealEstateProperty> pageOfRealEstatePropertys = customerRealEstatePropertyRepository.findAll();
        
        List<RealEstateProperty> customerRealEstatePropertys = new ArrayList<RealEstateProperty>();
        
        for (RealEstateProperty liability : pageOfRealEstatePropertys){
        	customerRealEstatePropertys.add(liability);
        }
    	log.info("In Real Service getAllRealEstatePropertys  size :"+customerRealEstatePropertys.size());

    	
        return customerRealEstatePropertys;
    }
    
}
