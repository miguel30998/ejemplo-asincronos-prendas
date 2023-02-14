package com.hiberus.clothingAsync.domain.ports.in;

import com.hiberus.clothingAsync.domain.model.Garment;

public interface BuyUseCase {

    void buy(Garment garment, String userID);
}
