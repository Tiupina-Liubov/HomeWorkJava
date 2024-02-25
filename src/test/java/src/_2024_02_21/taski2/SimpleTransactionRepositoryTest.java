package src._2024_02_21.taski2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SimpleTransactionRepositoryTest {

    Transaction transaction = mock(Transaction.class);

    SimpleTransactionRepository transactionRepository = mock(SimpleTransactionRepository.class);

//    @Test
//    void processTransactionSuccess() {
//        double amount = 50.0d;
//
//        // Установка мок-поведения
//        when(transaction.isSuccess()).thenReturn(true);
//
//        // Вызов тестируемого метода
//        assertTrue(transactionRepository.processTransaction(amount));
//
//        // Проверка взаимодействия с моками
//        verify(transaction, times(1)).getAmount();
//        verify(transaction, times(1)).isSuccess();
//
//        // Проверка, что список транзакций увеличился на 1
//        assertEquals(1, transactionRepository.getTransactions().size());
//    }
}