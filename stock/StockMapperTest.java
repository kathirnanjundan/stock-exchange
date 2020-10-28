package io.swagger.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.swagger.model.IParty;
import io.swagger.model.ITrade;

public class StockMapperTest {

	StockMapper stockMapper=null;
	@Before
	public void createInstance() {
		stockMapper=new StockMapper();
	}
	
	
	@Test
	public void getFilteredRecords() {
		// successfull search stock details based on Party A,SELL,10-11-2020
		List<ITrade> filteredRecords = stockMapper.getMatchedRecord("Party A", "SELL","10-29-2020");
		assertEquals("Party A", filteredRecords.get(0).getSeller());
		assertEquals("IBM", filteredRecords.get(0).getStock());
		assertEquals("110.0", filteredRecords.get(0).getPrice().toString());
		
		/*
		//Input based on Party D which is unknown. it should return empty.
		List<ITrade> filteredRecordsUnknown = stockMapper.getMatchedRecord("Party D", "SELL","10-29-2020");
		assertEquals(new Boolean(true),filteredRecordsUnknown==null||filteredRecordsUnknown.isEmpty());
		
		//unmatched records with output
		List<IParty> unmatchedRecords = stockMapper.filterUnMatchedTradeList("IBM","500");
		assertEquals("Party A",(unmatchedRecords.get(0).getParty()));
		
		//unmatched records with empty output
		List<IParty> unmatchedRecordsUnknown = stockMapper.filterUnMatchedTradeList("IBM","600");
		assertEquals(new Boolean(true),unmatchedRecordsUnknown.isEmpty());
		*/
	}
}
