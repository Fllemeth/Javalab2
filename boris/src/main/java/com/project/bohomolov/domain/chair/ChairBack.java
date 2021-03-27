package com.project.bohomolov.domain.chair;

import lombok.Data;

@Data
public class ChairBack {

    private int id;
    private final Material material;
    private Color color;

    public ChairBack(Material material, Color color) {
        this.material = material;
        this.color = color;
    }

}
