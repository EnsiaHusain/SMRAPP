# SMRAPP

Here's the git hub link :- https://github.com/EnsiaHusain/SMRAPP

I have created a spring boot application which performs the following operations:-
1) Upload bulk data (csv file) - Created a REST API for uploading a csv file
2) Query data based on stock ticker(name),it returns a list of data  - Created a REST API
3) Added a new record - Created a REST API

I have used H2 Database which is an in memory database.
I have also created integration test cases at the controller layer.Dow Jones data file is under src/test/resources folder for testing.

REST API's :-

Upload Bulk Data :-
curl --location --request POST 'http://localhost:8080/stock/market/uploadBulkData' \--form 'file=@/Users/ensiahusain/Desktop/DowJonesData.csv'

View Stock Predictions :-
curl --location --request GET 'http://localhost:8080/stock/market/predictions?stockName=AXP'

Add new Record :-
curl --location --request POST 'http://localhost:8080/stock/market/addRecord' \--header 'Content-Type: application/json' \--data-raw '{ "quarter":1, "stock":"AXP", "open":"$43.30", "high":"$45.60" , "low":"$43.11" , "close":"$44.36" , "volume":45102042, "percentChangePrice":2.44804, "nextWeeksopen":"$44.20" , "nextWeeksClose":"$46.25" , "percentChangeNextWeeksPrice":4.63801, "daysToNextDividend":89, "percentReturnNextDividend":0.405771, "previousWeeksVolume":239655616, "date":"1/7/2011"
}'
