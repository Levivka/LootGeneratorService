package com.example.lootgenerator.Services;

import com.example.lootgenerator.Models.Dto.TypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TypeService {
    ResponseEntity<?> getTypes();
    ResponseEntity<?> addType(TypeDto typeDto);
    ResponseEntity<?> deleteType(String id);
    ResponseEntity<?> updateType(String id, TypeDto typeDto);
}
