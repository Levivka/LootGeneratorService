package com.example.lootgenerator.Services;

import org.springframework.stereotype.Service;

@Service
public interface ClassPropertiesService {
    String[] getNullProperties(Object source);
}
