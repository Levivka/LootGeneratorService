package com.example.lootgenerator.Services;

import com.example.lootgenerator.Models.Dto.JewelryPlaceDto;
import com.example.lootgenerator.Models.Dto.JewerlyDto;
import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Models.Jewelry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JewelryService {
    ResponseEntity<?> getJewelry();
    ResponseEntity<?> addJewelry(JewerlyDto jewerlyDto);
    ResponseEntity<?> generateJewelry();
    ResponseEntity<?> generateJewelry(TypeDto typeDto);
    ResponseEntity<?> generateJewelry(JewelryPlaceDto placeDto);
}
