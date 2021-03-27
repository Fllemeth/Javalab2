package com.project.bohomolov.domain.chair;

import lombok.Data;

@Data
public class ChairSeat {

    private int id;
    private final Material material;
    private Color color;

    public ChairSeat(Material material, Color color) {
        this.material = material;
        this.color = color;
    }
}
