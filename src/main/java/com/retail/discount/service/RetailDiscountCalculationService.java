package com.retail.discount.service;

import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;

public interface RetailDiscountCalculationService {
	
	RetailDiscountCalculationResponse calculateTotalBillAmount(RetailDiscountCalculationRequest retailDiscountCalculationRequest);

}
