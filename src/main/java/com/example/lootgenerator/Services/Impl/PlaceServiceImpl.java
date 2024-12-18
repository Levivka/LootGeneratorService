package com.example.lootgenerator.Services.Impl;

import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Place;
import com.example.lootgenerator.Repositories.PlaceRepository;
import com.example.lootgenerator.Services.ClassPropertiesService;
import com.example.lootgenerator.Services.PlaceService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final ClassPropertiesService classPropertiesService;

    @Override
    public ResponseEntity<?> getPlaces() {
        List<Place> places = placeRepository.findAll();
        if (places.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Места не найдены");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(places);
        }
    }

    @Override
    public ResponseEntity<?> addPlace(PlaceDto placeDto) {
        if (placeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("объект пустой");
        }
        else {
            Place place = new Place();
            place.setId(ObjectId.get());
            place.setName(placeDto.getName());
            place.setDescription(placeDto.getDescription());
            return ResponseEntity.status(HttpStatus.CREATED).body(placeRepository.save(place));
        }
    }

    @Override
    public ResponseEntity<?> deletePlace(String id) {
        ObjectId objectId = new ObjectId(id);
        if (!placeRepository.existsById(objectId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Место не найдено");
        }
        else {
            placeRepository.deleteById(objectId);
            return ResponseEntity.ok().build();
        }
    }

    @Override
    public ResponseEntity<?> updatePlace(String id, PlaceDto placeDto) {
        if (placeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("объект пустой");
        }
        else  {
            ObjectId objectId = new ObjectId(id);
            log.info(objectId.toString());
            Optional<Place> optionalPlace = placeRepository.findById(objectId);
            if (optionalPlace.isPresent()) {
               BeanUtils.copyProperties(placeDto, optionalPlace.get(), classPropertiesService.getNullProperties(placeDto));
               return ResponseEntity.status(HttpStatus.OK).body(placeRepository.save(optionalPlace.get()));
           }
           else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Место не найдено");
           }
        }
    }
}
