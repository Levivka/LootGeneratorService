package com.example.lootgenerator.Controllers;

import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jewelry/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping()
    public ResponseEntity<?> getAllPlaces() {
        return placeService.getPlaces();
    }

    @PostMapping()
    public ResponseEntity<?> createPlace(@RequestBody PlaceDto placeDto) {
        return placeService.addPlace(placeDto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updatePlace(@PathVariable String id, @RequestBody PlaceDto placeDto) {
        return placeService.updatePlace(id, placeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePlace(@PathVariable String id) {
        return placeService.deletePlace(id);
    }
}
