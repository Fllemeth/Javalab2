package com.project.bohomolov.domain.chair;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Chair extends Stool {
    private ChairBack chairBack;

    public Chair(Long id, int height, Style style, com.project.bohomolov.domain.chair.ChairSeat ChairSeat, double price, ChairBack chairBack) {
        super(id, height, style, ChairSeat, price);
        this.chairBack = chairBack;
    }

    public Chair(int height, Style style, com.project.bohomolov.domain.chair.ChairSeat chairSeat, double price, ChairBack chairBack) {
        super(height, style, chairSeat, price);
        this.chairBack = chairBack;
    }
}
