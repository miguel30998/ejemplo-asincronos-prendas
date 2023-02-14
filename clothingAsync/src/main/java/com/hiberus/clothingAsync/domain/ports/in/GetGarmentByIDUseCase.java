package com.hiberus.clothingAsync.domain.ports.in;

import com.hiberus.clothingAsync.domain.model.Garment;

public interface GetGarmentByIDUseCase {
    Garment getGarment(String id);
}
