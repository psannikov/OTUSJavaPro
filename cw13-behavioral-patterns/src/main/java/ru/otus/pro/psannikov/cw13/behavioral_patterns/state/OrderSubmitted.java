package ru.otus.pro.psannikov.cw13.behavioral_patterns.state;


import ru.otus.pro.psannikov.cw13.behavioral_patterns.state.data.OrderItem;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.state.data.OrderStateEnum;

import java.math.BigDecimal;
import java.util.List;

public class OrderSubmitted extends OrderState {

    public OrderSubmitted(final List<OrderItem> itemList) {
        super(OrderStateEnum.SUBMITTED, itemList);
        sum = itemList.stream()
                .map(OrderItem::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new OrderPaid(getItems()));
    }

    @Override
    public void addItem(OrderItem item) {
        throw new IllegalStateException("can't add items in submitted state");
    }

    @Override
    public BigDecimal removeItems() {
        getItems().clear();
        return sum.multiply(new BigDecimal("0.1"));
    }


}
