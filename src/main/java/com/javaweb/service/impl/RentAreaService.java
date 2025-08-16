package com.javaweb.service.impl;

import com.javaweb.converter.RentAreaConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IRentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RentAreaService implements IRentAreaService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private RentAreaConverter rentAreaConverter;
    @Transactional
    @Override
    public void addRentArea(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
        rentAreaRepository.deleteByBuilding(buildingEntity);
        String[] rentAreas = buildingDTO.getRentArea().trim().split(",");
        for (String rentArea : rentAreas) {
            String rentAreaTrim = rentArea.trim();
            RentAreaEntity rentAreaEntity = rentAreaConverter.toRentAreaEntity(buildingEntity, Long.valueOf(rentAreaTrim));
            rentAreaRepository.save(rentAreaEntity);
        }
    }
}
