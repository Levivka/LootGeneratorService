package com.example.lootgenerator.Services;

import com.example.lootgenerator.Models.Dto.JewerlyDto;
import com.example.lootgenerator.Models.Jewelry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JewelryService {
    ResponseEntity<?> getJewelry();
    ResponseEntity<?> addJewelry(JewerlyDto jewerlyDto);
    ResponseEntity<?> generateJewelry();
}
