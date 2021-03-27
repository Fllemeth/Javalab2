package com.project.bohomolov.domain.chair;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stool {

    private Long id;
    private int height;
    private Style style;
    private ChairSeat ChairSeat;
    private double price;

    public Stool(int height, Style style, ChairSeat chairSeat, double price) {
        this.height = height;
        this.style = style;
        ChairSeat = chairSeat;
        this.price = price;
    }
}
