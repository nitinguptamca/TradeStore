##Need to build project java version 11----
##If you don't have java 11 version then I will share docker Image for that
prerequisites
```
Install mysql server
create schema tradeStore
create table trades

create TABLE IF NOT EXISTS trades (
  Trade_Id Varchar(4) UNSIGNED  PRIMARY KEY,
  counter_Party_Id VARCHAR(30),
  book_id VARCHAR(30),
  maturity_Date DATE,
  version INT,
  created_Date DATE,
  expired CHAR
) engine=InnoDB;

```
Step 1.
```
mvn clean install
```

Step 2.
```
mvn spring-boot:run
```
step 3.  post request
url is
http://localhost:7777/tradeStore/trade
```

{
	"id" : "T1",
	"version" : 11,
	"counterPartyId" : "CP-1",
	"bookId" : "B1",
	"maturityDate" :"18/06/2022",
	"createdDate" : "18/06/2022",
	"expired" : "N"
}
```
##check report status /target/site/jacoco
##open other endpoint which apache camel with activemq 
### start activemq server create queue "trade" create trade feed for that save as above.
Step 1
```
push message to queue.
```
