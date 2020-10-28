package io.swagger.mapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class TestStockWebApp extends StockMapperTestController {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getFilteredRecords() throws Exception {
		mockMvc.perform(get("/api/v1/matched-trade-list"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.party").value("Party A")).andExpect(jsonPath("$.stock").value("IBM"))
				.andExpect(jsonPath("$.symbol").value("SELL")).andExpect(jsonPath("$.stock").value("IBM"))
				.andExpect(jsonPath("$.date").value("10-11-2020")).andExpect(jsonPath("$.stock").value("IBM"));;

	}
}
