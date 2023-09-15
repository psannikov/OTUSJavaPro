package ru.otus.pro.psannikov.cashmachine.machine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.pro.psannikov.cashmachine.TestUtil;
import ru.otus.pro.psannikov.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.cashmachine.bank.data.Card;
import ru.otus.pro.psannikov.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.cashmachine.bank.service.CardService;
import ru.otus.pro.psannikov.cashmachine.bank.service.impl.CardServiceImpl;
import ru.otus.pro.psannikov.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.cashmachine.machine.data.MoneyBox;
import ru.otus.pro.psannikov.cashmachine.machine.service.impl.CashMachineServiceImpl;
import ru.otus.pro.psannikov.cashmachine.machine.service.impl.MoneyBoxServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CashMachineServiceTest {

    @Spy
    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardsDao cardsDao;

    @Mock
    private AccountService accountService;

    MoneyBoxService moneyBoxService = spy(new MoneyBoxServiceImpl());

    private CashMachineServiceImpl cashMachineService;
    MoneyBox moneyBox = spy(new MoneyBox(1,1,1,1));

    private CashMachine cashMachine = new CashMachine(moneyBox);
    String cardNum = "1234567890";
    String pin = "1234";
    String newPin = "4321";
    BigDecimal amount = new BigDecimal(1000);
    BigDecimal addMoney = new BigDecimal(100+500+1000+5000);
    BigDecimal subMoney = new BigDecimal(1100);


    @BeforeEach
    void init() {
        Card card = new Card(1L, cardNum, 1L, TestUtil.getHash(pin));
        when(cardsDao.getCardByNumber(anyString())).thenReturn(card);
//        when(cardService.getBalance(cardNum, pin)).thenReturn(amount);
//        when(cardService.getMoney(cardNum, pin,amount)).thenReturn(amount);
        cashMachineService = new CashMachineServiceImpl(cardService, accountService, moneyBoxService);
    }


    @Test
    void getMoney() {
        List<Integer> listOfNotesAfterGetMoney = List.of(0,1,0,1);
        CashMachine cashMachineSpy = spy(cashMachine);
        List<Integer> result = cashMachineService.getMoney(cashMachineSpy,cardNum,pin,subMoney);
        assertEquals(listOfNotesAfterGetMoney,result);
    }

    @Test
    void putMoney() {
        List<Integer> notes = List.of(1, 1, 1, 1);
        when(cardService.putMoney(cardNum, pin, addMoney)).thenReturn(amount.add(addMoney));
        BigDecimal result = cashMachineService.putMoney(cashMachine, cardNum, pin, notes);
        assertEquals(amount.add(addMoney), result);
    }

    @Test
    void checkBalance() {
        when(cardService.getBalance(cardNum, pin)).thenReturn(amount);
        BigDecimal result = cashMachineService.checkBalance(cashMachine, cardNum, pin);
        assertEquals(amount, result);
    }

    @Test
    void changePin() {
        boolean result = cashMachineService.changePin(cardNum, pin, newPin);
        assertTrue(result);
    }

    @Test
    void changePinWithAnswer() {
//        CardServiceImpl cardServiceSpy = spy(cardService);
//        when(cardServiceSpy.cnangePin(
//                ArgumentMatchers.anyString(),
//                ArgumentMatchers.anyString(),
//                ArgumentMatchers.anyString()))
//                .thenAnswer(invocation -> {
//                    String providedCardNum = invocation.getArgument(0);
//                    String providedOldPin = invocation.getArgument(1);
//                    String providedNewPin = invocation.getArgument(2);
//                    if (providedCardNum.equals(cardNum) && providedOldPin.equals(pin)) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                });
        boolean result = cashMachineService.changePin(cardNum, pin, newPin);
        assertTrue(result);
// @TODO create change pin test using spy as implementation and mock an thenAnswer
    }
}