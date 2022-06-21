package com.db.assignment.Trade.Store.repository;

import com.db.assignment.Trade.Store.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface TradesRepository extends JpaRepository<Trades,String> {
    @Query(value = "UPDATE TRADES SET Expired='N' where Maturity_Date < startDate", nativeQuery = true)
    List<Trades> updateExpireDateFlag(Date startDate);
}
