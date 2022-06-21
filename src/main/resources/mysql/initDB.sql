create  DATABASE IF NOT EXISTS tradeStore;

alter database tradeStore
  default  CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

grant all privileges on tradeStore.* TO root@localhost IDENTIFIED BY 'root';

USE tradeStore;

create TABLE IF NOT EXISTS trades (
  Trade_Id Varchar(4) UNSIGNED  PRIMARY KEY,
  counter_Party_Id VARCHAR(30),
  book_id VARCHAR(30),
  maturity_Date DATE,
  version INT,
  created_Date DATE,
  expired CHAR
) engine=InnoDB;
