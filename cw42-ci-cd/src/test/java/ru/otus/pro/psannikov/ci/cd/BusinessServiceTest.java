package ru.otus.pro.psannikov.ci.cd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.pro.psannikov.ci.cd.service.BusinessService;

public class BusinessServiceTest {

    @Test
    public void testAdd() {
        BusinessService service = new BusinessService();
        service.add(1L);
        Assertions.assertEquals(1, service.list().size());
    }

    @Test
    public void testRemove() {
        BusinessService service = new BusinessService();
        service.add(1L);
        Assertions.assertEquals(1, service.list().size());
        service.remove(1L);
        Assertions.assertEquals(0, service.list().size());
    }
}
