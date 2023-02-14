package com.hiberus.clothingAsync.infrastructure.DTO;

import com.hiberus.clothingAsync.domain.model.Size;
import lombok.Getter;

@Getter
public class GarmentIdentifierDTO {
    private String name;
    private Size size;
}
