package com.db.assignment.Trade.Store.service;

import com.db.assignment.Trade.Store.Exception.*;
import com.db.assignment.Trade.Store.model.*;
import com.db.assignment.Trade.Store.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class TradesServiceImpl implements TradeService{
    @Autowired
    private TradesRepository tradesRepository;

    @Override
    public Trades save(Trades trade) {
       Optional<Trades> existingTrade= tradesRepository.findById(trade.getId());
       if(existingTrade.isPresent()){
           Trades currentTrade  =existingTrade.get();
           if(currentTrade.getVersion() > trade.getVersion()){
                throw new MinorVersionException("Trade Version less then Current Trade Version");
           }
           return currentTrade;
       }else{
           return tradesRepository.save(trade);
       }
    }

    @Override
    public Optional<Trades> findById(String tradeId) {
        return tradesRepository.findById(tradeId);
    }
}
