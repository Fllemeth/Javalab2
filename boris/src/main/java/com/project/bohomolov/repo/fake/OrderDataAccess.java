package com.project.bohomolov.repo.fake;

import com.project.bohomolov.domain.order.Order;
import com.project.bohomolov.repo.OrderRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FakeOrder")
public class OrderDataAccess implements OrderRepo {

    Long counter = 1L;
    private final List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAllOrder() {
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        order.setId(counter++);
        orders.add(order);
    }
}
