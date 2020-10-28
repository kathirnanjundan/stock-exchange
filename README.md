Implement a high frequency Exchange that receives both BUY orders & SELL orders

This assesment is all about Implement a high frequency Exchange that receives both BUY orders & SELL orders and matches them based on the Symbol, Price and the sequence in which they were received These are the inputs formats which i used Given an orders feed with the following rows: Party A, SELL, IBM, 110 Party A, SELL, INFY, 600 Party A, SELL, GOOG, 500 Party B, BUY, IBM, 110 Party C, BUY, IBM, 110 Party C, BUY, INFY, 600

to launch the application Please run Swagger2SpringBoot class.

2 Apis exposed using swagger. Expose two REST end-points for the end-users to query:

List of trades with the ability to filter based on Parties, SYMBOL or Date List of orders that are not yet matched, with the ability to filter based on SYMBOL, Price to test the api Please find the below URL.

1.http://localhost:8080/api/v1/matched-trade-list Input params are:party,symbol and date

2.http://localhost:8080/api/v1/unmatched-trade-list Input params are symbol and price.

Test case attached Please check StockMapperTest(io.swagger.mapper under src/test/java)

