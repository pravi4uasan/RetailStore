package com.retail.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;
import com.retail.discount.service.RetailDiscountCalculationService;

@RestController
public class RetailDiscountCalculationController {
	
	@Autowired
	RetailDiscountCalculationService retailDiscountCalculationService;
	
	@PostMapping(value="/retailstore/billamount" ,produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public RetailDiscountCalculationResponse totalBillAmount(@RequestBody RetailDiscountCalculationRequest
			retailDiscountCalculationRequest) {
				return retailDiscountCalculationService.calculateTotalBillAmount(retailDiscountCalculationRequest);
		
	}
	

}
