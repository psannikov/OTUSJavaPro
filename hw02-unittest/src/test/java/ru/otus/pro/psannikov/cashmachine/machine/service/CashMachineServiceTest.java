package ru.otus.pro.psannikov.cashmachine.machine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.pro.psannikov.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.cashmachine.bank.service.impl.CardServiceImpl;
import ru.otus.pro.psannikov.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.cashmachine.machine.data.MoneyBox;
import ru.otus.pro.psannikov.cashmachine.machine.service.impl.CashMachineServiceImpl;

@ExtendWith(MockitoExtension.class)
class CashMachineServiceTest {

    @Spy
    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardsDao cardsDao;

    @Mock
    private AccountService accountService;

    @Mock
    private MoneyBoxService moneyBoxService;

    private CashMachineServiceImpl cashMachineService;

    private CashMachine cashMachine = new CashMachine(new MoneyBox());

    @BeforeEach
    void init() {
        cashMachineService = new CashMachineServiceImpl(cardService, accountService, moneyBoxService);
    }


    @Test
    void getMoney() {
// @TODO create get money test using spy as mock
    }

    @Test
    void putMoney() {
    }

    @Test
    void checkBalance() {

    }

    @Test
    void changePin() {
// @TODO create change pin test using spy as implementation and ArgumentCaptor and thenReturn
    }

    @Test
    void changePinWithAnswer() {
// @TODO create change pin test using spy as implementation and mock an thenAnswer
    }
}