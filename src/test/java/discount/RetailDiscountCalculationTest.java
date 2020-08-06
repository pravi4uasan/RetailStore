package discount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.discount.holder.BillDetails;
import com.retail.discount.holder.ItemDetails;
import com.retail.discount.holder.UserDetails;
import com.retail.discount.request.RetailDiscountCalculationRequest;
import com.retail.discount.response.RetailDiscountCalculationResponse;

import lombok.SneakyThrows;

@SpringBootTest
@AutoConfigureMockMvc
public class RetailDiscountCalculationTest {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@SneakyThrows
	public void totalBillAmountTest() {
		RetailDiscountCalculationRequest retailDiscountCalculationRequest=new RetailDiscountCalculationRequest();
		UserDetails userDetails=new UserDetails();
		BillDetails billDetails=new BillDetails();
		ItemDetails itemDetails=new ItemDetails();
		
		userDetails.setUserId(1);
		userDetails.setUserName("praveen");
		userDetails.setUserType("employee");
		userDetails.setUserMembershipDate(new Date("2020-08-06 11:42:01"));
		
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
		ObjectMapper objectMapper=new ObjectMapper();
		RetailDiscountCalculationResponse retailDiscountCalculationResponse=objectMapper.readValue
				(result.getResponse().getContentAsString(), RetailDiscountCalculationResponse.class);
		
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	

}
