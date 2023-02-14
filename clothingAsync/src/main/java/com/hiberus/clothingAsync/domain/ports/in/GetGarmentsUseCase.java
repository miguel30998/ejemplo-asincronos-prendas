package com.hiberus.clothingAsync.domain.ports.in;

import com.hiberus.clothingAsync.domain.model.Garment;

import java.util.List;

public interface GetGarmentsUseCase {
    List<Garment> getGarments();
}
