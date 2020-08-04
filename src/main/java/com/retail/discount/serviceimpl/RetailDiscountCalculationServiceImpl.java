package com.retail.discount.serviceimpl;

import org.springframework.stereotype.Service;

import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;
import com.retail.discount.service.RetailDiscountCalculationService;

@Service
public class RetailDiscountCalculationServiceImpl implements RetailDiscountCalculationService{

	@Override
	public RetailDiscountCalculationResponse calculateTotalBillAmount(
			RetailDiscountCalculationRequest retailDiscountCalculationRequest) {
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=new RetailDiscountCalculationResponse();
		
		
		retailDiscountCalculationResponse.setTotalBillAmount(10);
		return retailDiscountCalculationResponse;
	}
	
	

}
