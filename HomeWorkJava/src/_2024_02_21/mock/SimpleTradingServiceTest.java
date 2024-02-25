package src._2024_02_21.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleTradingServiceTest {

    @Mock
    Trade trade;

    @Mock
    TradeRepository tradeRepository;

    @Mock
    AuditService auditService;

    @Test
    void createTradeTest() {
        Mockito.when(tradeRepository.createTrade(trade)).thenReturn(Mockito.anyLong());

        TradingService service = new SimpleTradingService(tradeRepository, auditService);
        service.createTrade(trade);

        Mockito.verify(auditService).logNewTrade(trade);
    }
}