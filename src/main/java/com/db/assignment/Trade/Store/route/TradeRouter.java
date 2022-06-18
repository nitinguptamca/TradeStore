package com.db.assignment.Trade.Store.route;

import com.db.assignment.Trade.Store.model.*;
import com.db.assignment.Trade.Store.service.*;
import org.apache.camel.*;
import org.apache.camel.builder.*;
import org.springframework.beans.factory.annotation.*;

public class TradeRouter extends RouteBuilder {
    @Autowired
    private TradeService tradeService;

    @Override
    public void configure() throws Exception {
        from("activemq:trade")
                .log("${body}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Trades trades = exchange.getIn().getBody(Trades.class);
                        tradeService.save(trades);
                    }
                }).end();
    }
}
