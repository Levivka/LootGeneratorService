package com.example.lootgenerator.Controllers;

import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Services.PlaceService;
import com.example.lootgenerator.Services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jewelry/types")
public class TypeController {
    private final TypeService typeService;

    @GetMapping()
    public ResponseEntity<?> getAllTypes() {
        return typeService.getTypes();
    }

    @PostMapping()
    public ResponseEntity<?> createType(@RequestBody TypeDto typeDto) {
        return typeService.addType(typeDto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateType(@PathVariable String id, @RequestBody TypeDto typeDto) {
        return typeService.updateType(id, typeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteType(@PathVariable String id) {
        return typeService.deleteType(id);
    }
}
