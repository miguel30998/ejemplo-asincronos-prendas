package com.hiberus.clothingAsync.domain.ports.in;

import com.hiberus.clothingAsync.domain.model.Garment;

public interface CreateGarmentUseCase {

    boolean createGarment(Garment garment);

}
