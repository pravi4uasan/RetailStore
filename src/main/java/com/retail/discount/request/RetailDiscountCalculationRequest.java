package com.retail.discount.request;

import com.retail.discount.holder.BillDetails;

import lombok.Data;

@Data
public class RetailDiscountCalculationRequest {
	
	private BillDetails billDetails;

}
