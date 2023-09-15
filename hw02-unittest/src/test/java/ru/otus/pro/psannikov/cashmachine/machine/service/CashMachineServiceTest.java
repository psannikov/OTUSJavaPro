package ru.otus.pro.psannikov.cashmachine.machine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.pro.psannikov.cashmachine.TestUtil;
import ru.otus.pro.psannikov.cashmachine.bank.dao.AccountDao;
import ru.otus.pro.psannikov.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.cashmachine.bank.data.Card;
import ru.otus.pro.psannikov.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.cashmachine.bank.service.CardService;
import ru.otus.pro.psannikov.cashmachine.bank.service.impl.AccountServiceImpl;
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
    String cardNumForError = "0123456789";
    String pin = "1234";
    String newPin = "4321";
    BigDecimal amount = new BigDecimal(1000);
    BigDecimal addMoney = new BigDecimal(100+500+1000+5000);
    BigDecimal subMoney = new BigDecimal(1100);
    Card card;
    Card cardForError;


    @BeforeEach
    void init() {
        card = new Card(1L, cardNum, 1L, TestUtil.getHash(pin));
        cardForError = new Card(2L, cardNum, 2L, TestUtil.getHash(newPin));
        cashMachineService = spy(new CashMachineServiceImpl(cardService, accountService, moneyBoxService));
    }


    @Test
    void getMoney() {
        when(cardsDao.getCardByNumber(cardNum)).thenReturn(card);
        List<Integer> listOfNotesAfterGetMoney = List.of(0,1,0,1);
        CashMachine cashMachineSpy = spy(cashMachine);
        List<Integer> result = cashMachineService.getMoney(cashMachineSpy,cardNum,pin,subMoney);
        assertEquals(listOfNotesAfterGetMoney,result);
    }

    @Test
    void putMoney() {
        when(cardsDao.getCardByNumber(cardNum)).thenReturn(card);
        List<Integer> notes = List.of(1, 1, 1, 1);
        when(cardService.putMoney(cardNum, pin, addMoney)).thenReturn(amount.add(addMoney));
        BigDecimal result = cashMachineService.putMoney(cashMachine, cardNum, pin, notes);
        assertEquals(amount.add(addMoney), result);
    }

    @Test
    void checkBalance() {
        when(cardsDao.getCardByNumber(cardNum)).thenReturn(card);
        when(cardService.getBalance(cardNum, pin)).thenReturn(amount);
        BigDecimal result = cashMachineService.checkBalance(cashMachine, cardNum, pin);
        assertEquals(amount, result);
    }

    @Test
    void changePin() {
        when(cardsDao.getCardByNumber(cardNum)).thenReturn(card);
        boolean result = cashMachineService.changePin(cardNum,pin,newPin);
        verify(cashMachineService).changePin(cardNum,pin,newPin);
        assertEquals(true, result);

    }

    @Test
    void changePinWithAnswer() {
        when(cardsDao.getCardByNumber(cardNumForError)).thenReturn(cardForError);
        boolean result = cashMachineService.changePin(cardNumForError,pin,newPin);
        verify(cashMachineService).changePin(cardNumForError,pin,newPin);
        assertEquals(false, result);
    }
}