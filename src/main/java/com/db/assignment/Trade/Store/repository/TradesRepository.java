package com.db.assignment.Trade.Store.repository;

import com.db.assignment.Trade.Store.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TradesRepository extends JpaRepository<Trades,String> {
}
