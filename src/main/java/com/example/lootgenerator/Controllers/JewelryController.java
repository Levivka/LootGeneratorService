package com.example.lootgenerator.Controllers;

import com.example.lootgenerator.Models.Dto.JewerlyDto;
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

    @GetMapping("/gen")
    public ResponseEntity<?> generateJewelry(){
        return jewelryService.generateJewelry();
    }

}
