package io.swagger.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import io.swagger.common.DateUtils;
import io.swagger.common.StringUtils;
import io.swagger.model.IParty;
import io.swagger.model.ITrade;
import io.swagger.model.Trade;

public class StockMapperDao {

	private JdbcTemplate jdbcTemplate;	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<IParty> getPartyDetails(String symbol) {
		
		String queryPartyDetils = "select PR_PARTY,PR_SYMBOL,PR_STOCK,PR_PRICE from StockMaster.ST_TR_PARTY_DETAIL where PR_SYMBOL=?";
        return jdbcTemplate.query(queryPartyDetils, new Object[]{symbol}, new PartyRowMapper());
	}
	
	public List<ITrade> filterMatchedTradeList(String party, String symbol, String date) {
		
		StringBuffer query = new StringBuffer();
		query.append("select TR_SELLER,TR_STOCK,TR_BUYER,TR_PRICE,TR_TRADE_DATE from StockMaster.ST_TR_Trade ");
		
		if(!StringUtils.blank(party) || !StringUtils.blank(symbol) || !StringUtils.blank(date)) {
			query.append(" Where ");
			if(!StringUtils.blank(party)) query.append("( TR_SELLER='").append(party).append("' OR TR_BUYER='").append(party).append("') ");
			if(!StringUtils.blank(party) &&!StringUtils.blank(symbol)) query.append("and");
			if(!StringUtils.blank(symbol)) query.append(" TR_STOCK='").append(symbol).append("'");
			if((!StringUtils.blank(party) || !StringUtils.blank(symbol)) && !StringUtils.blank(date)) query.append("and");
			if(!StringUtils.blank(date)) query.append(" TR_TRADE_DATE='").append(date).append("'");
		}
		System.out.println(query.toString());
        return jdbcTemplate.query(query.toString(), new Object[]{}, new MatchedTradeRowMapper());
	}
	
	public List<IParty> filterUnMatchedTradeList(String symbol, String price) {
		
		StringBuffer query = new StringBuffer();
		query.append("select PR_PARTY,PR_SYMBOL,PR_STOCK,PR_PRICE from StockMaster.ST_TR_PARTY_UNMAT_DETAIL ");
		
		if(!StringUtils.blank(symbol) || !StringUtils.blank(String.valueOf(price))) {
			query.append(" Where ");
			if(!StringUtils.blank(symbol)) query.append(" PR_STOCK='").append(symbol).append("'");
			if(!StringUtils.blank(symbol) &&!StringUtils.blank(String.valueOf(price))) query.append("and");
			if(!StringUtils.blank(String.valueOf(price))) query.append(" PR_PRICE='").append(price).append("'");
		}
		System.out.println(query.toString());
        return jdbcTemplate.query(query.toString(), new Object[]{}, new UnMatchedTradeRowMapper());
	}
	
	public int[] savePartyDetails(List<IParty> unMatchedList) {

        return this.jdbcTemplate.batchUpdate(
			"insert into StockMaster.ST_TR_PARTY_UNMAT_DETAIL (PR_PARTY, PR_SYMBOL,PR_STOCK,PR_PRICE) values(?,?,?,?)",
			new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, unMatchedList.get(i).getParty());
					ps.setString(2, unMatchedList.get(i).getSymbol());
					ps.setString(3, unMatchedList.get(i).getStock());
					ps.setInt(4, unMatchedList.get(i).getPrice());
				}

				public int getBatchSize() {
					return unMatchedList.size();
				}

			});
    }
	
	public int[] saveTradeDetails(List<Trade> tradeList) {

        return this.jdbcTemplate.batchUpdate(
			"insert into StockMaster.ST_TR_Trade (TR_SELLER,TR_BUYER,TR_STOCK,TR_PRICE,TR_TRADE_DATE) values(?,?,?,?,?)",
			new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, tradeList.get(i).getSeller());
					ps.setString(2, tradeList.get(i).getBuyer());
					ps.setString(3, tradeList.get(i).getStock());
					ps.setInt(4, (int) Math.round(tradeList.get(i).getPrice()));
					ps.setString(5, DateUtils.getStartDate());
				}

				public int getBatchSize() {
					return tradeList.size();
				}

			});
    }
}
