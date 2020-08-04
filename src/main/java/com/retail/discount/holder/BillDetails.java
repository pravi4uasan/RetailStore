package com.retail.discount.holder;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BillDetails {
	
	private int userId;
	private List<ItemDetails> itemDetailsList;
	private Date purchaseDate;
	

}
