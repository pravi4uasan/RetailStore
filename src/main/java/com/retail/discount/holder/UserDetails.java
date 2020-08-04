package com.retail.discount.holder;

import java.util.Date;

import lombok.Data;

@Data

public class UserDetails {
	
	private int userId;
	private String userName;
	private String userType;
	private Date userMembershipDate;
	

}
