package com.accenture.traininigcfrest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.trainingcfrest.Application;
import com.accenture.trainingcfrest.controller.SalesOrderController;
import com.accenture.trainingcfrest.dto.ClientsTO;
import com.accenture.trainingcfrest.dto.ProductsTO;
import com.accenture.trainingcfrest.dto.SalesOrderItemTO;
import com.accenture.trainingcfrest.dto.SalesOrderTO;
import com.accenture.trainingcfrest.dto.UsersTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles(profiles = { "test" })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesOrderControllerTest {

	@Autowired
	private SalesOrderController controller;

	// Mock testing variables
	private static MockMvc mockMvc;
	private static ObjectMapper mapper;
	private static SalesOrderTO salesOrder;

	private static void getsalesOrderTest() {
		
		List<SalesOrderItemTO> items = new ArrayList<>();
		
		ProductsTO productsTO = new ProductsTO();
		productsTO.setName("Product Test");
		productsTO.setManufacturer("MAnufacturerTest");
		productsTO.setQuantity(10);
		productsTO.setBasePrice(10.0);
		productsTO.setSalesPrice(5.0);
		productsTO.setId("1");
		
		ClientsTO ClientsTO = new ClientsTO();
		ClientsTO.setName("client Test");
		ClientsTO.setAge(22);
		ClientsTO.setId("1");
		ClientsTO.setFamilyName("Sousa");
		
		UsersTO UsersTO = new UsersTO();
		UsersTO.setName("user Test");
		UsersTO.setId("1");
		
		SalesOrderItemTO salesOrderItemTO = new SalesOrderItemTO();
		salesOrderItemTO.setProductId(productsTO);
		salesOrderItemTO.setSalesOrderId("1");
		salesOrderItemTO.setStatus("C");
		salesOrderItemTO.setId("2");
		
		items.add(salesOrderItemTO);
		
		SalesOrderTO SalesOrderTO = new SalesOrderTO();
		SalesOrderTO.setClient_id(ClientsTO);
		SalesOrderTO.setStatus("C");
		SalesOrderTO.setUser_id(UsersTO);
		SalesOrderTO.setItems(items);
		SalesOrderTO.setId("1");
		salesOrder = SalesOrderTO;
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getsalesOrderTest();
	}

	@Before
	public void setUpBefore() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void aa_savesalesOrder() throws UnsupportedEncodingException, Exception {

		final byte[] salesOrderAsByteArray = mapper.writeValueAsBytes(salesOrder);

		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/SalesOrder")
				.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(salesOrderAsByteArray);

		final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();

		assertThat(result).isNotNull();
		assertThat(result).isNotEmpty();

		final SalesOrderTO objResult = mapper.readValue(result, SalesOrderTO.class);

		assertThat(objResult.getId()).isNotEmpty();
		salesOrder.setId(objResult.getId());
	}

	@Test
	public void ab_changesalesOrder() throws UnsupportedEncodingException, Exception {

		String newStatus = "C";
		
		salesOrder.setStatus(newStatus);
		final byte[] salesOrderAsByteArray = mapper.writeValueAsBytes(salesOrder);

		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/SalesOrder/"+salesOrder.getId())
				.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(salesOrderAsByteArray);

		final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();

		assertThat(result).isNotNull();
		assertThat(result).isNotEmpty();

		final SalesOrderTO objResult = mapper.readValue(result, SalesOrderTO.class);

		assertThat(objResult.getId()).isEqualTo(salesOrder.getId());
		assertThat(objResult.getStatus()).isEqualTo(newStatus);

	}

	@Test
	public void ac_getAllsalesOrders() throws UnsupportedEncodingException, Exception {

		
		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/SalesOrder")
				.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();

		assertThat(result).isNotNull();
		assertThat(result).isNotEmpty();

		final List<SalesOrderTO> objResult = Arrays.asList(mapper.readValue(result, SalesOrderTO[].class));
		assertThat(objResult.size()).isGreaterThan(0);

	}
	
	@Test
	public void ad_getOnesalesOrder() throws UnsupportedEncodingException, Exception {

		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/SalesOrder/"+salesOrder.getId())
				.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();

		assertThat(result).isNotNull();
		assertThat(result).isNotEmpty();

		final SalesOrderTO objResult = mapper.readValue(result, SalesOrderTO.class);
		assertThat(objResult.getId()).isEqualTo(salesOrder.getId());
		
		assertThat(objResult.getItems().size()).isGreaterThan(0);
	}
	@Test
	public void az_deletesalesOrder() throws UnsupportedEncodingException, Exception {

		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/SalesOrder/"+salesOrder.getId())
				.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value())).andReturn().getResponse()
				.getContentAsString();

	}

}
