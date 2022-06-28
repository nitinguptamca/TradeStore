package com.db.assignment.Trade.Store.repository;

import com.db.assignment.Trade.Store.model.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.time.*;
import java.util.*;

@Repository
@Profile("spring-data-jpa")
public interface TradesRepository extends JpaRepository<Trades,String> {

    @Modifying
    @Transactional
    @Query("update Trades u set u.expired = 'Y' where u.maturityDate < :date")
    void deactivateUsersNotLoggedInSince(@Param("date") Date date);


    Optional<Trades> findByTradeId(String tradeId);
}
