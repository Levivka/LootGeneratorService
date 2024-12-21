package com.example.lootgenerator.Controllers;

import com.example.lootgenerator.Models.Dto.JewelryPlaceDto;
import com.example.lootgenerator.Models.Dto.JewerlyDto;
import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Services.JewelryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/jewelry")
@RequiredArgsConstructor
public class JewelryController {
    private final JewelryService jewelryService;

    @GetMapping()
    public ResponseEntity<?> getJewelry(){
        return jewelryService.getJewelry();
    }

    @PostMapping()
    public ResponseEntity<?> addJewelry(@RequestBody JewerlyDto jewerlyDto) {
        return jewelryService.addJewelry(jewerlyDto);
    }

    @GetMapping("/random")
    public ResponseEntity<?> generateJewelry(){
        return jewelryService.generateJewelry();
    }

    @PostMapping("/random/by-type")
    public ResponseEntity<?> generateJewelryByType(@RequestBody TypeDto typeDto) {
        return jewelryService.generateJewelry(typeDto);
    }

    @PostMapping("/random/by-place")
    public ResponseEntity<?> generateJewelryByType(@RequestBody JewelryPlaceDto placeDto) {
        return jewelryService.generateJewelry(placeDto);
    }

}
