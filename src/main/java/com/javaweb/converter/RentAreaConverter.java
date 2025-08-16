package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {
    public RentAreaEntity toRentAreaEntity(BuildingEntity buildingEntity, Long value) {
        RentAreaEntity rentAreaEntity = new RentAreaEntity();
        rentAreaEntity.setValue(value);
        rentAreaEntity.setBuilding(buildingEntity);
        return rentAreaEntity;
    }
}
