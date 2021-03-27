package com.project.bohomolov.domain.order;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.domain.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private User user;
    private List<Chair> chairList;

    public Order(User user, List<Chair> chairList) {
        this.user = user;
        this.chairList = chairList;
    }
}
