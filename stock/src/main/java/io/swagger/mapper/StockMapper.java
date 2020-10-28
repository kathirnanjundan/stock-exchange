package io.swagger.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.common.DateUtils;
import io.swagger.common.StringUtils;
import io.swagger.core.CreateContext;
import io.swagger.model.IParty;
import io.swagger.model.ITrade;
import io.swagger.model.Trade;
import io.swagger.persistence.StockMapperDao;

public class StockMapper {

	@Autowired
	StockMapperDao stockMapper = null;
	
	public static void tradeProcess() {

		List<IParty> sellerList = getPartyDetail("SELL");
		List<IParty> buyerList = getPartyDetail("BUY");
		
		List<Trade> matchedRecords = new ArrayList<>();
		
		for (IParty seller : sellerList) {
			Trade trade = new Trade();
			for (IParty buyer : buyerList) {
				if (buyer.getStock().equals(seller.getStock()) && buyer.getPrice().equals(seller.getPrice())
						&& !trade.getStatus().equals("Matched")) {
					trade.setStatus("Matched");
					trade.setSeller(seller.getParty());
					trade.setBuyer(buyer.getParty());
					trade.setPrice(new Double(buyer.getPrice()));
					trade.setStock(buyer.getStock());
					seller.setStatus("Matched");
					buyer.setStatus("Matched");
					matchedRecords.add(trade);
				}
			}
		}

		sellerList = sellerList.stream().filter(x -> (StringUtils.blank(x.getStatus()))).collect(Collectors.toList());
		buyerList = buyerList.stream().filter(x -> (StringUtils.blank(x.getStatus()))).collect(Collectors.toList());
		
		sellerList.addAll(buyerList);
		System.out.println(sellerList.size());
		
		StockMapperDao dao=(StockMapperDao) CreateContext.createInstance("stockMapperDao");
		dao.savePartyDetails(sellerList);

		dao.saveTradeDetails(matchedRecords);
	}
	
	public static List<IParty> getPartyDetail(String symbol) {
		StockMapperDao dao=(StockMapperDao) CreateContext.createInstance("stockMapperDao");
		return dao.getPartyDetails(symbol);
	}
	
	public static List<ITrade> getMatchedRecord(String party, String symbol, String date) {
		StockMapperDao dao=(StockMapperDao) CreateContext.createInstance("stockMapperDao");
		System.out.println("party: "+party+" symbol: "+symbol+" date: "+date);
		return dao.filterMatchedTradeList(party,symbol,date);
	}
	
	public static List<IParty> filterUnMatchedTradeList(String symbol, String date) {
		StockMapperDao dao=(StockMapperDao) CreateContext.createInstance("stockMapperDao");
		return dao.filterUnMatchedTradeList(symbol,date);
	}
	
	public static void main(String[] args) {
		//System.out.println(new StockMapper().getMatchedRecord("","",""));
		//tradeProcess();
		System.out.println(filterUnMatchedTradeList("GOOG",""));
	}
}
