package com.hiberus.clothingAsync.domain.ports.in;

import com.hiberus.clothingAsync.domain.model.Size;

public interface DeleteGarmentUseCase {

    boolean deleteGarment(String name, Size size);
}
