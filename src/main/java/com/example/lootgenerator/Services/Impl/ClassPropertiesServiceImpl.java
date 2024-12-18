package com.example.lootgenerator.Services.Impl;

import com.example.lootgenerator.Services.ClassPropertiesService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

@Service
public class ClassPropertiesServiceImpl implements ClassPropertiesService {
    @Override
    public String[] getNullProperties(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Arrays.stream(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(name -> src.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }
}
