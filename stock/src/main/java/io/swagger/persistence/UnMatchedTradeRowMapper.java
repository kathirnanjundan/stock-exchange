package io.swagger.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.IParty;
import io.swagger.model.Party;

public class UnMatchedTradeRowMapper implements RowMapper<IParty>{

	@Override
    public IParty mapRow(ResultSet rs, int rowNum) throws SQLException {
		IParty trade = new Party();
		trade.setParty(rs.getString("PR_PARTY"));
		trade.setSymbol(rs.getString("PR_SYMBOL"));
		trade.setStock(rs.getString("PR_STOCK"));
		trade.setPrice(rs.getInt("PR_PRICE"));
		return trade;
	}

}
