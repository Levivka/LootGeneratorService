package com.example.lootgenerator.Services;

import com.example.lootgenerator.Models.Dto.PlaceDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlaceService {
    ResponseEntity<?> getPlaces();
    ResponseEntity<?> addPlace(PlaceDto placeDto);
    ResponseEntity<?> deletePlace(String id);
    ResponseEntity<?> updatePlace(String id, PlaceDto placeDto);
}
