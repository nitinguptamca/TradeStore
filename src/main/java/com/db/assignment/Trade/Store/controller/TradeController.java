package com.db.assignment.Trade.Store.controller;

import com.db.assignment.Trade.Store.model.*;
import com.db.assignment.Trade.Store.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;


@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
@Slf4j
public class TradeController {
    @Autowired
    private TradeService tradeService;

  @RequestMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_XML_VALUE,
          method = RequestMethod.POST
  )
    public ResponseEntity<Trades> getOwnersList(@Valid @RequestBody Trades trade) {
        log.info("Request body ::",trade);
       Trades trade1 =tradeService.save(trade);
       return new ResponseEntity<Trades>(trade1, HttpStatus.CREATED);
    }

}
