package com.example.lootgenerator.Services.Impl;

import com.example.lootgenerator.Models.Dto.TrinketDto;
import com.example.lootgenerator.Models.Trinkets;
import com.example.lootgenerator.Repositories.TrinketsRepository;
import com.example.lootgenerator.Services.TrinketsService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrinketsServiceImpl implements TrinketsService {
    private final TrinketsRepository trinketsRepository;

    @Override
    public ResponseEntity<?> generateTrinketsByCost(int cost) {
        ArrayList<Trinkets> trinkets = trinketsRepository.findAllByCost(cost);
        if (!trinkets.isEmpty() && trinkets.size() > 1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.OK).body(trinkets.get(random.nextInt(1, trinkets.size())));
        } else if (trinkets.size() == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(trinkets.get(0));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Безделушки с ценой " + cost + " не найдены");
        }
    }

    @Override
    public ResponseEntity<?> getAllTrinkets() {
        List<Trinkets> trinkets = trinketsRepository.findAll();
        if (trinkets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Безделушки не найдены");
        }
        else {
            return ResponseEntity.ok(trinkets);
        }
    }

    @Override
    public ResponseEntity<?> addTrinket(TrinketDto trinketDto) {
        Trinkets trinkets = new Trinkets();
        trinkets.setId(ObjectId.get());
        trinkets.setCost(trinketDto.getCost());
        trinkets.setName(trinketDto.getName());
        trinkets.setDescription(trinketDto.getDescription());
        trinkets.setCurrency(trinketDto.getCurrency());

        return ResponseEntity.status(HttpStatus.CREATED).body(trinketsRepository.insert(trinkets));
    }
}
