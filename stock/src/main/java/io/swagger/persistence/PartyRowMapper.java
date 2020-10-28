package io.swagger.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.IParty;
import io.swagger.model.Party;

public class PartyRowMapper implements RowMapper<IParty> {

    @Override
    public IParty mapRow(ResultSet rs, int rowNum) throws SQLException {
    	IParty party = new Party();
    	party.setParty(rs.getString("PR_PARTY"));
    	party.setStock(rs.getString("PR_STOCK"));
    	party.setSymbol(rs.getString("PR_SYMBOL"));
    	party.setPrice(rs.getInt("PR_PRICE"));
        return party;
    }
}
