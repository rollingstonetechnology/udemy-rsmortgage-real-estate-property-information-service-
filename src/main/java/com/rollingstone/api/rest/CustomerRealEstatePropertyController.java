package com.rollingstone.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.rollingstone.domain.Customer;
import com.rollingstone.domain.RealEstateProperty;
import com.rollingstone.exception.HTTP400Exception;
import com.rollingstone.service.RealEstatePropertyService;
/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/rsmortgage-customer-background-check-service/v1/background-check-order")
public class CustomerRealEstatePropertyController extends AbstractRestController {

    @Autowired
    private RealEstatePropertyService customerRealEstatePropertyService;
  
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerRealEstateProperty(@RequestBody RealEstateProperty realEstateProperty,
                                 HttpServletRequest request, HttpServletResponse response) {
    	RealEstateProperty createdRealEstateProperty = this.customerRealEstatePropertyService.createRealEstateProperty(realEstateProperty);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdRealEstateProperty.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<RealEstateProperty> getAllCustomersRealEstatePropertyByPage(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.customerRealEstatePropertyService.getAllRealEstatePropertysByPage(page, size);
    }
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<RealEstateProperty> getAllCustomerRealEstatePropertys(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
    
        return this.customerRealEstatePropertyService.getAllRealEstatePropertys();
    }
    
  
    
    @RequestMapping("/simple/{id}")
	public RealEstateProperty getSimpleCustomerRealEstateProperty(@PathVariable("id") Long id) {
    	RealEstateProperty realEstateProperty = this.customerRealEstatePropertyService.getRealEstateProperty(id);
         checkResourceFound(realEstateProperty);
         return realEstateProperty;
	}

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    RealEstateProperty getRealEstateProperty(@PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	RealEstateProperty realEstateProperty = this.customerRealEstatePropertyService.getRealEstateProperty(id);
        checkResourceFound(realEstateProperty);
        return realEstateProperty;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerRealEstateProperty(@PathVariable("id") Long id, @RequestBody RealEstateProperty realEstateProperty,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.customerRealEstatePropertyService.getRealEstateProperty(id));
        if (id != realEstateProperty.getId()) throw new HTTP400Exception("ID doesn't match!");
        this.customerRealEstatePropertyService.updateRealEstateProperty(realEstateProperty);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerRealEstateProperty(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.customerRealEstatePropertyService.getRealEstateProperty(id));
        this.customerRealEstatePropertyService.deleteRealEstateProperty(id);
    }
}
