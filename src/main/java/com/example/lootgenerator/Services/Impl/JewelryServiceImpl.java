package com.example.lootgenerator.Services.Impl;

import com.example.lootgenerator.Models.Dto.JewelryPlaceDto;
import com.example.lootgenerator.Models.Dto.JewerlyDto;
import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Models.Jewelry;
import com.example.lootgenerator.Models.Place;
import com.example.lootgenerator.Models.Type;
import com.example.lootgenerator.Repositories.JewelryRepository;
import com.example.lootgenerator.Repositories.PlaceRepository;
import com.example.lootgenerator.Repositories.TypeRepository;
import com.example.lootgenerator.Services.JewelryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class JewelryServiceImpl implements JewelryService {
    private final JewelryRepository jewelryRepository;
    private final TypeRepository typeRepository;
    private final PlaceRepository placeRepository;

    @Override
    public ResponseEntity<?> getJewelry() {
        List<Jewelry> jewelryList = jewelryRepository.findAll();

        if (jewelryList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Драгоценности не найдены");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(jewelryList);
        }
    }

    @Override
    public ResponseEntity<?> addJewelry(JewerlyDto jewerlyDto) {
        if (jewerlyDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Объект пустой");
        }
        else {
            List<Type> typeList = new ArrayList<>();
            List<Place> placeList = new ArrayList<>();
            for (String type : jewerlyDto.getType()) {
                if (typeRepository.findByName(type).isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не найден тип " + type);
                }
                typeList.add(typeRepository.findByName(type).get());
            }
            for (String place : jewerlyDto.getPlace()) {
                if (placeRepository.findByName(place).isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не найдено место " + place);
                }
                placeList.add(placeRepository.findByName(place).get());
            }
            Jewelry jewelry = new Jewelry();
            jewelry.setId(new ObjectId());
            jewelry.setName(jewerlyDto.getName());
            jewelry.setDescription(jewerlyDto.getDescription());
            jewelry.setType(typeList);
            jewelry.setPlace(placeList);
            return ResponseEntity.status(HttpStatus.CREATED).body(jewelryRepository.save(jewelry));
        }
    }

    @Override
    public ResponseEntity<?> generateJewelry() {
        List<Jewelry> jewelryList = jewelryRepository.findAll();
        if (jewelryList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найдены драгоценности");
        }
        else return jewelryListAdd(jewelryList);
    }

    @Override
    public ResponseEntity<?> generateJewelry(TypeDto typeDto) {
        if (typeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Объект пустой");
        }
        else {
            List<Jewelry> jewelryList = jewelryRepository.findByType_Name(typeDto.getName());
            if (jewelryList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Тип " + typeDto.getName() + " не найден");
            }
            else return jewelryListAdd(jewelryList);
        }
    }

    @Override
    public ResponseEntity<?> generateJewelry(JewelryPlaceDto placeDto) {
        if (placeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Объект пустой");
        }
        else {
            List<Jewelry> jewelryList = jewelryRepository.findByPlace_Name(placeDto.getName());
            if (jewelryList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Место " + placeDto.getName() + " не найдено");
            }
            else return jewelryListAdd(jewelryList);
        }
    }

    private ResponseEntity<?> jewelryListAdd(List<Jewelry> jewelryList) {
        if (jewelryList.size() == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(jewelryList.get(0));
        }
        else {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.OK).body(jewelryList.get(random.nextInt(jewelryList.size())));
        }
    }
}
