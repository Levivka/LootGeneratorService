package com.example.lootgenerator.Controllers;

import com.example.lootgenerator.Models.Dto.TrinketDto;
import com.example.lootgenerator.Services.TrinketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trinkets")
public class TrinketController {
    private final TrinketsService trinketsService;

    @GetMapping("/{cost}")
    public ResponseEntity<?> generateTrinketByCost(@PathVariable int cost) {
        return trinketsService.generateTrinketsByCost(cost);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTrinkets() {
        return trinketsService.getAllTrinkets();
    }

    @PostMapping()
    public ResponseEntity<?> addTrinket(@RequestBody TrinketDto trinketDto) {
        return trinketsService.addTrinket(trinketDto);
    }
}
