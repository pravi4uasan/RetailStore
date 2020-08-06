package com.retail.discount.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.discount.holder.BillDetails;
import com.retail.discount.holder.ItemDetails;
import com.retail.discount.holder.UserDetails;
import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;
import com.retail.discount.service.RetailDiscountCalculationService;

@Service
public class RetailDiscountCalculationServiceImpl implements RetailDiscountCalculationService{

	@Override
	public RetailDiscountCalculationResponse calculateTotalBillAmount(
			RetailDiscountCalculationRequest retailDiscountCalculationRequest) {
		
		BillDetails billDetails = retailDiscountCalculationRequest.getBillDetails();
		
		UserDetails user = billDetails.getUserDetails();
		List<ItemDetails> items = billDetails.getItemDetailsList();
		String userType = user.getUserType();
		
		double discount = 0.0;
		LocalDate membershipDate = convertToLocalDateViaInstant(user.getUserMembershipDate());
		
		LocalDate currentDate = LocalDate.now();
		
		//Period period = Period.between(currentDate, membershipDate);
		Period period = Period.between(membershipDate, currentDate);
		
		int yearsSinceMembership = period.getYears();
		System.out.println("yearsSinceMembership>>>>>"+yearsSinceMembership);
		
		double total = 0.0;
		
		for (ItemDetails itemDetails : items) {
			for(int i=0; i< itemDetails.getQauntity(); i++) {
				
				if(!itemDetails.getCategory().equalsIgnoreCase("grocerry"))
				{
					if("employee".equalsIgnoreCase(userType)) {
						discount = 0.30;
					} else if("affiliate".equalsIgnoreCase(userType)) {
						discount = 0.10;
					} else if("customer".equalsIgnoreCase(userType) && yearsSinceMembership >= 2) {
						discount = 0.05;
					}
				} else {
					discount = 0.0;
				}

				double price = itemDetails.getPrice();
				total = total + ((1-discount) * (price));

			}
		}
		
		double billTotal = (total) - (((int) (total / 100)) * 5);
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=new RetailDiscountCalculationResponse();
		
		
		retailDiscountCalculationResponse.setTotalBillAmount(billTotal);
		return retailDiscountCalculationResponse;
	}
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	

}
