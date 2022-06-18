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
        Date dateBefore = new Date(new Date().getTime() - 1 * 24 * 3600 * 1000 );
        if(trade.getMaturityDate().before(dateBefore)){
            /**
             * Store should not allow the trade which has less maturity date then today date.
             */
            throw new MaturityDateException("Maturity Date  << "+trade.getMaturityDate()+  " >> Must Be Equal Or Greater Than Today Date");
        }
        /**
         * Store should automatically update the expire flag if in a store the trade crosses the maturity date.
         */
        if(trade.getMaturityDate().after(dateBefore)){
            trade.setExpired('Y');
        }
       Optional<Trades> existingTradeOptional= tradesRepository.findById(trade.getId());
       if(existingTradeOptional.isPresent()){
           Trades existingTrade  =existingTradeOptional.get();
           if(existingTrade.getVersion() > trade.getVersion()){
               /**
                * During transmission if the lower version is being received by the store it will reject the trade and throw an exception.
                * If the version is same it will override the existing record.
                */
                throw new MinorVersionException("Trade Version : << "+trade.getVersion()+ " >> Less Then The Existing Trade Version :"+existingTrade.getVersion());
           }else {
               return tradesRepository.saveAndFlush(trade);
           }
       }else{
           return tradesRepository.save(trade);
       }
    }

    @Override
    public Optional<Trades> findById(String tradeId) {
        return tradesRepository.findById(tradeId);
    }
}
