package com.retail.discount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.discount.controller.RetailDiscountCalculationController;
import com.retail.discount.holder.BillDetails;
import com.retail.discount.holder.ItemDetails;
import com.retail.discount.holder.UserDetails;
import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class RetailDiscountCalculationTest {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@SneakyThrows
	
	//user is employee with grocerry
	public void totalBillAmountTest() {
		RetailDiscountCalculationRequest retailDiscountCalculationRequest=new RetailDiscountCalculationRequest();
		UserDetails userDetails=new UserDetails();
		BillDetails billDetails=new BillDetails();
		ItemDetails itemDetails=new ItemDetails();
		
		userDetails.setUserId(1);
		userDetails.setUserName("praveen");
		userDetails.setUserType("employee");
		userDetails.setUserMembershipDate(new Date());
		
		itemDetails.setName("salt");
		itemDetails.setCategory("grocerry");
		itemDetails.setQauntity(2);
		itemDetails.setPrice(100.00);
		List<ItemDetails> itemDetailsList= new ArrayList<ItemDetails>();
		itemDetailsList.add(itemDetails);
		
		billDetails.setUserDetails(userDetails);
		billDetails.setItemDetailsList(itemDetailsList);
		billDetails.setPurchaseDate(new Date());
		
		retailDiscountCalculationRequest.setBillDetails(billDetails);
		
		MvcResult result=mvc.perform(
				MockMvcRequestBuilders.post("/retailstore/billamount").content(asJsonString(retailDiscountCalculationRequest))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status=result.getResponse().getStatus();
		log.info("test response code>>"+status);
		ObjectMapper objectMapper=new ObjectMapper();
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=objectMapper.readValue
				(result.getResponse().getContentAsString(), RetailDiscountCalculationResponse.class);
		log.info("test response>>"+retailDiscountCalculationResponse.getTotalBillAmount());
		double totalBill=retailDiscountCalculationResponse.getTotalBillAmount();
		assert(190.0 == totalBill);
	}

	@Test
	@SneakyThrows
	//affiliate with grocerry 
	public void totalBillAmountTest1() {
		RetailDiscountCalculationRequest retailDiscountCalculationRequest=new RetailDiscountCalculationRequest();
		UserDetails userDetails=new UserDetails();
		BillDetails billDetails=new BillDetails();
		ItemDetails itemDetails=new ItemDetails();
		
		userDetails.setUserId(1);
		userDetails.setUserName("praveen");
		userDetails.setUserType("affiliate");
		userDetails.setUserMembershipDate(new Date());
		
		itemDetails.setName("rice");
		itemDetails.setCategory("grocerry");
		itemDetails.setQauntity(2);
		itemDetails.setPrice(200.00);
		List<ItemDetails> itemDetailsList= new ArrayList<ItemDetails>();
		itemDetailsList.add(itemDetails);
	
		
		billDetails.setUserDetails(userDetails);
		billDetails.setItemDetailsList(itemDetailsList);
		billDetails.setPurchaseDate(new Date());
		
		retailDiscountCalculationRequest.setBillDetails(billDetails);
		
		MvcResult result=mvc.perform(
				MockMvcRequestBuilders.post("/retailstore/billamount").content(asJsonString(retailDiscountCalculationRequest))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status=result.getResponse().getStatus();
		log.info("test2 response code>>"+status);
		ObjectMapper objectMapper=new ObjectMapper();
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=objectMapper.readValue
				(result.getResponse().getContentAsString(), RetailDiscountCalculationResponse.class);
		log.info("test2 response>>"+retailDiscountCalculationResponse.getTotalBillAmount());
		double totalBill=retailDiscountCalculationResponse.getTotalBillAmount();
		assert(380.0 == totalBill);
	}
	
	@Test
	@SneakyThrows
	//customer with grocerry 
	public void totalBillAmountTest3() {
		RetailDiscountCalculationRequest retailDiscountCalculationRequest=new RetailDiscountCalculationRequest();
		UserDetails userDetails=new UserDetails();
		BillDetails billDetails=new BillDetails();
		ItemDetails itemDetails=new ItemDetails();
		
		userDetails.setUserId(1);
		userDetails.setUserName("praveen");
		userDetails.setUserType("customer");
		SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 
		Date date6=formatter6.parse("31-Dec-1998 23:37:50");  
		userDetails.setUserMembershipDate(date6);
		
		itemDetails.setName("sugar");
		itemDetails.setCategory("nongrocerry");
		itemDetails.setQauntity(5);
		itemDetails.setPrice(100.00);
		List<ItemDetails> itemDetailsList= new ArrayList<ItemDetails>();
		itemDetailsList.add(itemDetails);
	
		
		billDetails.setUserDetails(userDetails);
		billDetails.setItemDetailsList(itemDetailsList);
		billDetails.setPurchaseDate(new Date());
		
		retailDiscountCalculationRequest.setBillDetails(billDetails);
		
		MvcResult result=mvc.perform(
				MockMvcRequestBuilders.post("/retailstore/billamount").content(asJsonString(retailDiscountCalculationRequest))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status=result.getResponse().getStatus();
		log.info("test3 response code>>"+status);
		ObjectMapper objectMapper=new ObjectMapper();
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=objectMapper.readValue
				(result.getResponse().getContentAsString(), RetailDiscountCalculationResponse.class);
		log.info("test3 response>>"+retailDiscountCalculationResponse.getTotalBillAmount());
		double totalBill=retailDiscountCalculationResponse.getTotalBillAmount();
		assert(455.0 == totalBill);
	}
	
	private static String asJsonString(final Object obj) {
		try {
			String jsonString=new ObjectMapper().writeValueAsString(obj);
			log.info("jsonString>>"+jsonString);
			return new ObjectMapper().writeValueAsString(obj);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	

}
