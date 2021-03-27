package com.project.bohomolov.service;

import com.project.bohomolov.domain.order.Order;
import com.project.bohomolov.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepo orderRepo;

    public void save(Order order) {
        orderRepo.saveOrder(order);
    }

    public List<Order> findAllOrder() {
        return orderRepo.findAllOrder();
    }
}
