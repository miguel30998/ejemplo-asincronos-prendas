package com.hiberus.clothingAsync.infrastructure.adapter.in.web.controller;

import com.google.gson.Gson;
import com.hiberus.clothingAsync.domain.model.Garment;
import com.hiberus.clothingAsync.domain.model.Size;
import com.hiberus.clothingAsync.domain.ports.in.*;
import com.hiberus.clothingAsync.infrastructure.DTO.BuyerDTO;
import com.hiberus.clothingAsync.infrastructure.DTO.GarmentDTO;
import com.hiberus.clothingAsync.infrastructure.DTO.GarmentIdentifierDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClothingControllerImpl implements ClothingController {

    public static final String Not_Found = "Not_Found";

    public static final String Not_Enough = "Not_Enough";
    private final CreateGarmentUseCase createGarmentUseCase;
    private final DeleteGarmentUseCase deleteGarmentUseCase;
    private final GetGarmentsUseCase getGarmentsUseCase;
    private final GetGarmentByIDUseCase getGarmentByIDUseCase;

    private final DowngradeQuantityUseCase downgradeQuantityUseCase;

    private final UpgradeQuantityUseCase upgradeQuantityUseCase;

    private final BuyUseCase buyUseCase;
    private Gson gson = new Gson();

    private final static Logger logger = LoggerFactory.getLogger(ClothingControllerImpl.class);
    @Override
    public ResponseEntity<String> createGarment(GarmentDTO garmentDTO){
        Garment garment;
        try {
            garment = new Garment(garmentDTO.getName(),garmentDTO.getQuantity(),garmentDTO.getSize());
            if(getGarmentByIDUseCase.getGarment(garmentDTO.getName()+garmentDTO.getSize()) != null){
                return new ResponseEntity<>(gson.toJson("Already exists"), HttpStatus.NOT_FOUND);
            }
            createGarmentUseCase.createGarment(garment);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteGarment(GarmentIdentifierDTO garmentDTO){
        try {
            Garment garment = getGarmentByIDUseCase.getGarment(garmentDTO.getName()+garmentDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson(Not_Found), HttpStatus.NOT_FOUND);
            }
            deleteGarmentUseCase.deleteGarment(garmentDTO.getName(),garmentDTO.getSize());
            logger.info("The user with id "+garment.getId()+" has been deleted");
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson("Deleted "+garmentDTO.getName()+" Size: "+garmentDTO.getSize()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClothing() {
        List<Garment> list;
        try {
            list = getGarmentsUseCase.getGarments();
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson(list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClothing(String garmentId) {
        Garment garment;
        try {
            garment = getGarmentByIDUseCase.getGarment(garmentId);
            if(garment == null){
                return new ResponseEntity<>(gson.toJson(Not_Found), HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> upgradeQuantity(GarmentIdentifierDTO garmentIdentifierDTO) {
        Garment garment;
        boolean successful;
        try {
            garment = getGarmentByIDUseCase.getGarment(garmentIdentifierDTO.getName()+garmentIdentifierDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson(Not_Found), HttpStatus.NOT_FOUND);
            }
            successful = upgradeQuantityUseCase.upgrade(garment);
            if(!successful){
                return new ResponseEntity<>(gson.toJson("Error upgrading"), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> downgradeQuantity(GarmentIdentifierDTO garmentIdentifierDTO) {
        Garment garment;
        boolean successful;
        try {
            garment = getGarmentByIDUseCase.getGarment(garmentIdentifierDTO.getName()+garmentIdentifierDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson(Not_Found), HttpStatus.NOT_FOUND);
            }
            if(garment.getQuantity() == 0){
                return new ResponseEntity<>(gson.toJson(Not_Enough), HttpStatus.BAD_REQUEST);
            }
            successful = downgradeQuantityUseCase.downgrade(garment);
            if(!successful){
                return new ResponseEntity<>(gson.toJson("Error upgrading"), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> buy(BuyerDTO buyerDTO) {
        Garment garment;
        try {
            garment = getGarmentByIDUseCase.getGarment(buyerDTO.getGarmentID());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson(Not_Found), HttpStatus.NOT_FOUND);
            }
            if(garment.getQuantity() == 0){
                return new ResponseEntity<>(gson.toJson(Not_Enough), HttpStatus.BAD_REQUEST);
            }
            buyUseCase.buy(garment, buyerDTO.getUserID());
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }
}
