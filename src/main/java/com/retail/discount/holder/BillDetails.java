package com.retail.discount.holder;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BillDetails {
	
	private UserDetails userDetails;
	private List<ItemDetails> itemDetailsList;
	private Date purchaseDate;
	

}
