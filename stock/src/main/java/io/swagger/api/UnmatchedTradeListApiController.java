package io.swagger.api;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.mapper.StockMapper;
import io.swagger.model.IParty;
import io.swagger.model.ITrade;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-11T16:56:57.149Z")

@Controller
public class UnmatchedTradeListApiController implements UnmatchedTradeListApi {

    private static final Logger log = LoggerFactory.getLogger(UnmatchedTradeListApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UnmatchedTradeListApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<IParty>> getUnmatchedStocks(@ApiParam(value = "") @Valid @RequestParam(value = "symbol", required = false) String symbol,@ApiParam(value = "") @Valid @RequestParam(value = "price", required = false) BigDecimal price) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<IParty>>(StockMapper.filterUnMatchedTradeList(symbol, String.valueOf(price)), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<IParty>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<IParty>>(HttpStatus.OK);
    }

}
