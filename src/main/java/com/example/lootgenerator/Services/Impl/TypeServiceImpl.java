package com.example.lootgenerator.Services.Impl;

import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Models.Type;
import com.example.lootgenerator.Repositories.TypeRepository;
import com.example.lootgenerator.Services.ClassPropertiesService;
import com.example.lootgenerator.Services.TypeService;
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
@RequiredArgsConstructor
@Slf4j
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final ClassPropertiesService classPropertiesService;

    @Override
    public ResponseEntity<?> getTypes() {
        List<Type> types = typeRepository.findAll();
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Тип не найден");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(types);
        }
    }

    @Override
    public ResponseEntity<?> addType(TypeDto typeDto) {
        if (typeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("объект пустой");
        }
        else {
            Type type = new Type();
            type.setId(ObjectId.get());
            type.setName(typeDto.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(typeRepository.save(type));
        }
    }

    @Override
    public ResponseEntity<?> deleteType(String id) {
        ObjectId objectId = new ObjectId(id);

        if(!typeRepository.existsById(objectId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Тип не найден");
        }
        else {
            typeRepository.deleteById(objectId);
            return ResponseEntity.ok().build();
        }
    }

    @Override
    public ResponseEntity<?> updateType(String id, TypeDto typeDto) {
        if (typeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("объект пустой");
        }
        else {
            ObjectId objectId = new ObjectId(id);
            log.info(objectId.toString());
            Optional<Type> type = typeRepository.findById(objectId);
            if (type.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Тип не найден");
            }
            else {
                BeanUtils.copyProperties(typeDto, type.get(), classPropertiesService.getNullProperties(typeDto));
                return ResponseEntity.status(HttpStatus.OK).body(typeRepository.save(type.get()));
            }
        }
    }
}
