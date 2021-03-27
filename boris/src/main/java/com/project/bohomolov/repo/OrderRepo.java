package com.project.bohomolov.repo;

import com.project.bohomolov.domain.order.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> findAllOrder();
    void saveOrder(Order order);
}
