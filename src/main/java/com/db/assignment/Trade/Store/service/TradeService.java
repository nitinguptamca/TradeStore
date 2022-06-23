package com.db.assignment.Trade.Store.service;

import com.db.assignment.Trade.Store.model.*;

import java.util.*;

public interface TradeService {
    public Trades save(Trades trade);
   public  void autometicExpire();
}
