package io.swagger.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.ITrade;
import io.swagger.model.Trade;

public class MatchedTradeRowMapper implements RowMapper<ITrade>{

	@Override
    public ITrade mapRow(ResultSet rs, int rowNum) throws SQLException {
		ITrade trade = new Trade();
		trade.setBuyer(rs.getString("TR_BUYER"));
		trade.setSeller(rs.getString("TR_SELLER"));
		trade.setPrice(rs.getDouble("TR_PRICE"));
		trade.setStock(rs.getString("TR_STOCK"));
		trade.setDate(rs.getString("TR_TRADE_DATE"));
		trade.setStatus("Matched");
		return trade;
	}
}
