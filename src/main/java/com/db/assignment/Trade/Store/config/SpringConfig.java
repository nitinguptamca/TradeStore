package com.db.assignment.Trade.Store.config;

import com.db.assignment.Trade.Store.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;

@Configuration
@Slf4j
public class SpringConfig {
    /**
     *Store should automatically update the expire
     * flag if in a store the trade crosses the maturity date.
     */

    @Autowired
    private TradeService tradeService;

  ///  @Scheduled(cron = "*/1 * * * * *")
    public void tradeExpire() {
        tradeService.autometicExpire();
    }
}
