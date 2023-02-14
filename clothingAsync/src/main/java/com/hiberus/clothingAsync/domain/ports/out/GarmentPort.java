package com.hiberus.clothingAsync.domain.ports.out;

import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.model.Size;

import java.util.List;

public interface GarmentPort {



    boolean createGarment(Garment garment);

    boolean deleteGarment(String name, Size size);

    List<Garment> getListGarment();

    Garment getGarment(String id);
}
