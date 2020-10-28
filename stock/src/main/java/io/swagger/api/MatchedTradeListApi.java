/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.ITrade;
import io.swagger.model.Trade;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-11T16:56:57.149Z")

@Api(value = "matched-trade-list", description = "the matched-trade-list API")
@RequestMapping(value = "/api/v1")
public interface MatchedTradeListApi {

    @ApiOperation(value = "Retrieves the list of stocks", nickname = "getStocks", notes = "", response = Trade.class, responseContainer = "List", tags={ "stocks", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Trade.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request") })
    @RequestMapping(value = "/matched-trade-list",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<ITrade>> getStocks(@ApiParam(value = "") @Valid @RequestParam(value = "party", required = false) String party,@ApiParam(value = "") @Valid @RequestParam(value = "symbol", required = false) String symbol,@ApiParam(value = "") @Valid @RequestParam(value = "date", required = false) String date);

}
