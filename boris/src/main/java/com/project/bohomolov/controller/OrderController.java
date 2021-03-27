package com.project.bohomolov.controller;

import com.project.bohomolov.domain.order.Order;
import com.project.bohomolov.exception.UserAlreadyExistsException;
import com.project.bohomolov.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> OrderList() {
        return orderService.findAllOrder();
    }

    @PostMapping
    public List<Order> save(@RequestBody Order order) throws UserAlreadyExistsException {
        if(orderService.findAllOrder().contains(order)) {
            throw new UserAlreadyExistsException();
        }
        else {
            orderService.save(order);
            return orderService.findAllOrder();
        }
    }
}
