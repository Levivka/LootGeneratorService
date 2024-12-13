package com.example.lootgenerator.Services;

import com.example.lootgenerator.Models.Dto.TrinketDto;
import org.springframework.http.ResponseEntity;

public interface TrinketsService {
    ResponseEntity<?> generateTrinketsByCost(int cost);
    ResponseEntity<?> getAllTrinkets();
    ResponseEntity<?> addTrinket(TrinketDto trinketDto);
}
