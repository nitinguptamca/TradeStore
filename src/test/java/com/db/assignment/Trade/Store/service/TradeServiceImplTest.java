package com.db.assignment.Trade.Store.service;

import com.db.assignment.Trade.Store.Exception.*;
import com.db.assignment.Trade.Store.model.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("mysql, spring-data-jpa")
public class TradeServiceImplTest {
    Trades t1;
    Trades validTrade;

    @Before
    public void setUp() {
        t1 = new Trades("T5", 1,
                "CP-1", "B1",
                new Date("20/05/2020"), new Date("16/06/2022"), 'N');
        validTrade = new Trades("T5", 5,
                "CP-1", "B1",
                new Date("20/05/2023"), new Date("16/06/2020"), 'Y');
    }

    @Autowired
    private TradeService tradeService;

    @Test
    public void test_valid_trade_record() {
        Trades trades = tradeService.save(validTrade);
        Assert.assertTrue("B1".equals(trades.getBookId()));
        Assert.assertEquals(trades.getVersion(), 5);
        Assert.assertTrue("CP-1".equalsIgnoreCase(trades.getCounterPartyId()));
        Assert.assertTrue("T5".equalsIgnoreCase(trades.getId()));
        Assert.assertEquals(trades.getExpired(), 'Y');
    }

    @Test
    public void test_valid_trade_record_Override_Records() {
        validTrade.setExpired('N');
        Trades trades = tradeService.save(validTrade);
        Assert.assertTrue("B1".equals(trades.getBookId()));
        Assert.assertEquals(trades.getVersion(), 5);
        Assert.assertTrue("CP-1".equalsIgnoreCase(trades.getCounterPartyId()));
        Assert.assertTrue("T5".equalsIgnoreCase(trades.getId()));
        Assert.assertEquals(trades.getExpired(), 'Y');
    }

    @Test(expected = MaturityDateException.class)
    public void test_valid_trade_record_MaturityDateException() {
        validTrade.setExpired('N');
        Date dateBefore = new Date(new Date().getTime() - 300 * 24 * 3600 * 1000 );
        validTrade.setMaturityDate(dateBefore);
        Trades trades = tradeService.save(validTrade);
    }

    @Test(expected = MinorVersionException.class)
    public void test_valid_trade_record_MinorVersionException() {
        validTrade.setExpired('N');
        validTrade.setVersion(2);
        Trades trades = tradeService.save(validTrade);
    }


}
